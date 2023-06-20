package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import sgab.model.dto.Pessoa;
import sgab.model.service.GestaoPessoasService;
import java.util.List;
import sgab.model.exception.PersistenciaException;

public class PessoaController {
    public static String pesquisarLogin(HttpServletRequest request){
        String jsp = "";
        try {
            String login = request.getParameter("login");
            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            List<Pessoa> listPessoa = null;
            listPessoa.add(gestaoPessoasService.pesquisarPorLogin(login)); 
            if (listPessoa != null) {
                request.setAttribute("listPessoas", listPessoa);
                jsp = "/core/pessoa/listar.jsp";
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

    public static String listar(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            List<Pessoa> listPessoas = gestaoPessoasService.pesquisarAtivos();
            if (listPessoas != null) {
                request.setAttribute("listPessoas", listPessoas);
                jsp = "/core/pessoa/listar.jsp";
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
            Long pessoaId = Long.parseLong(request.getParameter("pessoaId"));
            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            Pessoa pessoa = gestaoPessoasService.pesquisarPorId(pessoaId);
            if (pessoa != null) {
                request.setAttribute("pessoa", pessoa);
                jsp = "/core/pessoa/alterar.jsp";
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

    public static String gravarAlteracao(HttpServletRequest request) {
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
            
            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            try {
                gestaoPessoasService.alterar(pessoa);
                jsp = listar(request);
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

    public static String gravarInsercao(HttpServletRequest request) {
        String jsp = "";
        try {
            String login = request.getParameter("login");
            Long cpf = Long.parseLong(request.getParameter("cpf"));
            String nomeCompleto = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Pessoa pessoa = new Pessoa(cpf, login, nomeCompleto, email, senha);

            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            Long pessoaId = gestaoPessoasService.cadastrar(pessoa);

            if (pessoaId != null) {
                jsp = listar(request);
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

    public static String excluir(HttpServletRequest request) {
        String jsp = "";
        try {
            Long pessoaId = Long.parseLong(request.getParameter("pessoaId"));
            GestaoPessoasService gestaoPessoasService = new GestaoPessoasService();
            Pessoa pessoa = gestaoPessoasService.pesquisarPorId(pessoaId);
            try {
                gestaoPessoasService.excluir(pessoa);
                jsp = listar(request);
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
