<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<style>
    body {
      background-color: #f8f9fa;
    }
    .login-container {
      margin-top: 5%;
    }
  </style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@include file="userMenu1.jsp" %>
		
		<div class="row justify-content-center">
			<div class="col-md-4 login-container">
				<h2 class="text-center mb-4">Đăng Nhâp</h2>
				<form action="/Nhom6_ASM1/views/login" method="post">
					<div class="mb-3">
						<label for="username" class="form-label">Tên Đăng Nhập</label> <input
							type="text" class="form-control" name="id"
							placeholder="Enter username">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mật Khẩu</label> <input
							type="password" class="form-control" name="password"
							placeholder="Enter password">
					</div>
					<div>
						<h1>${message}</h1>
					</div>
					<button formaction="/Nhom6_ASM1/views/sign-in" type="submit" class="btn btn-primary w-100">Đăng
						Nhập</button>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>