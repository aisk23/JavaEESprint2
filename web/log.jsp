<%@ page import="kz.bitlab.techorda.db.DBConnection" %>
<html>
<head>
    <title>Login Page</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container align-baseline">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="login.jsp">Bitlab Shop</a>
            <button class=" navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Top Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">New Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">By Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Sign in</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<form action="/firstPage" method="post">
    <%
        if (!DBConnection.isCorrect()){
    %>
    <div class="container">
        <div class="row mt-3">
            <div class="col-12">
                <div class="alert alert-danger text-center mx-auto" role="alert" style="width: 400px">
                    May be incorrect login or password!!!
                </div>
            </div>
        </div>
    </div>
    <%
            DBConnection.setCorrect(true);
        }
    %>
    <div class="container text-center">
        <div class="row mt-3">
            <div class="col-12">
                <label>Email: </label>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <input type="email" class="form-control-sm" name="email" placeholder="write email" style="border: none">
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label>Password: </label>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <input type="password" class="form-control-sm" name="password" placeholder="write password" style="border: none">
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <button class="form-control-sm btn-success">Login</button>
            </div>
        </div>
    </div></form>
</body>
</html>