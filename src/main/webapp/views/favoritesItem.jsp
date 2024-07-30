<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<link src="css/itemList.css">
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<style type="text/css">
.itemList .item {
	margin-top: 10px;
	background-color: white;
}

.card-header {
	width: 100%;
	height: 250px;
}

.thumbnail {
	background-color: red;
	width: 100%;
	height: 100%;
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
	<div class="row itemList">
		<c:forEach var="item" items="${items}">
			<div class="col-sm-4 item">
				<div class="card">
					<div class="card-header">
						<div class="thumbnail">
							<a href="detailVideo?id=${item.video.getId()}"> <img
								style="height: 250px; width: 382px;" alt=""
								src="${item.video.getPoster()}">
							</a>
						</div>
					</div>
					<div class="card-body">
						<a style="text-decoration: none; color: black; font-weight: bold;"
							href="detailVideo?id=${item.video.getId()}">${item.video.getTitle()}</a>
					</div>
					<div class="card-footter" style="text-align: right;">
						<div>
							<a><button class="btn btn-primary">Like</button></a> <a
								href="shareVideo"><button class="btn btn-primary">share</button></a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>