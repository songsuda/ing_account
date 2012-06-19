<%-- 
    Document   : listAllAccount
    Created on : Jun 19, 2012, 12:43:55 AM
    Author     : roofimon
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Insert title here</title>
    </head>
    <body>
        <p>List All Account</p>
        <c:forEach var="account" items="${allAccount}">
            <p>Account Detail: <c:out value="${account.code}"/>, <c:out value="${account.name}"/><p>
            </c:forEach>
    </body>
</html>
