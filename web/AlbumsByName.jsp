<%-- 
    Document   : BandsByName
    Created on : 21-abr-2017, 20:10:36
    Author     : xaviB
--%>

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
            <% List<AlbumDTO> albums = (List<AlbumDTO>) request.getAttribute("albums"); 
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
                <td>Rating</td> 
            
        <%  
                
                for (AlbumDTO t : albums) {
                        out.println("<tr><td>"+ t.getAlbum().getAlbumName()+"</td>");
                        out.println("<td>"+ t.getAlbum().getBand().getBandName()+"</td>");
                        out.println("<td>"+ t.getAlbum().getGenre()+"</td>");
                        out.println("<td>"+ t.getAlbum().getDiscography()+"</td>");
                        out.println("<td>"+ t.getAlbum().getYear()+"</td>");
                        out.println("<td>"+ t.getSuma()+"</td></tr>");
                    }
            %>
        </table>
        <% } %>
        
        <br><a href="index.html">Volver</a>
        
    </body>
</html>
