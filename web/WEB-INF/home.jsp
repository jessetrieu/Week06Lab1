<%-- 
    Document   : home.jsp
    Created on : Oct 16, 2017, 8:08:32 AM
    Author     : 579957
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <sait:debug>
	Remote Host: ${pageContext.request.remoteHost}<br />
	Session ID: ${pageContext.session.id}
        </sait:debug>

        <h1>Home Page</h1>
        <div>Hello ${userName}.</div>
        <a href="login?action=logout">Log out</a>
    </body>
</html>
