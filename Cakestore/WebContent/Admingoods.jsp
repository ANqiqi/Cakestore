<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>adminOrders</title>
	<style>
		*{
			font-size: 16px;
			margin:0 auto;
			padding:0;
			text-align:center;
			color: #34495e;
		}
		body{
			width: 100%;
			background:#faa
		}
		.mybody{
			width: 1200px;
			padding-top: 50px;
		}
		table{
			border: 1px #ddd solid;
			border-collapse:collapse;
		}
		.tableone{
		    width:1000px;
		}		
		td,th{
			border: 1px #ddd solid;
			padding: 8px;
		}
		.title{
			font-size: 18px;
		}
		a{
			text-decoration: none;			
		}
		.nav li a:link{
			color: #005599;
			height: 30px;
			width: 150px;
			display: block;
		}
		.nav li a:hover{
			color: #fff;
			background: #005599;			
		}
		.nav li a:active{
			color: #fff;
			background: #005599;
		}
		.nav{
			width: 150px;
			position: fixed;
			left: 20px;
			top: 300px;
		}
		li{
			list-style: none;
			line-height: 30px;
		}
		.footer li{
			display: inline;
			margin: 0 10px 0 10px;
			line-height: 30px;
			width: 100px;
			border: 1px #ddd solid;
			padding: 8px;
			border-radius: 3px;
		}
		.footer li a{
			display: inline-block;
			width: 100px;
			height: 30px;
		}
		.footer{
			margin-top: 30px;
		}
		.footer li a:hover{
			color: #22AADD;
		}
		#pagetwo,#pagethree{
			margin-top: 500px;
		}
	</style>
</head>
<body>
	<div class="mybody">	
	<!--pageone-->
		<div id="pageone">
			<!--导航-->
			<ul class="nav">
				<li><a href="admingoods/listAdminGoods?acpageIndex=1">蛋糕管理</a></li>
				<li><a href="user/list?aupageIndex=1">用户管理</a></li>
				<li><a href="adminorder/listAdminOrder?aopageIndex=1">订单管理</a></li>
				<li><a href="${ctx}/adminLogin.jsp">退出登录</a></li>
			</ul>
			
			<!-- 使用table来显示数据 -->
			<table class="tableone">
				<tr>
					<th class="title" colspan="9">商品列表</th>
				</tr>
				<tr>
					<th>蛋糕编号</th>
					<th>蛋糕名称</th>
					<th style="width:100px;">蛋糕信息</th>
					<th>蛋糕价格</th>
					<th>蛋糕图片</th>
					<th>蛋糕图片一</th>
					<th>蛋糕图片二</th>
					<th>蛋糕图片三</th>
					<th>管理</th>
				</tr>
		<c:forEach items="${admincakelist}" var="goods" varStatus="i">
				<!-- 将cake对象中的数据显示出来 -->
				<tr>
			        <td>${goods.goodsId }</td>
					<td>${goods.goodsName }</td>
					<td>${goods.goodsTypeId}</td>
					<td>${goods.goodsDescript }</td>
					<td>${goods.goodsPrice }</td>
					<td>${goods.goodsImagePath}</td>
					<td>${goods.sellCount}</td>
					<td>${goods.keyWord }</td>
					<td><a href="admingoods/deleteOneGoods?goodsid=${goods.goodsId}&acpageIndex=1">删除 </a></td>
				</tr>
			</c:forEach>
			<form action="admincake/updateOneCake">
	     	<tr>			
			<td><input type="text" name="cakeid" value="" style="width:80px"></td>
	        <td><input type="text" name="gname" value=""  style="width:110px"></td>
	        <td><input type="text" name="detail" value="" style="width:100px"></td>
	        <td><input type="text" name="price" value="" style="width:80px"></td>
	        <td><input type="text" name="listimg" value="" style="width:100px"> </td>
	        <td><input type="text" name="img1" value="" style="width:100px"></td>
	        <td><input type="text" name="img2" value="" style="width:100px"></td>
	        <td><input type="text" name="img3" value="" style="width:100px"></td>
	        <td><input type="submit" value="修改/增加" style="width:80px color:0000ff"></td>			      
	        </tr>
	     </form>
			</table>					
		</div>	
			<!-- 分页-->
			<ul class="footer">
			<li><a href="admincake/listAdminCake?acpageIndex=1">首页</a></li>
			<li><a href="admincake/listAdminCake?acpageIndex=${acpageIndex-1}">上一页</a>&nbsp;&nbsp;</li>
			<li><a href="admincake/listAdminCake?acpageIndex=${acpageIndex+1}">下一页</a>&nbsp;&nbsp;</li>
			<li><a href="admincake/listAdminCake?acpageIndex=${acpageCount}">页尾</a>&nbsp;&nbsp;</li>
			</ul>
	</div>
</body>
</html>