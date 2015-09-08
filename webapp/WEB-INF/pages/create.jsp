<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:url var="resources" value="/resources" scope="request" />

<html>
<head>
    <link href="${resources}/css/style.css" rel="stylesheet">
</head>
<body>
<h1>Create user</h1>
<form:form method="post" modelAttribute="newUser" action="createNewUser" >
    <div class="user-info">
        Name: <form:input type="text" name="name" required="true" path="name"/>
        Surname: <form:input type="text" name="surname" required="true" path="surname"/>
        <p class="bold">Company</p>
        Name: <form:input type="text" name="company" required="true" path="employer.company"/>
        City: <form:input type="text" name="companyCity" required="true" path="employer.address.city"/>
        Street: <form:input type="text" name="companyStreet" required="true" path="employer.address.street"/>
        Field of activity: <form:input type="text" name="companyActivity" required="true" path="employer.activityField"/>
        <p class="bold">Address</p>
        City: <form:input type="text" name="userCity" required="true" path="address.city"/>
        Street: <form:input type="text" name="userStreet" required="true" path="address.street"/>
        <p class="bold">Deposit</p>

        Amount: <form:input type="number" name="depositAmount" required="true" path="deposit.amount" />
        Currency: <form:input type="text" name="depositCurrency" required="true" path="deposit.currency"/>
    </div>
    <input type="submit" value="Save" class="btn"/>
</form:form>


</body>
</html>