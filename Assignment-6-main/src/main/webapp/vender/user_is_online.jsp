<%@ page import="kz.iitu.javaee.DB.User" %>
<%
    boolean online = false;
    User user_is_online = (User) request.getSession().getAttribute("user");
    if (user_is_online != null)
        online = true;
%>
