<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.container {
		width: 1080px;
		min-height: 800px;
		margin: 0 auto;
	}
</style>
<link rel="stylesheet" href="css/shareVideo.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Insert title here</title>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@include file="userMenu1.jsp" %>
	
		<div class="card" style="width: 500px;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item"><h3>Send video to your friend</h3></li>
				<li class="list-group-item">YOUR FRIEND'S EMAIL? <input
					type="text" class="form-control" aria-label="Username"
					aria-describedby="addon-wrapping"></li>
				<li class="list-group-item"><button type="button"
						class="btn btn-info" style="float: right;">Send</button></li>
			</ul>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>