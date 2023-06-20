package sgab.controller;

import sgab.model.exception.PersistenciaException;
import jakarta.servlet.http.HttpServletRequest;
import sgab.model.dto.Fornecedor;
import java.util.List;
import sgab.model.service.GestaoFornecedoresService;


public class FornecedorController {
   public static String listar(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoFornecedoresService gestaoFornecedor = new GestaoFornecedoresService();
            List<Fornecedor> listFornecedor = gestaoFornecedor.pesquisarAtivos();
            if (listFornecedor != null) {
                request.setAttribute("listFornecedor", listFornecedor);
                jsp = "/core/fornecedor/listar.jsp";
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
            Long fornecedorCNPJ = Long.parseLong(request.getParameter("cnpj"));
            
            GestaoFornecedoresService manterFornecedor = new GestaoFornecedoresService();
            Fornecedor fornecedor = manterFornecedor.pesquisarPorCNPJ(fornecedorCNPJ);
            if (fornecedor != null) {
                request.setAttribute("fornecedor", fornecedor);
                jsp = "/core/fornecedor/alterar.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Fornecedor!";
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
            Long fornecedorCNPJ = Long.parseLong(request.getParameter("fornecedorCNPJ"));
            
            GestaoFornecedoresService gestaoFornecedores = new GestaoFornecedoresService();
            Fornecedor fornecedor = gestaoFornecedores.pesquisarPorCNPJ(fornecedorCNPJ);
            try {
                gestaoFornecedores.excluir(fornecedor);
                jsp = FornecedorController.listar(request);
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
            Long fornecedorCnpj = Long.parseLong(request.getParameter("cnpj"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            Long cep = Long.parseLong(request.getParameter("cep"));
            Long telefone = Long.parseLong(request.getParameter("telefone"));

            Fornecedor fornecedor = new Fornecedor(fornecedorCnpj, nome, email, telefone, cep, endereco);
            GestaoFornecedoresService gestaoFornecedores = new GestaoFornecedoresService();
            try {
                gestaoFornecedores.atualizar(fornecedor);
                jsp = FornecedorController.listar(request);
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
            Long fornecedorCNPJ = Long.parseLong(request.getParameter("cnpj"));
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            Long cep = Long.parseLong(request.getParameter("cep"));
            Long telefone = Long.parseLong(request.getParameter("telefone"));
            
            Fornecedor fornecedor = new Fornecedor(fornecedorCNPJ, nome, email, telefone, cep, endereco);

            GestaoFornecedoresService gestaoFornecedores = new GestaoFornecedoresService();
            fornecedorCNPJ = gestaoFornecedores.cadastrar(fornecedor);

            if (fornecedorCNPJ != null) {
                jsp = FornecedorController.listar(request);
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