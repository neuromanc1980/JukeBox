<%-- 
    Document   : end
    Created on : 07-abr-2017, 20:13:03
    Author     : xaviB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <% 
                out.println(request.getAttribute("status"));
            %>
        </h1>
    </body>
</html>
