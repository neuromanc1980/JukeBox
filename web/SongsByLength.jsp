<%-- 
    Document   : SongsByLength
    Created on : 21-abr-2017, 20:10:36
    Author     : xaviB
--%>

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
            <% List<Song> songs = (List<Song>) request.getAttribute("songs"); 
            if(songs.size()==0){ %>
            <h2>No songs found</h2>
            <% } else{
            %>
        <table border="1">
            
                <td>Song Name</td>
                <td>Album</td>
                <td>Rating</td>
                <td>Length</td>                    
            
        <%  
                
                for (Song t : songs) {
                        out.println("<tr><td>"+ t.getSongName()+"</td>");
                        out.println("<td>"+ t.getAlbum()+"</td>");
                        out.println("<td>"+ t.getRating()+"</td>");
                        out.println("<td>"+ t.getLength()+"</td></tr>");                        
                    }
            %>
        </table>
        <% } %>
        
        <br><a href="index.html">Volver</a>
        
    </body>
</html>
