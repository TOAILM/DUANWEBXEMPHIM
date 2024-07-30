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

.nav-link {
	color: green;
}

.custom-container {
	border: 2px solid orange;
	border-radius: 10px;
	padding: 20px;
	margin-top: 20px;
}

.form-group label {
	font-weight: bold;
}
</style>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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

		<div class="container custom-container">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active"
					id="video-edition-tab" data-bs-toggle="tab" href="#video-edition"
					role="tab" aria-controls="video-edition" aria-selected="true">Video
						Edition</a></li>
				<li class="nav-item"><a class="nav-link" id="video-list-tab"
					data-bs-toggle="tab" href="#video-list" role="tab"
					aria-controls="video-list" aria-selected="false">Video List</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane fade show active" id="video-edition"
					role="tabpanel" aria-labelledby="video-edition-tab">
					<form action="/Nhom6_ASM1/adminVideoManage/index" method="post">
						<div class="row mt-3">
							<div class="col-5">
								<img style="width: 514.33px; height: 288, 59px;"
									src="${video.poster}" alt="Poster" class="img-fluid">
							</div>
							<div class="col-7">

								<div class="form-group">
									<label for="youtube-id">YouTube ID</label> <input type="text"
										class="form-control" name="id" value="${video.id}">
								</div>
								<div class="form-group">
									<label for="video-title">Video Title</label> <input type="text"
										class="form-control" name="title" value="${video.title}">
								</div>
								<div class="form-group">
									<label for="video-title">Video Poster</label> <input
										type="text" class="form-control" name="poster"
										value="${video.poster}">
								</div>
								<div class="form-group">
									<label for="video-title">Video Link</label> <input type="text"
										class="form-control" name="link" value="${video.link}">
								</div>
								<div class="form-group">
									<label for="view-count">View Count</label> <input type="number"
										class="form-control" name="views" value="${video.views}">
								</div>
								<div class="form-group">
									<label>Premium Active</label><br>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="premium"
											${video.premium?'checked' : ''}> <label
											class="form-check-label" for="active">Active</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="premium"
											${video.premium? '' : 'checked'}> <label
											class="form-check-label" for="inactive">Inactive</label>
									</div>
								</div>
								<div class="form-group">
									<label>Status</label><br>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="active"
											${video.active?'checked' : ''}> <label
											class="form-check-label" for="active">Active</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="active"
											${video.active?'' : 'checked'}> <label
											class="form-check-label" for="inactive">Inactive</label>
									</div>
								</div>
								<div class="form-group">
									<label for="description">Description</label>
									<textarea class="form-control" name="description" rows="3">${video.description}</textarea>
								</div>
								<div class="alert">
									<c:if test="${not empty message}">
										<div class="alert alert-success">${message}</div>
									</c:if>
									<c:if test="${not empty error_id}">
										<div class="alert alert-danger">${error_id}</div>
									</c:if>
								</div>
								<div class="text-end mt-3">
									<button formaction="/Nhom6_ASM1/adminVideoManage/import"
										class="btn btn-primary d-inline-block">Import Excel</button>
									<button formaction="/Nhom6_ASM1/adminVideoManage/export"
										class="btn btn-primary d-inline-block">Export Excel</button>
									<button formaction="/Nhom6_ASM1/adminVideoManage/create"
										class="btn btn-primary d-inline-block">Create</button>
									<button formaction="/Nhom6_ASM1/adminVideoManage/update"
										class="btn btn-primary d-inline-block">Update</button>
									<button formaction="/Nhom6_ASM1/adminVideoManage/delete"
										class="btn btn-danger d-inline-block">Delete</button>
									<button formaction="/Nhom6_ASM1/adminVideoManage/reset"
										class="btn btn-secondary d-inline-block">Reset</button>
								</div>

							</div>
						</div>
					</form>
				</div>

				<div class="tab-pane fade" id="video-list" role="tabpanel"
					aria-labelledby="video-list-tab">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">YouTube ID</th>
								<th scope="col">Video Title</th>
								<th scope="col">View Count</th>
								<th scope="col">Status</th>
								<th scope="col">Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${items}">
								<tr>
									<td>${item.getId()}</td>
									<td>${item.getTitle()}</td>
									<td>${item.getViews()}</td>
									<td>${item.getActive() ? "TRUE" : "FALSE"}</td>
									<td><a
										href="/Nhom6_ASM1/adminVideoManage/edit/?id=${item.id }">Edit</a></td>
								</tr>
							</c:forEach>

							<!-- Add more rows for other videos -->
						</tbody>
					</table>
					<div class="text-end mt-3">
						<button class="btn btn-primary d-inline-block" type="button"><<</button>
						<button class="btn btn-primary d-inline-block" type="button"><</button>
						<button class="btn btn-primary d-inline-block" type="button">></button>
						<button class="btn btn-primary d-inline-block" type="button">>></button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>