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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.Band;
import persistence.Musician;

/**
 *
 * @author xaviB
 */
@WebServlet(name = "InsertMusician", urlPatterns = {"/InsertMusician"})
public class InsertMusician extends HttpServlet {

    @EJB
    JukeboxBean miEjb;

    public static final String STATUS_OK = "Insert Error";
    public static final String STATUS_ERROR = "Insert successful";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            if ("alta".equals(request.getParameter("alta"))) {
                String name = request.getParameter("name");
                String role = request.getParameter("role");
                String band = request.getParameter("band");
                String birthplace = request.getParameter("birthplace");
                int year = Integer.parseInt(request.getParameter("birthdate"));

                Musician b = new Musician(name, role, year, birthplace);
                Band c = miEjb.getBandByName(band);
                b.setBand(miEjb.getBandByName(band));

                    if (miEjb.insertMusician(b, band).equals("ok")) {
                        request.setAttribute("status", "Musician inserted successfully");
                    } else {
                        request.setAttribute("status", "Musician already exists");
                    }

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
