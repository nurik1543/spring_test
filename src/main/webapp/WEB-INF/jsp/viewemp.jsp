<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="../css/main.css" var="jstlCss" />
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="template" items="${list}">
        <tr>
            <td>${template.id}</td>
            <td>${template.name}</td>
            <td>${template.description}</td>
            <td><a href="editemp/${template.id}">Edit</a></td>
            <td><a href="deleteemp/${template.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="empform">Add New Template</a>