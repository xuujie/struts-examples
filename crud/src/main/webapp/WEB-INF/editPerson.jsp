<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"/>
    <style>td {
        white-space: nowrap;
    }</style>
    <title><c:if test="${person==null || person.personId == null}">
        <c:set var="title" value="Add new person"/>
    </c:if>
        <c:if test="${person!=null && person.personId != null}">
            <c:set var="title" value="Update person"/>
        </c:if></title>
</head>
<body>
<div class="titleDiv"><spring:message code="application.title"/></div>
<h1>${title}</h1>
<form:form action="/save" method="post" modelAttribute="person">
    <table class="borderAll">
        <tr>
            <th>First Name:</th>
            <td><form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <th>Last Name:</th>
            <td><form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <th>Email:</th>
            <td><form:input path="email"/>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <th>Phone Number:</th>
            <td><form:input path="phoneNumber"/>
                <form:errors path="phoneNumber" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <th>Sports:</th>
            <td><form:select path="sport" items="${sports}"/></td>
        </tr>
        <tr>
            <th>Gender:</th>
            <td><form:select path="gender" items="${genders}"/></td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>
                <form:select path="country.countryId">
                    <form:options items="${countries}" itemLabel="countryName" itemValue="countryId"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Over 21:</th>
            <td><form:checkbox path="over21"/></td>
        </tr>
        <tr>
            <th>Car Models:</th>
            <td><form:checkboxes path="carModels" items="${carModels}"/>
                <form:errors path="carModels" cssClass="error"/>
            </td>
        </tr>
    </table>
    <form:hidden path="personId"/>

    <input type="submit" value="<spring:message code="button.label.submit"/>"/>
    <input type="button" value="<spring:message code="button.label.cancel"/>" onclick="window.location.href='/list'"/>
</form:form>
</body>
</html>

