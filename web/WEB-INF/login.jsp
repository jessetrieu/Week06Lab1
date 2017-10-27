<%-- 
    Document   : login
    Created on : Oct 16, 2017, 8:08:43 AM
    Author     : 579957
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="trieu"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <sait:debug>
	Remote Host: ${pageContext.request.remoteHost}<br />
	Session ID: ${pageContext.session.id}
        </sait:debug>

        <h1>Remember Me Login Page</h1>
        <trieu:login></trieu:login>
        ${errorMessage}
        ${logout}
    </body>
</html>

