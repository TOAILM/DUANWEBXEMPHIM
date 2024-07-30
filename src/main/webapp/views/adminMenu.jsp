<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.header {
	background-color: black;
	color: yellow;
	padding: 10px;
}

.nav-link {
	color: green;
}

.nav-link.btn {
	padding: 10px 20px;
	border-radius: 30px;
	font-size: 18px;
	font-weight: bold;
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<header class="header">
		<div class="container-fluid">
			<div class="row">
				<div class="col-auto">
					<h1>Administration Tool</h1>
				</div>
				<div class="col"></div>
				<div class="col-auto">
					<ul class="nav">
						<li class="nav-item"><a class="nav-link btn"
							aria-current="page" href="/Nhom6_ASM1/adminLayout">Home</a></li>
						<li class="nav-item"><a class="nav-link btn" href="/Nhom6_ASM1/adminVideoManage/index">Videos</a>
						</li>
						<li class="nav-item"><a class="nav-link btn" href="/Nhom6_ASM1/adminUserManage/index">Users</a>
						</li>
						<li class="nav-item"><a class="nav-link btn" href="/Nhom6_ASM1/adminReport/index">Reports</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>