<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<style type="text/css">
.videoScreen {
	width: 100%;
	height: 400px;
}

.image {
	width: 95%;
	height: 100px;
}

.newItems {
	margin-bottom: 10px;
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
		<%@include file="userMenu1.jsp"%>

		<div class="row">
			<div class="col-sm-7">
					<div class="card">
						<div class="card-header">
							<div class="videoScreen">
								<div class="videoScreen">
									<iframe style="width: 712px; height: 400px;"
										src="${videoClip[0].getLink()}"></iframe>
								</div>
							</div>
						</div>
						<div class="card-body">
							<h5 class="card-title">${videoClip[0].getTitle()}</h5>
							<p class="card-text">${videoClip[0].getDescription()}</p>
						</div>
						<div class="card-footer" style="text-align: right;">
							<form>
								<a href="#" class="btn btn-primary">Like</a> <a
									href="shareVideo" class="btn btn-primary">Share</a>
							</form>
						</div>
					</div>
			</div>

			<div class="col-sm-5">
				<c:forEach var="item" items="${items}">
					<div class="row newItems">
						<div class="col-sm-5">
							<div class=image>
								<a href="detailVideo?id=${item.getId()}"> <img
									style="width: 95%; height: 100px;" alt=""
									src="${item.getPoster()}"></a>
							</div>
						</div>
						<div class=col-sm-7>
							<a
								style="text-decoration: none; color: black; font-weight: bold;"
								href="detailVideo?id=${item.getId()}"> ${item.getTitle()} </a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>