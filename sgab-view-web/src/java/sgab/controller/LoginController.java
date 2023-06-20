package sgab.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import sgab.model.dto.Pessoa;
import sgab.model.service.GestaoPessoasService;

public class LoginController {

    public static String logar(HttpServletRequest request) {

        String jsp = "";

        try {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            GestaoPessoasService manterPessoa = new GestaoPessoasService();
            Pessoa pessoa = manterPessoa.pesquisarConta(login, senha);

            if (pessoa == null) {
                String erro = "Pessoa nao encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            } else {               
                // usuário logado no sistema
                request.getSession().setAttribute("usuario", pessoa);
                jsp = "/core/menu.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static void validarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pessoa usuario = (Pessoa) request.getSession().getAttribute("usuario");
        if (usuario == null) {
            //Redirecionando pagina
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }
}
