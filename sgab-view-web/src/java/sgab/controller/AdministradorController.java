package sgab.controller;

import java.io.IOException; 
import java.io.PrintWriter; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.ServletException; 
import java.util.List;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.UsuarioTipo;
import sgab.model.service.GestaoPessoasService;
import sgab.model.service.GestaoAdministradoresService;
import sgab.model.dto.util.PessoaHelper;
import sgab.model.exception.NegocioException;
import sgab.model.exception.PersistenciaException;  

public class AdministradorController { 

    public static String pesquisarAdministradorLogin(HttpServletRequest request){
        String jsp = "";
        try {
            String login = request.getParameter("login");
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            List<Pessoa> listPessoa = null;
            listPessoa.add(gestaoAdministradoresService.pesquisarAdministradoresPorLogin(login));
            if (listPessoa != null) {
                request.setAttribute("listPessoas", listPessoa);
                jsp = "/core/administrador/listar.jsp";
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

    public static String pesquisarGestorLogin(HttpServletRequest request){
        String jsp = "";
        try {
            String login = request.getParameter("login");
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            List<Pessoa> listPessoa = null;
            listPessoa.add(gestaoAdministradoresService.pesquisarGestorPorLogin(login));  
            if (listPessoa != null) {
                request.setAttribute("listPessoas", listPessoa);
                jsp = "/core/administrador/listar.jsp";
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

    public static String listarAdministradores(HttpServletRequest request) { 
        String jsp = "";
        try {
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            List<Pessoa> listPessoas = gestaoAdministradoresService.pesquisarAdministradoresAtivos(); 
            if (listPessoas != null) {
                request.setAttribute("listPessoas", listPessoas);
                jsp = "/core/administrador/listar.jsp"; // criar listar.jsp
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

    public static String listarGestores(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            List<Pessoa> listPessoas = gestaoAdministradoresService.pesquisarGestorAtivos();
            if (listPessoas != null) {
                request.setAttribute("listPessoas", listPessoas);
                jsp = "/core/administrador/listar.jsp"; // criar listar.jsp
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

    public static String alterarAdministrador(HttpServletRequest request) { // Precisa de revisão. Como vai funcionar questão do habilitar e desabilitar?
        String jsp = "";
        try {
            String login = request.getParameter("login");
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            Pessoa pessoa = gestaoAdministradoresService.pesquisarAdministradoresPorLogin(login); 
            if (pessoa != null) {
                request.setAttribute("pessoa", pessoa);
                jsp = "/core/administrador/alterar.jsp"; // criar alterar.jsp
            } else {
                String erro = "Ocorreu erro ao Alterar Pessoa!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String alterarGestor(HttpServletRequest request) { // Precisa de revisão. Como vai funcionar questão do habilitar e desabilitar?
        String jsp = "";
        try {
            String login = request.getParameter("login"); 
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            Pessoa pessoa = gestaoAdministradoresService.pesquisarGestorPorLogin(login);
            if (pessoa != null) {
                request.setAttribute("pessoa", pessoa);
                jsp = "/core/administrador/alterar.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Pessoa!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String gravarAlteracaoAdministrador(HttpServletRequest request) {
        String jsp = "";
        try {
            Long pessoaId = Long.parseLong(request.getParameter("pessoaId"));
            String login = request.getParameter("login");
            Long cpf = Long.parseLong(request.getParameter("cpf"));
            String nomeCompleto = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Pessoa pessoa = new Pessoa(login, cpf);
            pessoa.setId(pessoaId);
            pessoa.setNome(nomeCompleto);
            pessoa.setEmail(email);
            pessoa.setSenha(senha);
            pessoa.setHabilitado(true);
            pessoa.setTipo(UsuarioTipo.ADMINISTRADOR);
            
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            try {
                gestaoAdministradoresService.alterarAdministrador(pessoa); 
                jsp = listarAdministradores(request);
            } 
            catch(PersistenciaException ex) {
                String erro = "Nao foi possivel alterar esse registro!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String gravarAlteracaoGestor(HttpServletRequest request) {
        String jsp = "";
        try {
            Long pessoaId = Long.parseLong(request.getParameter("pessoaId"));
            String login = request.getParameter("login");
            Long cpf = Long.parseLong(request.getParameter("cpf"));
            String nomeCompleto = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Pessoa pessoa = new Pessoa(login, cpf);
            pessoa.setId(pessoaId);
            pessoa.setNome(nomeCompleto);
            pessoa.setEmail(email);
            pessoa.setSenha(senha);
            pessoa.setHabilitado(true);
            pessoa.setTipo(UsuarioTipo.GESTOR);
            
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            try {
                gestaoAdministradoresService.alterarGestor(pessoa);
                jsp = listarGestores(request);
            } 
            catch(PersistenciaException ex) {
                String erro = "Nao foi possivel alterar esse registro!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String gravarInsercaoAdministrador(HttpServletRequest request) {
        String jsp = "";
        try {
            String login = request.getParameter("login");

            GestaoPessoasService gestaoAdministradoresService = new GestaoPessoasService();
            Pessoa pessoa = gestaoAdministradoresService.pesquisarPorLogin(login);
            pessoa.setTipo(UsuarioTipo.ADMINISTRADOR);

            Long pessoaId = pessoa.getId();            

            if (pessoaId != null) {
                jsp = listarAdministradores(request); 
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

    public static String gravarInsercaoGestor(HttpServletRequest request) {
        String jsp = "";
        try {
            String login = request.getParameter("login");

            GestaoPessoasService gestaoAdministradoresService = new GestaoPessoasService();
            Pessoa pessoa = gestaoAdministradoresService.pesquisarPorLogin(login);
            pessoa.setTipo(UsuarioTipo.GESTOR);

            Long pessoaId = pessoa.getId();            

            if (pessoaId != null) {
                jsp = listarGestores(request); 
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

    public static String excluirAdministrador(HttpServletRequest request) { 
        String jsp = "";
        try {
            String login = request.getParameter("login");
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            Pessoa pessoa = gestaoAdministradoresService.pesquisarAdministradoresPorLogin(login);
            try {
                gestaoAdministradoresService.excluir(pessoa);
                jsp = listarAdministradores(request); 
            }
            catch(PersistenciaException ex) {
                String erro = "Ocorreu erro ao Excluir Pessoa!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String excluirGestor(HttpServletRequest request) { 
        String jsp = "";
        try {
            String login = request.getParameter("login");
            GestaoAdministradoresService gestaoAdministradoresService = new GestaoAdministradoresService();
            Pessoa pessoa = gestaoAdministradoresService.pesquisarGestorPorLogin(login);
            try {
                gestaoAdministradoresService.excluir(pessoa);
                jsp = listarGestores(request); 
            }
            catch(PersistenciaException ex) {
                String erro = "Ocorreu erro ao Excluir Pessoa!";
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