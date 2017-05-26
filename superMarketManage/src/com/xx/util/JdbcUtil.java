package com.xx.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public abstract class JdbcUtil {

	private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

	private static final Properties p = new Properties();

	protected static List<Class<?>> basicClasses = new ArrayList<Class<?>>();

	public static boolean isDebug = true; // 是否调试，调试为true，可以多输出一些调试信息

	static {
		InputStream is = null;
		try {
			// 从配置文件读取配置，存入Properties 变量p
			is = JdbcUtil.class.getResourceAsStream("/config.properties");
			p.load(is);
			String driver = p.getProperty("jdbc.driver");
			Class.forName(driver);
		} catch (Throwable e) {
			// 应用程序初始化错误
			throw new ExceptionInInitializerError(e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}

		// 存储基本的类型，将来这些类型可以统一转换
		basicClasses.add(Long.class);
		basicClasses.add(Short.class);
		basicClasses.add(Integer.class);
		basicClasses.add(Character.class);
		basicClasses.add(Double.class);
		basicClasses.add(Float.class);
		basicClasses.add(Byte.class);
		basicClasses.add(Boolean.class);
		basicClasses.add(String.class);
		basicClasses.add(BigInteger.class);
		basicClasses.add(BigDecimal.class);
		basicClasses.add(Date.class);

	}

	/**
	 * 创建一个新的数据库连接
	 * 
	 * @return
	 */
	public static Connection newConnection() {
		try {
			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");
			Connection conn = DriverManager.getConnection(url, username, password);
			// conn.setAutoCommit(false);
			if (isDebug) {
				System.out.println("open connection: " + conn);
			}
			return conn;
		} catch (Exception e) {
			throw new RuntimeException("error when getConnection", e);
		}
	}

	/**
	 * 开始事务
	 */
	public static void begin() {
		try {
			//setAutoCommit:true|false  true:自动提交事务  false:手动提交事务
			getConnection().setAutoCommit(false);//设置事务的提交方式为手动提交
		} catch (SQLException e) {
			throw new RuntimeException("error when begin transaction", e);
		}
	}

	/**
	 * 提交事务
	 */
	public static void commit() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			throw new RuntimeException("error when commit transaction", e);
		}
	}

	/**
	 * 回滚事务
	 */
	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			throw new RuntimeException("error when rollback transaction", e);
		}
	}

	/**
	 * 释放资源，包括ResultSet与Statement
	 * 
	 * @param rs
	 * @param stmt
	 */
	public static void release(Object... resources) {
		if (resources != null) {
			for (Object r : resources) {
				if (r instanceof ResultSet) {
					ResultSet rs = (ResultSet) r;
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
			}
			for (Object r : resources) {
				if (r instanceof Statement) {
					Statement stmt = (Statement) r;
					try {
						stmt.close();
					} catch (SQLException e) {
					}
				}
			}
		}
	}

	public static void close() {
		Connection conn = conns.get();
		if (conn != null) {
			try {
				conn.close();
				if (isDebug) {
					System.out.println("close non-transactional connection: " + conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conns.set(null);
		}
	}

	private static Connection getConnection() {
		Connection conn = conns.get();
		if (conn == null) {
			conn = newConnection();
			conns.set(conn);
		}
		return conn;
	}

	/**
	 * 通用update,delete,insert方法
	 * 
	 * @param sql
	 * @param params
	 * @return 影响行数
	 */
	public static int update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			prepare(psmt, params);
			if (isDebug) {
				System.out.println("SQL: [" + sql + "]");
				System.out.println("SQL params: " + Arrays.toString(params));
			}
			return psmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			release(null, psmt);
		}
	}

	/**
	 * 通用insert方法(需要获得主键值时使用)
	 * 
	 * @param sql
	 * @param pkColumnName
	 *            主键列的名字
	 * @param params
	 * @return
	 */
	public static int insert(String sql, String pkColumnName, Object... params) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql, new String[] { pkColumnName });
			prepare(psmt, params);
			if (isDebug) {
				System.out.println("SQL: [" + sql + "]");
				System.out.println("SQL params: " + Arrays.toString(params));
			}
			psmt.executeUpdate();
			rs = psmt.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			release(null, psmt);
		}
	}

	/**
	 * 给preparedStatement中所有?占位符赋值
	 * 
	 * @param psmt
	 * @param params
	 * @throws SQLException
	 */
	private static void prepare(PreparedStatement psmt, Object... params) throws SQLException {
		if (params != null) {
			int i = 1;
			for (Object o : params) {
				if (o instanceof java.util.Date) {
					java.util.Date d = (java.util.Date) o;
					psmt.setTimestamp(i, new Timestamp(d.getTime()));
				} else {
					psmt.setObject(i, o);
				}
				i++;
			}
		}
	}

	private static Map<Class<?>, Map<String, PropertyDescriptor>> all = new ConcurrentHashMap<Class<?>, Map<String, PropertyDescriptor>>();

	/**
	 * 得到某一实体列中属性反射信息的map集合：key是属性名(全小写), value是该属性的反射信息 <br>
	 * 为了避免每次都获取这些信息(比较耗时)，用了一个all集合来缓存上次的结果
	 * 
	 * @param beanClass
	 * @return
	 * @throws IntrospectionException
	 */
	private static Map<String, PropertyDescriptor> getPropertyDescriptors(Class<?> beanClass)
			throws IntrospectionException {
		Map<String, PropertyDescriptor> map = all.get(beanClass);
		if (map == null) {
			map = new HashMap<String, PropertyDescriptor>();
			PropertyDescriptor[] pds = Introspector.getBeanInfo(beanClass).getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				map.put(pd.getName().toLowerCase(), pd);
			}
			all.put(beanClass, map);
		}
		return map;
	}

	/**
	 * 通用查询方法，可以用来查询单个对象或单值
	 * 
	 * @param <T>
	 * @param beanClass
	 *            要封装的对象类型
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数值
	 * @return
	 */
	public static <T> T findOne(Class<T> beanClass, String sql, Object... params) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			prepare(psmt, params);
			if (isDebug) {
				System.out.println("SQL: [" + sql + "]");
				System.out.println("SQL params: " + Arrays.toString(params));
			}
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (beanClass.isPrimitive() || basicClasses.contains(beanClass)) {
					return processOneCloumn(beanClass, rs, 1);
				} else {
					Map<String, PropertyDescriptor> pds = getPropertyDescriptors(beanClass);
					ResultSetMetaData rsmd = rs.getMetaData();
					T beanInstance = beanClass.newInstance();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						String colName = rsmd.getColumnLabel(i);
						// logger.debug("colName:" + colName);
						PropertyDescriptor pd = pds.get(colName.toLowerCase());
						if (pd != null) {
							Object colValue = processOneCloumn(pd.getPropertyType(), rs, i);
							pd.getWriteMethod().invoke(beanInstance, colValue);
						}
					}
					return beanInstance;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			release(rs, psmt);
		}
	}

	/**
	 * 处理结果集中每一列
	 * 
	 * @param beanClass
	 * @param rs
	 * @param index
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	private static <T> T processOneCloumn(Class<T> beanClass, ResultSet rs, int index) throws SQLException {
		Object o = rs.getObject(index);
		if (!beanClass.isPrimitive() && rs.wasNull()) {
			return null;
		}
		if (beanClass == int.class || beanClass == Integer.class) {
			return (T) Integer.valueOf(rs.getInt(index));
		}
		if (beanClass == long.class || beanClass == Long.class) {
			return (T) Long.valueOf(rs.getLong(index));
		}
		if (beanClass == short.class || beanClass == Short.class) {
			return (T) Short.valueOf(rs.getShort(index));
		}
		if (beanClass == double.class || beanClass == Double.class) {
			return (T) Double.valueOf(rs.getDouble(index));
		}
		if (beanClass == float.class || beanClass == Float.class) {
			return (T) Float.valueOf(rs.getFloat(index));
		}
		if (beanClass == boolean.class || beanClass == Boolean.class) {
			return (T) Boolean.valueOf(rs.getBoolean(index));
		}
		if (beanClass == byte.class || beanClass == Byte.class) {
			return (T) Byte.valueOf(rs.getByte(index));
		}
		if (beanClass == String.class) {
			return (T) rs.getString(index);
		}
		if (beanClass == Date.class) {
			return (T) rs.getTimestamp(index);
		}
		if (beanClass == BigDecimal.class) {
			return (T) rs.getBigDecimal(index);
		}
		return (T) o;
	}

	/**
	 * 通用查询方法，可以用来查询对象集合或值集合
	 * 
	 * @param <T>
	 * @param beanClass
	 *            要封装的对象类型
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数值
	 * @return
	 */
	public static <T> List<T> findList(Class<T> beanClass, String sql, Object... params) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			prepare(psmt, params);
			if (isDebug) {
				System.out.println("SQL: [" + sql + "]");
				System.out.println("SQL params: " + Arrays.toString(params));
			}
			rs = psmt.executeQuery();
			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				if (beanClass.isPrimitive() || basicClasses.contains(beanClass)) {
					list.add(processOneCloumn(beanClass, rs, 1));
				} else {
					Map<String, PropertyDescriptor> pds = getPropertyDescriptors(beanClass);
					ResultSetMetaData rsmd = rs.getMetaData();
					T beanInstance = beanClass.newInstance();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						String colName = rsmd.getColumnLabel(i);
						// logger.debug("colName:" + colName);
						PropertyDescriptor pd = pds.get(colName.toLowerCase());
						if (pd != null) {
							Object colValue = processOneCloumn(pd.getPropertyType(), rs, i);
							pd.getWriteMethod().invoke(beanInstance, colValue);
						}
					}
					list.add(beanInstance);
				}
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			release(rs, psmt);
		}
	}

	public static <T, K extends Serializable> Map<K, T> findIdMap(Class<K> keyClass, Class<T> valueClass, String sql,
			Object... params) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			prepare(psmt, params);
			if (isDebug) {
				System.out.println("SQL: [" + sql + "]");
				System.out.println("SQL params: " + Arrays.toString(params));
			}
			rs = psmt.executeQuery();
			Map<K, T> map = new LinkedHashMap<K, T>();
			while (rs.next()) {
				if ((valueClass.isPrimitive() || basicClasses.contains(valueClass))
						&& (keyClass.isPrimitive() || basicClasses.contains(keyClass))) {
					K key = processOneCloumn(keyClass, rs, 1);
					T value = processOneCloumn(valueClass, rs, 2);
					map.put(key, value);
				} else {
					throw new RuntimeException(
							"only support two column selection(column 1 for key, column 2 for value)");
				}
			}
			return map;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			release(rs, psmt);
		}
	}

	/**
	 * 通用查询方法，用来执行分页查询(Oracle)
	 * 
	 * @param <T>
	 * @param beanClass
	 *            要封装的对象类型
	 * @param sql
	 *            sql语句
	 * @param page
	 *            页号
	 * @param rows
	 *            页面大小
	 * @param params
	 *            参数值
	 * @return
	 */
	public static <T> List<T> findList(Class<T> beanClass, int page, int rows, String sql, Object... params) {
		String subsql = "select * from (select rownum r, a.* from (" + sql + ") a where rownum <=?) where r > ?";
		Object[] p = null;
		if (params == null || params.length == 0) {
			p = new Object[2];
			p[0] = page * rows;
			p[1] = (page - 1) * rows;
		} else {
			p = new Object[params.length + 2];
			for (int i = 0; i < params.length; i++) {
				p[i] = params[i];
			}
			p[params.length] = page * rows;
			p[params.length + 1] = (page - 1) * rows;
		}
		return findList(beanClass, subsql, (Object[]) p);
	}

	/**
	 * 获得某一序列的下个值
	 * 
	 * @param sequenceName
	 *            序列名
	 * @return
	 */
	public static int getSequenceVal(String sequenceName) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select " + sequenceName + ".nextval from dual");
			if (isDebug) {
				System.out.println("SQL: [select " + sequenceName + ".nextval from dual]");
			}
			rs = psmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			release(rs, psmt);
		}
	}

}
