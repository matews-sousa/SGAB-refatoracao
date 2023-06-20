package sgab.controller;

import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import sgab.model.service.GestaoDevolucoes;

public class DevolucaoController{
    public static String GravaDevolucao(HttpServletRequest request) {
        String jsp = "";
        
        try{
            Long id = Long.parseLong(request.getParameter("id"));
            GestaoDevolucoes gestao = new GestaoDevolucoes();

            gestao.RegistrarDevolucoes(id);

            jsp = "/core/autores/certo.jsp";
            
        }catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        
        return jsp;
    }
}