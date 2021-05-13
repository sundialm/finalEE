<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.iitu.javaee.DB.Publication" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<%--
  Created by IntelliJ IDEA.
  User: Meruert
  Date: 02.04.2021
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../functions/head.jsp"%>
    <title>Admin Page</title>
</head>
<body>
<%@include file="../functions/navbar_admin.jsp"%>
<%@include file="../functions/verticalNavbar.jsp"%>
<%
    ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
%>

<div >
    <div class="row mt-5">
        <ul class="col sm-12" style="width: 100%">
            <%
                String success = request.getParameter("success");
                String error = request.getParameter("error");

                if (success != null) {
            %>
            <div class="alert alert-success" role="alert">
                Publication added successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
                if (error != null) {
            %>
            <div class="alert alert-danger" role="alert">
                Publication not added!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>


            <ul class="list-group">
                <li class="list-group-item">
                    <h1 style="  display: inline;">Publications</h1>
                    <button class="btn btn-success float-right" data-toggle="modal" data-target="#LanguageModal">ADD NEW</button>
                </li>
            </ul>

            <table class="table">

                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>Description</th>
                    <th>Rating</th>
                    <th style="float: right">OPERATIONS</th>
                </tr>

                <%
                    if (publications != null) {
                        for (Publication publication : publications) {
                %>
                <tr>
                    <th><%=publication.getId()%></th>
                    <th><%=publication.getName()%></th>
                    <th style="width: 600px;"><%=publication.getDescription()%></th>
                    <th><%=publication.getRating()%></th>
                    <th>
                        <form action="/deletePublication?id=<%=publication.getId()%>" method="post">
                            <button class="btn btn-danger float-right">DELETE</button>
                        </form>
                        <button class="btn btn-primary float-right mr-2 "
                                onclick="fillToUpdatePublicationModal(<%=publication.getId()%>,'<%=publication.getName()%>', '<%=publication.getDescription()%>', '<%=publication.getRating()%>')"
                                data-toggle="modal" data-target="#updateLanguageModal">
                            Edit
                        </button>

                    </th>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </ul>
    </div>

    <div class="modal fade" id="LanguageModal" tabindex="-1" role="dialog" aria-labelledby="updateLeagueModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="POST" action="/addPublication" >
                    <div class="modal-header">
                        <h5 class="modal-title" >Add Publication</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="update_name">Name:</label>
                            <input type="text" class="form-control"  name="name" placeholder="Name of language...">
                        </div>
                        <div class="form-group">
                            <label >Description:</label>
                            <br>
                            <textarea name="description"  style="width: 100%" rows="10" placeholder="Description..."></textarea>
                        </div>
                        <div class="form-group">
                            <label >Rating:</label>
                            <input type="text" class="form-control"  name="rating" placeholder="Rating...">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-dark">ADD</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="updateLanguageModal" tabindex="-1" role="dialog" aria-labelledby="updateLeagueModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="POST" action="/updatePublication" id="update_form">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateLeagueModalLabel">Edit Language</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="update_id" name="update_id">
                        <div class="form-group">
                            <label for="update_name">Name:</label>
                            <input type="text" class="form-control" id="update_name" name="update_name" placeholder="Name of language...">
                        </div>
                        <div class="form-group">
                            <label >Description:</label>
                            <br>
                            <textarea name="update_description"  style="width: 100%" rows="10" placeholder="Description..." id="update_description"></textarea>
                        </div>
                        <div class="form-group">
                            <label >Rating:</label>
                            <input type="text" class="form-control"  name="update_rating" placeholder="Rating..." id = "update_rating">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-dark"  onclick="changeAction('/update_asdasd')">SAVE</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        const fillToUpdatePublicationModal = (id, name, description, rating) =>{
            document.getElementById("update_id").value = id;
            document.getElementById("update_name").value = name;
            document.getElementById("update_description").value = description;
            document.getElementById("update_rating").value = rating;

        }
    </script>
</div>

</body>
</html>
