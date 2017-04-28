


<%@page import="beans.JukeboxBean"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="java.util.List"%>
<%@page import="persistence.Band"%>
<%@page import="persistence.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%          
//        @EJB
//    JukeboxBean miEjb = new JukeboxBean();       %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Album</title>
    </head>
    <body>
        <h1>Insert Album</h1>
        
       

        <form  method="POST" action="InsertMusician">
            <br>Name: <input type="text" name="name" required>
            
            <br>Role: <select name="role" required>
            <option value="Guitarrist">Guitarrist</option>"          
            <option value="Bass">Bass</option>         
            <option value="Drummer">Drummer</option>
            <option value="Singer">Singer</option>
            <option value="Keyboard">Keyboard</option>  
            <option value="Violinist">Violinist</option> 
            <option value="Tambourinist">Tambourinist</option> 
            </select>
            
            Band: <select name="band" required>
                
               
            <%  
                List<Band> bands = (List<Band>) request.getAttribute("bands");

                for (Band t : bands) {
                        out.println("<option value=\""+ t.getBandName()+"\">"+t.getBandName()+"</option>");
                    }
            %>
                </select>
                
            <br>Birth year: <input type="number" name="birthdate" min="1000" required>
             <br>
            <br>Birthplace: <input type="text" name="birthplace" required>
             <br>
            <input type="submit" name = "alta" value="alta">
            <br></form> <br>
            
            
            <br><a href="index.html">Volver</a>
        
    </body>
</html>
