


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
        
        <%            
            List <Band> Bands = (List<Band>) request.getAttribute("band");
            //List<Band> bands  = miEjb.SelectAllBands();

            for (Band t : Bands) {%>
                    <option value="<% t.getBandName(); %>">
                        <% t.getBandName();
                        %></option>
                <% } %>
            </select>   
        
            <form  method="POST">
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
            
            Band: <select name="band" required>"
                
            <br>Discography: <input type="text" name="discography" required>"
             <br>"
            <br>Year: <input type="number" name="year" required>"
             <br>"
            <input type="submit" name = "alta" value="alta">"
            <br></form> <br>"
            
            
            <br><a href="InsertData.html">Volver</a>"
        
    </body>
</html>
