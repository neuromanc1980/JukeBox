<%-- 
    Document   : InsertBand
    Created on : 21-abr-2017, 18:43:09
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
        <h1>Insert Band</h1>
        
        <form  method="POST" action="InsertBand">
            <br>Name: <input type="text" name="name" required>
            
            <br>Genre: <select name="genre" required>
            <option value="Rock">Rock</option>"          
            <option value="Metal">Metal</option>         
            <option value="Jazz">Jazz</option>
            <option value="HipHop">HipHop</option>
            <option value="Classic">Classic</option>          
            <option value="Pop">Pop</option>          
            <option value="Techno">Techno</option>           
            <option value="House">House</option>
            </select>
             <br>
             Country <input type="text" name="country" required>
            <br>Year: <input type="number" name="year" min="1000" required>
             <br>
            <input type="submit" name = "alta" value="alta">
            <br></form> <br>
            
            
            <br><a href="InsertData.html">Volver</a>
    </body>
</html>
