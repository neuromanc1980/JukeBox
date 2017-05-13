<%-- 
    Document   : BandsByName
    Created on : 21-abr-2017, 20:10:36
    Author     : xaviB
--%>

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
            <% List<Album> albums = (List<Album>) request.getAttribute("albums"); 
            if(albums.size()==0){ %>
            <h2>No albums found</h2>
            <% } else{
            %>
        <table border="1">
            
                <td>Album Name</td>
                <td>Band</td>
                <td>Genre</td>
                <td>Discography</td>
                <td>Year</td>
            
        <%  
                
                for (Album t : albums) {
                        out.println("<tr><td>"+ t.getAlbumName()+"</td>");
                        out.println("<td>"+ t.getBand().getBandName()+"</td>");
                        out.println("<td>"+ t.getGenre()+"</td>");
                        out.println("<td>"+ t.getDiscography()+"</td>");
                        out.println("<td>"+ t.getYear()+"</td>");
                    }
            %>
        </table>
        <% } %>
        
        <br><a href="index.html">Volver</a>
        
    </body>
</html>
