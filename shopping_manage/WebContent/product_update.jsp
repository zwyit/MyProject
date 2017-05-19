<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品新增页面</title>
<script>
  function back(){
	  window.history.back();
  }
</script>

</head>
<body bgcolor="pink">

     <form action="UpdateProductServlet" method="post">
     <input type="hidden" id="id" name="id" value="${product.id}"/>
           <table align="center">
               <tr>
                  <td>商品名称</td>
                  <td><input type="text" id="name" name="name" value="${product.name}" size="25"/></td>
               </tr>
               <tr>
                  <td>商品编号</td>
                  <td><input type="text" id="code" name="code" value="${product.code}" size="25"/></td>
               </tr>
               <tr>
                  <td>商品价格</td>
                  <td><input type="text" id="price" name="price" value="${product.price}" size="25"/></td>
               </tr>
               <tr>
                  <td>商品数量</td>
                  <td><input type="text" id="count" name="count" value="${product.count}" size="25"/></td>
               </tr>
               <tr>
                  <td>商品状态</td>
                  <td>
                  <c:if test="${product.status==0}">
                    <input type="radio" id="pstauts" name="status" value="0" checked="checked"/>上架
                    <input type="radio" id="pstauts2" name="status" value="1"/>下架
                   </c:if>
                   <c:if test="${product.status==1}">
                    <input type="radio" id="pstauts" name="status" value="0"/>上架
                    <input type="radio" id="pstauts2" name="status" value="1"  checked="checked"/>下架
                   </c:if>
                  </td>
               </tr>
               <tr>
                  <td>商品类别</td>
                  <td>
                    <select name="category_id">
                       <option value="1" selected="selected">服饰类</option>
                    </select>
                  </td>
               </tr>
               <tr>
                  <td>商品品牌</td>
                  <td>
                     <select name="brand_id">
                       <option value="1" selected="selected">海澜之家</option>
                    </select>
                  
                  </td>
               </tr>
               <tr>
                  <td>商品描述</td>
                  <td>
                    <textarea rows="10" cols="27" id="remark" name="remark">${product.product_des}</textarea>
                  </td>
               </tr>
               <tr>
                  <td colspan="2">
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="back()"/>
                  </td>
               
               </tr>
          </table>
     </form>

</body>
</html>