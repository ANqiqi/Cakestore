<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>adminLogin</title>
	</head>
	<style>
		body{
			margin: 0 auto;
			padding: 0;
			text-align: center;
			background:#faa;		
		}
		.center{
			background:#2A2A2A;
			width: 520px;		
			color: #fff;
			border: 5px #2A2A2A solid;
			border-radius:15px ;
		}
		form{
			background: #fff;
			color: #555;
			width: 500px;
			line-height: 3.5em;
			font-size: 14px;
			margin-bottom: 10px;
			padding-top:5px;
		}
		.inputstyle{
			width: 170px;
			font-size: 16px;
			color: gray;
			height: 38px;
			border-radius: 6px;
			border: solid #dce4ec 2px;
		}
		.firsttd{
			width: 192px;
		}
		.subbtn{
			width: 100px;
			margin: 15px 0 8px 0;
			font-size: 16px;
			color: #fff;
			font-weight: bold;
			padding: 4px;
			background: #0088BB;
			border: #0088BB 2px solid;
			border-radius: 4px;
		}
		.subbtn:active{
			background: #07a;
			border: #005599 2px solid;
		}
		center{
			margin-top: 200px;
		}
	</style>
	<body>
		<center>
			<div class="center">
				<h1>欢迎进入蛋糕店管理员系统</h1>
				<form action="admin/adminLogin">
					<table>
						<tr>
						<td class="firsttd">请输入用户名:</td>
						<td><input class="inputstyle" type="text" name="adminname" value="admin" /></td>
						</tr>
						<tr>
						<td class="firsttd">请输入密码:</td>
						<td><input class="inputstyle" type="password" name="password"  /></td>
						</tr>
						<tr>
							<td class="firsttd"></td>
							<td style=" text-align: right;"><input class="subbtn" type="submit"  value="登录" name="pageIndex"/></td>
						</tr>
					</table>
				</form>
			</div>
		</center>
	</body>
</html>