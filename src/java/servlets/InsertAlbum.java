/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.JukeboxBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.Album;
import persistence.Band;

/**
 *
 * @author xaviB
 */
@WebServlet(name = "InsertAlbum", urlPatterns = {"/InsertAlbum"})
public class InsertAlbum extends HttpServlet {
    @EJB
    JukeboxBean miEjb;
    
    public static final String STATUS_OK = "Insert Error";
    public static final String STATUS_ERROR ="Insert successful";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet InsertAlbum</title>");          
            // Miramos si han pulsado el submit
            if ("alta".equals(request.getParameter("alta"))) {
                out.println("Entra");
                String name = request.getParameter("name");
                String genre = request.getParameter("genre");
                String band = request.getParameter("band");
                String discography = request.getParameter("discography");
                int year = Integer.parseInt(request.getParameter("year"));
                
                Album b = new Album(name, genre, discography, year);
                b.setBand(miEjb.getBandByName(band));
                if (b.getYear()<=year){
                if (miEjb.insertAlbum(b, band).equals("ok")){
                    out.println("Insertado correctamente");
                } else miEjb.insertAlbum(b, band);
                } else out.println("El álbum no puede pertenecer a la banda<br/>");
                //Botón de volver
                
            } 
            
                       
            out.println("<form  method=\"POST\">");
            out.println("<br>Name: <input type=\"text\" name=\"name\" required>");
            
            out.println("<br>Genre: <select name=\"genre\" required>");
            out.println("<option value=\"Rock\">Rock</option>");            
            out.println("<option value=\"Metal\">Metal</option>");            
            out.println("<option value=\"Jazz\">Jazz</option>");
            out.println("<option value=\"HipHop\">HipHop</option>");
            out.println("<option value=\"Classic\">Classic</option>");            
            out.println("<option value=\"Pop\">Pop</option>");            
            out.println("<option value=\"Techno\">Techno</option>");            
            out.println("<option value=\"House\">House</option>");
            out.println("</select>");
            
            out.println("Band: <select name=\"band\" required>");

            //todos los trainers
            List<Band> bands = miEjb.SelectAllBands();

            for (Band t : bands) {
                    out.println("<option value=\""+ t.getBandName()+"\">"+t.getBandName()+"</option>");
                }
            out.println("</select>");

            
            out.println("<br>Discography: <input type=\"text\" name=\"discography\" required>");
            out.println(" <br>");
            out.println("<br>Year: <input type=\"number\" name=\"year\" required>");
            out.println(" <br>");
            out.println("<input type=\"submit\" name = \"alta\" value=\"alta\">");
            out.println("<br></form> <br>");
            
            
            out.println("<br><a href=\"InsertData.html\">Volver</a>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertAlbum at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
