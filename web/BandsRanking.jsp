<%-- 
    Document   : BandsByName
    Created on : 21-abr-2017, 20:10:36
    Author     : xaviB
--%>

<%@page import="persistence.BandDTO"%>
<%@page import="persistence.AlbumDTO"%>
<%@page import="persistence.Album"%>
<%@page import="java.util.List"%>
<%@page import="persistence.Song"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
            <% List<BandDTO> bands = (List<BandDTO>) request.getAttribute("bands"); 
            if(bands.size()==0){ %>
            <h2>No bands found</h2>
            <% } else{
            %>
        <table border="1">
            
                <td>Band Name</td>
                <td>Year</td>
                <td>Genre</td>
                <td>Country</td>
                <td>Rating</td>
            
        <%  
                
                for (BandDTO t : bands) {
                        out.println("<tr><td>"+ t.getBand().getBandName()+"</td>");
                        out.println("<td>"+ t.getBand().getYear()+"</td>");
                        out.println("<td>"+ t.getBand().getGenre()+"</td>");
                        out.println("<td>"+ t.getBand().getCountry()+"</td>");
                        out.println("<td>"+ t.getSuma()+"</td></tr>");
                    }
            %>
        </table>
        <% } %>
        
        <br><a href="index.html">Volver</a>
        
    </body>
</html>
