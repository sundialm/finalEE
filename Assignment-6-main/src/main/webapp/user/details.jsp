<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.iitu.javaee.DB.Language" %>
<%@ page import="kz.iitu.javaee.DB.Publication" %>

<%--
  Created by IntelliJ IDEA.
  User: Meruert
  Date: 02.04.2021
  Time: 19:30 не доработана
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../functions/head.jsp" %>
    <title>DETAILS</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light" style="background-color:white">
    <ul class="navbar-nav " style="width: 100%">
        <li class="nav-item" style="width: 33%">
            <%
                ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("languages");
            %>
        </li>

        <li class="nav-item" style="width: 33%">
            <h3><a href="/" style="color: rgba(221,27,26,0.89);">Song Lyrics PORTAL</a></h3>
        </li>

        <li class="nav-item " style="width: 33%">
            <button type="button" class="btn btn-outline-secondary float-right ">SIGN UP</button>
        </li>
    </ul>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:rgba(48,100,60,0.89)">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <%
                ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
                if (publications != null) {
                    for (Publication pub : publications) {
            %>
            <li class="nav-item active">
                <input type="hidden" name="pub_id" value="pub_id">
                <a href="/home?id=<%=pub.getId()%>" class="nav-link"><%=pub.getName()%>
                </a>
            </li>
            <%
                    }
                }
            %>
        </ul>
    </div>
</nav>

</div>
</body>
</html>
