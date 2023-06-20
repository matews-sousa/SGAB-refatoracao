package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import sgab.model.dto.UnidadeOrganizacional;
import sgab.model.exception.PersistenciaException;
import sgab.model.service.GestaoUnidadeOrganizacionalService;

public class UnidadeOrganizacionalController {

    public static String listar(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoUnidadeOrganizacionalService gestaoUOrg = new GestaoUnidadeOrganizacionalService();
            List<UnidadeOrganizacional> listUOrg = gestaoUOrg.pesquisarAtivos();
            if (listUOrg != null) {
                request.setAttribute("listUnidadeOrganizacional", listUOrg);
                jsp = "/core/unidadeorganizacional/listar.jsp";
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
            // lendo a Sigla do Usuario que deseja alterar
            Long uOrgId = Long.parseLong(request.getParameter("uOrgId"));
            GestaoUnidadeOrganizacionalService gestaoUOrg = new GestaoUnidadeOrganizacionalService();
            UnidadeOrganizacional uOrg = gestaoUOrg.pesquisarPorId(uOrgId);
            if (uOrg != null) {
                request.setAttribute("unidadeOrganizacional", uOrg);
                jsp = "/core/unidadeorganizacional/alterar.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Usuario!";
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
            // lendo o CodUsuario que se deseja alterar
            Long uOrgId = Long.parseLong(request.getParameter("uOrgId"));
            GestaoUnidadeOrganizacionalService gestaoUOrg = new GestaoUnidadeOrganizacionalService();
            UnidadeOrganizacional uOrg = gestaoUOrg.pesquisarPorId(uOrgId);
            try {
                gestaoUOrg.excluir(uOrg);
                jsp = UnidadeOrganizacionalController.listar(request);
            }
            catch(PersistenciaException ex) {
                String erro = "Ocorreu erro ao Excluir a Unidade Organizacional!";
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

            Long uOrgId = Long.parseLong(request.getParameter("uOrgId"));
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");

            UnidadeOrganizacional uOrg = new UnidadeOrganizacional();
            uOrg.setId(uOrgId);
            uOrg.setNome(nome);
            uOrg.setEndereco(endereco);

            GestaoUnidadeOrganizacionalService gestaoUOrg = new GestaoUnidadeOrganizacionalService();
            try {
                gestaoUOrg.atualizar(uOrg);
                jsp = UnidadeOrganizacionalController.listar(request);
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
            String endereco = request.getParameter("endereco");

            UnidadeOrganizacional uOrg = new UnidadeOrganizacional();
            uOrg.setNome(nome);
            uOrg.setEndereco(endereco);

            GestaoUnidadeOrganizacionalService gestaUOrg = new GestaoUnidadeOrganizacionalService();
            Long uOrgId = gestaUOrg.cadastrar(uOrg);

            if (uOrgId != null) {
                jsp = UnidadeOrganizacionalController.listar(request);
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
