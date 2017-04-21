/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.JukeboxBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.Album;
import persistence.Band;
import persistence.Song;

/**
 *
 * @author xaviB
 */
@WebServlet(name = "InsertSong", urlPatterns = {"/InsertSong"})
public class InsertSong extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    JukeboxBean miEjb;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           // Miramos si han pulsado el submit
            if ("alta".equals(request.getParameter("alta"))) {
                System.out.println("Entra1");
                String name = request.getParameter("name");
                String album = request.getParameter("album");
                double rating = Double.parseDouble(request.getParameter("rating"));
                BigDecimal rating1 = BigDecimal.valueOf(rating);
                System.out.println("================================");
                System.out.println(rating1);
                System.out.println("================================");
                double lenght = Double.parseDouble(request.getParameter("lenght"));
                BigDecimal lenght1 = BigDecimal.valueOf(lenght);
                System.out.println(lenght1);
                Song b = new Song(name, rating1, lenght1);
                Album a = miEjb.getAlbumByName(album);
                b.setAlbum(a);
                
                if (miEjb.insertSong(b)){
                    request.setAttribute("status", "Song created succesfully");
                    
                }   else { request.setAttribute("status", "Error in song creation");}
                request.getRequestDispatcher("/end.jsp").forward(request, response);  
            } 
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
