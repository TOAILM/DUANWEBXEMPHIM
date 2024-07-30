<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<style type="text/css">
.container {
	width: 1080px;
	min-height: 800px;
	margin: 0 auto;
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
	<div class="container">
		<%@include file="adminMenu.jsp"%>


		<form>
			<nav>
				<div class="nav nav-tabs" id="nav-tab" role="tablist">
					<button class="nav-link active" id="nav-home-tab"
						data-bs-toggle="tab" data-bs-target="#nav-home" type="button"
						role="tab" aria-controls="nav-home" aria-selected="true">Favorites</button>
					<button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab"
						data-bs-target="#nav-profile" type="button" role="tab"
						aria-controls="nav-profile" aria-selected="false">Favorites
						User</button>
					<button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab"
						data-bs-target="#nav-contact" type="button" role="tab"
						aria-controls="nav-contact" aria-selected="false">Share
						Friends</button>
				</div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Video Title</th>
									<th>Favorites Count</th>
									<th>Latest Date</th>
									<th>Oldest Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="result" items="${resultList}">
									<tr>
										<td>${result[0]}</td>
										<!-- VideoId -->
										<td>${result[1]}</td>
										<!-- số lần -->
										<td>${result[2]}</td>
										<!-- minLikeDate -->
										<td>${result[3]}</td>
										<!-- maxLikeDate -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">
					<div class="d-flex align-items-center">
						<h3 class="me-2">VideoTitle</h3>
						<select class="form-select" aria-label="Default select example">
							<option selected>Video 1</option>
							<option value="1">Video 2</option>
							<option value="2">Video 3</option>
						</select>
					</div>

					<table class="table">
						<thead>
							<tr>
								<th>User name</th>
								<th>Full name</th>
								<th>Email</th>
								<th>Favorites Date</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>LongHL</td>
								<td>LongHoang</td>
								<td>longhlhps28113@gmail.com</td>
								<td>2024-03-25</td>
							</tr>
							<tr>
								<td>HoangLa</td>
								<td>NgoBaKha</td>
								<td>hoangla123@gamil.com</td>
								<td>2024-03-25</td>
							</tr>
							<!-- Add more rows for additional users -->
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="nav-contact" role="tabpanel"
					aria-labelledby="nav-contact-tab">
					<div class="d-flex align-items-center">
						<h3 class="me-2">VideoTitle</h3>
						<select class="form-select" aria-label="Default select example">
							<option selected>Video 1</option>
							<option value="1">video 2</option>
							<option value="2">Video 3</option>
						</select>
					</div>

					<table class="table">
						<thead>
							<tr>
								<th>Sender Name</th>
								<th>Sender Email</th>
								<th>Receiver Email</th>
								<th>Sent Date</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>PhuLe</td>
								<td>phule123@gmail.com</td>
								<td>poly@gmail.com</td>
								<td>2024-03-25</td>
							</tr>
							<tr>
								<td>huanRose</td>
								<td>buixuanhuan123@gmail.com</td>
								<td>poly@gamil.com</td>
								<td>2024-03-25</td>
							</tr>
							<!-- Add more rows for additional users -->
						</tbody>
					</table>
				</div>
			</div>
		</form>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>