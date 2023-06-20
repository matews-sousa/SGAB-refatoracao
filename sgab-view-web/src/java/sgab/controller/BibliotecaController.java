package sgab.controller;

import sgab.model.exception.PersistenciaException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import sgab.model.dao.UnidadeOrganizacionalDAO;
import sgab.model.dto.Biblioteca;
import sgab.model.service.GestaoBibliotecaService;


public class BibliotecaController {
    
   public static String listar(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            List<Biblioteca> listBiblioteca = gestaoBiblioteca.pesquisarAtivos();
            if (listBiblioteca != null) {
                request.setAttribute("listBiblioteca", listBiblioteca);
                jsp = "/core/biblioteca/listar.jsp";
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
            Long bibliotecaId = Long.parseLong(request.getParameter("bibliotecaId"));
            
            GestaoBibliotecaService manterBiblioteca = new GestaoBibliotecaService();
            Biblioteca biblioteca = manterBiblioteca.pesquisarPorId(bibliotecaId);
            
            if (biblioteca != null) {
                request.setAttribute("biblioteca", biblioteca);
                jsp = "/core/biblioteca/alterar.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Biblioteca!";
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
            Long bibliotecaId = Long.parseLong(request.getParameter("bibliotecaId"));
            
            GestaoBibliotecaService gestaoBibliotecaes = new GestaoBibliotecaService();
            Biblioteca biblioteca = gestaoBibliotecaes.pesquisarPorId(bibliotecaId);
            try {
                gestaoBibliotecaes.excluir(biblioteca);
                jsp = BibliotecaController.listar(request);
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
            Long bibliotecaId = Long.parseLong(request.getParameter("bibliotecaId"));
            String nome = request.getParameter("bibliotecaNome");
            String uOrgNome = request.getParameter("uOrgNome");
            
            GestaoBibliotecaService gestaoBibliotecas = new GestaoBibliotecaService();
            UnidadeOrganizacionalDAO uOrgDAO = UnidadeOrganizacionalDAO.getInstance();
            
            Biblioteca biblioteca = new Biblioteca(nome);
            biblioteca.setId(bibliotecaId);
            biblioteca.setUnidadeOrganizacional(uOrgDAO.pesquisarPorNome(uOrgNome));
            
            try {
                gestaoBibliotecas.atualizar(biblioteca);
                jsp = BibliotecaController.listar(request);
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
            String nome = request.getParameter("bibliotecaNome");
            String uOrgNome = request.getParameter("uOrgNome");
            
            GestaoBibliotecaService gestaoBibliotecas = new GestaoBibliotecaService();
            UnidadeOrganizacionalDAO uOrgDAO = UnidadeOrganizacionalDAO.getInstance();
            
            Biblioteca biblioteca = new Biblioteca(nome);
            biblioteca.setUnidadeOrganizacional(uOrgDAO.pesquisarPorNome(uOrgNome));
            
            Long bibliotecaId = gestaoBibliotecas.cadastrar(biblioteca);
            
            if (bibliotecaId != null) {
                jsp = BibliotecaController.listar(request);
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