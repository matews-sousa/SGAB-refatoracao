package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.UsuarioTipo;
import sgab.model.service.GestaoPessoasService;

public class LeitorController {
    public static String cadastrar(HttpServletRequest request) {
        String jsp = "";
        try {
            String login = request.getParameter("login");
            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            if(login != null || "".equals(login)){
                Pessoa pessoa = gestaoPessoasService.pesquisarPorLogin(login);
                if(pessoa != null){
                    pessoa.setTipo(UsuarioTipo.LEITOR);
                    jsp = "/core/autores/certo.jsp";
                }else{
                    String erro = "Nenhuma pessoa encontrada com o login informado";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                }
            }else{
                String erro = "Login invalido!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}

