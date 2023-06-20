package sgab.controller;

import sgab.model.exception.PersistenciaException; 
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import sgab.model.dto.Assunto;
import sgab.model.service.GestaoAssuntoService;

public class AssuntoController {

    public static String listar(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAssuntoService gestaoAssunto = new GestaoAssuntoService();
            List<Assunto> listAssunto = gestaoAssunto.pesquisarAtivos();
            if (listAssunto != null) {
                request.setAttribute("listAssunto", listAssunto);
                jsp = "/core/assunto/listar.jsp";
            } else {
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String alterar(HttpServletRequest request) {
        String jsp = "";
        try {
            Long assuntoId = Long.parseLong(request.getParameter("assuntoId"));
            GestaoAssuntoService manterAssunto = new GestaoAssuntoService();
            Assunto assunto = manterAssunto.pesquisarPorId(assuntoId);
            if (assunto != null) {
                request.setAttribute("assunto", assunto);
                jsp = "/core/assunto/alterar.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Assunto!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }    

    public static String excluir(HttpServletRequest request) {
        String jsp = "";
        try {
            Long assuntoId = Long.parseLong(request.getParameter("assuntoId"));
            GestaoAssuntoService gestaoAssunto = new GestaoAssuntoService();
            Assunto assunto = gestaoAssunto.pesquisarPorId(assuntoId);
            try {
                gestaoAssunto.excluir(assunto);
                jsp = AssuntoController.listar(request);
            }
            catch(PersistenciaException ex) {
                String erro = "Ocorreu erro ao Excluir Assunto!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }    
    
    public static String gravarAlteracao(HttpServletRequest request) {
        String jsp = "";
        try {
            Long idAssunto = Long.parseLong(request.getParameter("assuntoId"));
            String nome = request.getParameter("nome");

            Assunto assunto = new Assunto(nome);
            assunto.setId(idAssunto);

            GestaoAssuntoService gestaoAssunto = new GestaoAssuntoService();
            try {
                gestaoAssunto.atualizar(assunto);
                jsp = AssuntoController.listar(request);
            } 
            catch(PersistenciaException ex) {
                String erro = "Nao foi possivel gravar a alteracao desse registro";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }    
    
    public static String gravarInsercao(HttpServletRequest request) {
        String jsp = "";
        try {
            String nome = request.getParameter("nome");

            Assunto assunto = new Assunto(nome);

            GestaoAssuntoService gestaoAssunto = new GestaoAssuntoService();
            Long assuntoId = gestaoAssunto.cadastrar(assunto);

            if (assuntoId != null) {
                jsp = AssuntoController.listar(request);
            } else {
                String erro = "Nao foi possível gravar esse registro!";
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
