<%-- 
    Document   : BandsByName
    Created on : 21-abr-2017, 20:10:36
    Author     : xaviB
--%>

<%@page import="java.util.List"%>
<%@page import="persistence.Band"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
            
        <table border="1">
            
                <td>Band Name</td>
                <td>Creation Year</td>
                <td>Genre</td>
                <td>Country</td>                    
            
        <%  
                List<Band> bands = (List<Band>) request.getAttribute("bands");
                
                for (Band t : bands) {
                        out.println("<tr><td>"+ t.getBandName()+"</td>");
                        out.println("<td>"+ t.getYear()+"</td>");
                        out.println("<td>"+ t.getGenre()+"</td>");
                        out.println("<td>"+ t.getCountry()+"</td></tr>");                        
                    }
            %>
        </table>
        
        <br><a href="InsertData.html">Volver</a>
        
    </body>
</html>
