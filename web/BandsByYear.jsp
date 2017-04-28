<%-- 
    Document   : BandsByYear
    Created on : 28-abr-2017, 18:46:13
    Author     : xaviB
--%>

<%@page import="java.util.List"%>
<%@page import="persistence.Band"%>
<%@page import="persistence.Band"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Band> bands = (List<Band>) request.getAttribute("bands"); 
            if(bands.size()==0){ %>
            <h2>No bands found</h2>
            <% } else{
            %>
       <table border="1">
            
                <td>Band Name</td>
                <td>Creation Year</td>
                <td>Genre</td>
                <td>Country</td>                    
            
        <% 
                
                for (Band t : bands) {
                        out.println("<tr><td>"+ t.getBandName()+"</td>");
                        out.println("<td>"+ t.getYear()+"</td>");
                        out.println("<td>"+ t.getGenre()+"</td>");
                        out.println("<td>"+ t.getCountry()+"</td></tr>");                        
                    }
            %>
        </table>
        <% } %>
        
        <br><a href="index.html">Volver</a>
        
    </body>
</html>
