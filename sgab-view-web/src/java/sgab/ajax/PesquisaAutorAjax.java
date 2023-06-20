/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sgab.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sgab.model.dto.Autor;
import sgab.model.service.GestaoAutor;

/**
 *
 * @author HP
 */
@WebServlet(name = "PesquisaAutorAjax", urlPatterns = {"/PesquisaAutorAjax"})
public class PesquisaAutorAjax extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            GestaoAutor gestaoAutor = new GestaoAutor();
            
            String nomeAutor = request.getParameter("nomeAutor");
            Autor alvo = gestaoAutor.pesquisarNome(nomeAutor);
            
            if(alvo != null)
                out.print("<div class=\"acoes\"><span>"+alvo.getNome()+"</span><input type=\"button\""
                        + " value=\"Adicionar\" onclick=\"adicionaAutor('"+ alvo.getNome()+"')\"></div>");
            else
                out.print("<center>Nenhum Autor com este nome encontrado.</center>"
                        + "<center><button type=\"button\" style=\"margin-top: 1em;\">"
                        + "<a href=\"/sgab/core/autores/menu.jsp\" >" +
                            "Autores" +
                        "</a></button></center>");
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
