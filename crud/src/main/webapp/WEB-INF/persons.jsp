<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"/>
    <title><spring:message code="label.persons"/></title>
</head>
<body>
<div class="titleDiv"><spring:message code="application.title"/></div>
<h1><spring:message code="label.persons"/></h1>
<a href="/add">Add New Person</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><spring:message code="person.firstName"/></th>
        <th><spring:message code="person.lastName"/></th>
        <th><spring:message code="person.email"/></th>
        <th><spring:message code="person.phoneNumber"/></th>
        <th><spring:message code="person.sport"/></th>
        <th><spring:message code="person.gender"/></th>
        <th><spring:message code="person.country"/></th>
        <th><spring:message code="person.over21"/></th>
        <th><spring:message code="person.carModels"/></th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${persons}" var="person" varStatus="status">
        <tr class="${status.index % 2 == 0 ? "even":"odd"}">
            <td class="nowrap">${person.firstName}</td>
            <td class="nowrap">${person.lastName}</td>
            <td class="nowrap">${person.email}</td>
            <td class="nowrap">${person.phoneNumber}</td>
            <td class="nowrap">${person.sport}</td>
            <td class="nowrap">${person.gender}</td>
            <td class="nowrap">${person.country.countryId} - ${person.country.countryName}</td>
            <td class="nowrap">
                <c:if test="${person.over21}">
                    <span style="color:green; font-size: large;">&#x2714;</span>
                </c:if>
                <c:if test="${!person.over21}">
                    <span style="color:red; font-size: large;">&#x2717;</span>
                </c:if>
            </td>
            <td class="nowrap">
                <c:forEach items="${person.carModels}" var="carModel">
                    ${carModel}<br/>
                </c:forEach>
            </td>
            <td class="nowrap">
                <a href="/edit/${person.personId}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/delete/${person.personId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
