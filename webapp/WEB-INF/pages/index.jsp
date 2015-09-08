<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resources" value="/resources" scope="request" />

<html>
<head>
    <link href="${resources}/css/style.css" rel="stylesheet">
</head>
<body>
<h1>User list</h1>

<table border="2">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Work</th>
        <th>Address</th>
        <th>Deposit</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.employer}</td>
            <td>${user.address}</td>
            <td>${user.deposit}</td>
            <td><a href="/edit/${user.id}">Edit</a>
                <a href="/delete/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/create" class="btn">create user</a>

</body>
</html>