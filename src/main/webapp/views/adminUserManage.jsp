<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.btn-edit {
	width: 60px
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
		<%@include file="adminMenu.jsp" %>
		<div class="container custom-container">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active"
					id="video-edition-tab" data-bs-toggle="tab" href="#video-edition"
					role="tab" aria-controls="video-edition" aria-selected="true">User
						Edition</a></li>
				<li class="nav-item"><a class="nav-link" id="video-list-tab"
					data-bs-toggle="tab" href="#video-list" role="tab"
					aria-controls="video-list" aria-selected="false">User List</a></li>
			</ul>

			<div class="tab-content">

				<div class="tab-pane fade show active" id="video-edition"
					role="tabpanel" aria-labelledby="video-edition-tab"
					style="height: 330px">
					<form action="/Nhom6_ASM1/adminUserManage/index" method="post">
						<div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Username</span>
							<input name="id" type="text" class="form-control"
								value="${user.id}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default">
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Password</span>
							<input name="password" type="password" class="form-control"
								value="${user.password}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default">
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Fullname</span>
							<input name="fullname" type="text" class="form-control"
								value="${user.fullname}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default">
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Email</span>
							<input name="email" type="email" class="form-control"
								value="${user.email}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default">
						</div>
						<div class="div_role">
							<label>Role:</label> <input id="admin" type="radio" name="role" value="admin"
								${user.admin?'checked':''} aria-label="Sizing example input">
							<label for="admin">Admin</label> <input id="user" type="radio"
								name="role" value="user" ${user.admin?'':'checked'}
								aria-label="Sizing example input"> <label for="user">User</label>
						</div>
						<div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Hạn</span>
							<input name="premiumCount" type="text" class="form-control"
								value="${user.premiumCount}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" readonly="readonly">
						</div>
						<button formaction="/Nhom6_ASM1/adminUserManage/create"
							class="btn btn-outline-success">Create</button>
						<button formaction="/Nhom6_ASM1/adminUserManage/update"
							class="btn btn-outline-warning">Update</button>
						<button formaction="/Nhom6_ASM1/adminUserManage/delete"
							class="btn btn-outline-danger">Delete</button>
						<button formaction="/Nhom6_ASM1/adminUserManage/reset"
							class="btn btn-outline-info">Reset</button>
					</form>
				</div>

				<div class="tab-pane fade" id="video-list" role="tabpanel"
					aria-labelledby="video-list-tab">
					<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="nav-home"
							role="tabpanel" aria-labelledby="nav-home-tab">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>User Name</th>
										<th>Password</th>
										<th>Full Name</th>
										<th>Email</th>
										<th>Role</th>
										<th>Ngày hết hạn</th>
										<th></th>
										<th></th>


									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${users}">
										<tr>
											<td>${user.getId()}</td>
											<td>${user.getPassword()}</td>
											<td>${user.getFullname()}</td>
											<td>${user.getEmail()}</td>
											<td>${user.isAdmin()? "Admin" : "User"}</td>
											<td>${user.getPremiumCount()}</td>
											<td><a class="editdelete"
												href="/Nhom6_ASM1/adminUserManage/edit/?id=${user.id} "> edit </a></td>
											<td><a class="editdelete"
												href="/Nhom6_ASM1/adminUserManage/delete/?id=${user.id}"> delete </a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="tab-pane fade" id="nav-profile" role="tabpanel"
							aria-labelledby="nav-profile-tab">...</div>
					</div>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>