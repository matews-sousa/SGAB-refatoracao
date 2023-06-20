package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.UsuarioTipo;
import sgab.model.service.GestaoUsuarioService;
import sgab.model.exception.PersistenciaException;

public class UsuarioController {

    public static String listar(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoUsuarioService gestaoUsuario = new GestaoUsuarioService();
            UsuarioTipo usuarioTipo = UsuarioTipo.strTo(request.getParameter("usuarioTipo"));
            List<Pessoa> listUsuarios = gestaoUsuario.pesquisarPorTipo(usuarioTipo);
            if (listUsuarios != null) {
                request.setAttribute("listUsuarios", listUsuarios);
                jsp = "/core/usuario/listar.jsp";
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

    public static String excluir(HttpServletRequest request) {
        String jsp = "";
        try {
            Long usuarioId = Long.parseLong(request.getParameter("pessoaId"));
            UsuarioTipo usuarioTipo = UsuarioTipo.strTo(request.getParameter("usuarioTipo"));

            try {
                GestaoUsuarioService gestaoUsuario = new GestaoUsuarioService();
                gestaoUsuario.excluirUsuario(usuarioId, usuarioTipo);
                jsp = UsuarioController.listar(request);
            }
            catch(PersistenciaException ex) {
                String erro = "Ocorreu erro ao Excluir Usuario!";
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
            Long pessoaId = Long.parseLong(request.getParameter("pessoaId"));
            UsuarioTipo usrTipo = UsuarioTipo.strTo(request.getParameter("usuarioTipo"));


            if ((pessoaId != null) && (usrTipo != null)) {
                GestaoUsuarioService gestaoUsuario = new GestaoUsuarioService();
                gestaoUsuario.cadastrar(pessoaId, usrTipo);
                jsp = UsuarioController.listar(request);
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
