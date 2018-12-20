<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/lib/bootstrap.min.css"/>
    <%--<link rel="stylesheet" type="text/css" href="/css/custom/main.css"/>--%>
</head>
<body >
<div class="container">
    <div class="row">
        <div class="col-sm-0 col-md-2 col-lg-3">
        </div>
        <div class="col-sm-12 col-md-8 col-lg-6">
            <h1>Items List</h1>
            <table class="table table-dark" border="2" width="70%" cellpadding="2">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                <c:forEach var="template" items="${list}">
                    <tr>
                        <td>${template.id}</td>
                        <td>${template.name}</td>
                        <td>${template.description}</td>
                        <td><a href="edit/${template.id}" class="btn btn-primary">Edit</a></td>
                        <td><a href="delete/${template.id}" class="btn btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <a href="add" class="btn btn-success btn-lg"">Add New</a>
        </div>
        <div class="col-sm-0 col-md-2 col-lg-3">
        </div>
    </div>
</div>


</body>
</html>