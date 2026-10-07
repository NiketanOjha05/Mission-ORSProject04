<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String succ = ServletUtility.getSuccessMessage(request);
	String error = ServletUtility.getErrorMessage(request);
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Add Role</h1>

		<h3 style="color: green"><%=succ%></h3>
		<h3 style="color: red"><%=error%></h3>

		<form action="<%=ORSView.ROLE_CTL%>" method="post">

			<table>

				<tr>

					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="Enter First Name" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName"
						placeholder="Enter Last Name" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("lastName", request)%></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type=name=
						"login"
						placeholder="Enter Login Id" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("login", request)%></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter an password"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></td>
				</tr>

				<tr>
					<th>ConfirmPassword</th>
					<td><input type="password" name="confirmPassword" value=""
						placeholder="re-enter your password"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></td>
				</tr>

				<tr>
					<th>Role</th>
					<td><select name='roleId'>
							<option selected value=''>------------Select-------------</option>
							<option value='1'>Admin</option>
							<option value='2'>Student</option>
							<option value='3'>Faculty</option>
							<option value='4'>College</option>
							<option value='5'>KIOSK</option>
					</select></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("roleId", request)%></td>
				</tr>


				<tr>
					<th>Gender</th>
					<td><select name='gender'>
							<option selected value=''>------------Select-------------</option>
							<option value='female'>female</option>
							<option value='male'>male</option>
					</select></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("gender", request)%></td>
				</tr>

				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("dob", request)%></td>
				</tr>

				<tr>

					<th></th>

					<td><input type="submit" name="operation"
						value="<%=BaseCtl.OP_SAVE%>"></td>


				</tr>



			</table>

		</form>

	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>