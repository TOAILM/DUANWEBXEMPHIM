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
            <h2 class="text-center mb-4">Cập nhật tài khoản</h2>
            <form action="editProfile" method="post">
                <div class="mb-3">
                    <label for="id" class="form-label">ID:</label>
                    <input type="text" class="form-control" id="id" name="id">
                     <c:if test="${not empty messageid}">
                        <div > <p style="color: red;"> ${messageid}</p></div>	
                    </c:if>
                </div>	
                <div class="mb-3">
                    <label for="fullname" class="form-label">Fullname:</label>
                    <input type="text" class="form-control" id="fullname" name="fullname">
                    
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" class="form-control" id="email" name="email">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Mật khẩu:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <button type="submit" class="btn btn-primary w-100">Cập nhật tài khoản</button>
                <div class="alert" style="margin-left: 100px">
                    <c:if test="${not empty messagecapnhat}">
                        <div > <p style="color: blue;"> ${messagecapnhat}</p></div>	
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
