package sgab.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import javax.lang.model.SourceVersion;
import sgab.model.dto.Obra;
import sgab.model.service.GestaoObras;

/**
 *
 * @author HP
 */
@WebServlet(name = "PesquisaObraAjax", urlPatterns = {"/PesquisaObraAjax"})
public class PesquisaObraAjax extends HttpServlet {

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
            GestaoObras gestaoObra = new GestaoObras();
            
            String nomeObra = request.getParameter("nomeObra");
            List<Obra> alvos = gestaoObra.pesquisarTituloAprox(nomeObra);
            
            if(alvos.size() > 0){
                for(Obra alvo : alvos){
                    out.print("<div class=\"acoes\"><span>"+alvo.getTitulo()+"</span><input type=\"button\""
                        + " value=\"Adicionar\" onclick=\"adicionaObra('"+ alvo.getTitulo()+"')\"></div>");
                }
            }  
            else
                out.print("<center>Nenhuma Obra com este nome encontrado.</center>"
                        + "<center><button type=\"button\" style=\"margin-top: 1em;\">"
                        + "<a href=\"/sgab/core/obras/menu.jsp\" >" +
                            "Obras" +
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