/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.JukeboxBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.Band;

/**
 *
 * @author xaviB
 */
public class InsertBand extends HttpServlet {
    
    @EJB
    JukeboxBean miEjb;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertBand</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Insert Band</h1>");
            
            // Miramos si han pulsado el submit
            if ("alta".equals(request.getParameter("alta"))) {
                String name = request.getParameter("name");
                String genre = request.getParameter("genre");
                String country = request.getParameter("country");
                int year = Integer.parseInt(request.getParameter("year"));
                
                Band b = new Band(name, year, genre, country);
                
                if (miEjb.insertBand(b)){
                    out.println("Insertado correctamente");
                    
                }   else out.println("Ya existía!");
            } 
            
                       
            out.println("<form  method=\"POST\">");
            out.println("<br>Nombre: <input type=\"text\" name=\"name\" required>");
            out.println("<br>Foundation year: <input type=\"number\" max=\"2017\" min=\"0\" placeholder=\"1980\"name=\"year\" required>");
            
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
            
            
            out.println("<br>Country: <input type=\"text\" name=\"country\" required>");
            out.println(" <br>");
            out.println("<input type=\"submit\" name = \"alta\" value=\"alta\">");
            out.println("<br></form> <br>");
            
            
            
            
            
            
            
            
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
