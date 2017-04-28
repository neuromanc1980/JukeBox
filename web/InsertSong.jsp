<%-- 
    Document   : InsertSong
    Created on : 21-abr-2017, 18:59:14
    Author     : xaviB
--%>

<%@page import="persistence.Album"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert Song</h1>
       <form  method="POST" action="InsertSong">
            <br>Name: <input type="text" name="name" required>
            
            Album: <select name="album" required>
                
               
            <%  
                List<Album> albums = (List<Album>) request.getAttribute("albums");

                for (Album t : albums) {
                        out.println("<option value=\""+ t.getAlbumName()+"\">"+ t.getAlbumName() + " -- " + t.getBand()+"</option>");
                    }
            %>
                </select>
                
            <br>Rating: <input type="number" name="rating" step="0.1" max="10" min="0" required>
             <br>
            <br>Lenght: <input type="number" name="lenght" step="0.1" min="0.1" required>
             <br>
            <input type="submit" name = "alta" value="alta">
            <br></form> <br>
            
            
            <br><a href="index.html">Volver</a>
    </body>
</html>
