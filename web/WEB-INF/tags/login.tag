<%-- 
    Document   : login
    Created on : Oct 16, 2017, 8:37:18 AM
    Author     : 579957
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="userName"%>
<%@attribute name="save" %>

<%-- any content can be specified here e.g.: --%>
<form action="login" method="POST">
    <div>Username: <input type="text" name="userName" value="${userName}"></div>
    <div>Password: <input type="password" name="password"></div>
    <input type="submit" value="Submit">
    <div><input type="checkbox" name="save" ${save}> Remember me</div>
</form>