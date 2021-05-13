<%@ page import="kz.iitu.javaee.DB.User" %><%--
  Created by IntelliJ IDEA.
  User: Meruert
  Date: 12.05.2021
  Time: 03:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/functions/head.jsp" %>
    <title>Profile</title>
</head>

<body>

<%
    User user = (User) request.getAttribute("user");
%>
<div class="container">

    <%@include file="navbar.jsp"%>


    <br><br>

    <div class="row">
        
        <%@include file="profile_info.jsp"%>

        <div class="col-5">

            <%
                String success = request.getParameter("success");
                String error = request.getParameter("error");

                if (success != null) {
            %>
            <div class="alert alert-success" role="alert">
                Successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
                if (error != null) {
            %>
            <div class="alert alert-danger" role="alert">
                Not Successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <form action="/editProfile" method="post">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <h2>Edit Profile</h2>

                <div class="form-group">
                    <label>EMAIL:</label>
                    <input type="text" name="email" class="form-control" value="<%=user.getEmail()%>">
                </div>
                <div class="form-group">
                    <label>FUUL NAME:</label>
                    <input type="text" name="full_name" class="form-control" value="<%=user.getFull_name()%>">
                </div>
                <div class="form-group">
                    <label>BIRTHDATE:</label>
                    <input type="date" name="birth_date" class="form-control" value="<%=user.getBirth_date()%>">
                </div>

                <div class="form-group">
                    <button class="btn btn-success" type="submit">UPDATE PROFILE</button>
                </div>
            </form>

            <br><br>
            <form action="/updatePicture" method="post">
            <h2>Edit Picture</h2>
                <input type="hidden" name="id" value="<%=user.getId()%>">

            <div class="form-group">
                <label>Picture URL:</label>
                <input type="text" name="picture_url" class="form-control" value="<%=user.getPicture_url()%>">
            </div>
            <div class="form-group">
                <button class="btn btn-success" type="submit">UPDATE URL</button>
            </div>
            </form>

            <form action="/updatePassword" method="post">

                <h2>Update Password</h2>
                <input type="hidden" name="email" value="<%=user.getEmail()%>">
                <input type="hidden" name="id" value="<%=user.getId()%>">

                <div class="form-group">
                    <label>Old Password:</label>
                    <input type="text" name="old_password" class="form-control" >
                </div>
                <div class="form-group">
                    <label>New Password:</label>
                    <input type="text" name="new_password" class="form-control">
                </div>
                <div class="form-group">
                    <label>Re-New Password:</label>
                    <input type="text" name="re_new_password" class="form-control">
                </div>

                <div class="form-group">
                    <button class="btn btn-success" type="submit">UPDATE PROFILE</button>
                </div>
            </form>

        </div>

    </div>
</div>
</body>
</html>
