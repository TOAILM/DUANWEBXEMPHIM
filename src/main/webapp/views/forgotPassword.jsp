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

.forgot-password-container {
	margin-top: 5%;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@include file="userMenu1.jsp"%>
	
		<div class="row justify-content-center">
			<div class="col-md-4 forgot-password-container">
				<h2 class="text-center mb-4">Quên Mật khẩu</h2>
				<form>
					<p class="text-center">Nhập Email để chúng có thể gửi mật khẩu
						cho bạn</p>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email"
							placeholder="Enter email">
					</div>
					<button type="submit" class="btn btn-primary w-100">Khôi
						phục mật khẩu</button>
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