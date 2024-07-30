<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đổi Mật Khẩu</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
    }
    .change-password-container {
        margin-top: 5%;
    }
</style>
</head>
<body>
<div class="container">
    <%@include file="userMenu1.jsp"%>
    <div class="row justify-content-center">
        <div class="col-md-4 change-password-container">
            <h2 class="text-center mb-4">Đổi Mật Khẩu</h2>
            <form action="changePassword" method="post">
                <div class="mb-3">
                    <label for="id" class="form-label">ID:</label>
                    <input type="text" class="form-control" id="id" name="id">
                </div>
                <div class="mb-3">
                    <label for="current-password" class="form-label">Mật khẩu hiện tại:</label>
                    <input type="password" class="form-control" id="current-password" name="current-password">
                </div>
                <div class="mb-3">
                    <label for="new-password" class="form-label">Mật khẩu mới:</label>
                    <input type="password" class="form-control" id="new-password" name="new-password">
                </div>
                <div class="mb-3">
                    <label for="confirm-password" class="form-label">Xác nhận mật khẩu mới:</label>
                    <input type="password" class="form-control" id="confirm-password" name="confirm-password">
                </div>
                <button type="submit" class="btn btn-primary w-100">Đổi Mật Khẩu</button>
                <div class="alert">
                    <c:if test="${not empty message}">
                        <div >${message}</div>
                    </c:if>
                    <c:if test="${not empty error}">
                        <div >${error}</div>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
