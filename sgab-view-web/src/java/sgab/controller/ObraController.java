package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Assunto;
import sgab.model.dto.Autor;
import sgab.model.dto.Obra;
import sgab.model.exception.PersistenciaException;
import sgab.model.service.GestaoAssuntoService;
import sgab.model.service.GestaoAutor;
import sgab.model.service.GestaoObras;


public class ObraController {
    public static String listar(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoObras gestaoObra = new GestaoObras();
            List<Obra> listObras = gestaoObra.pesquisarObrasAtivas();
            if (listObras != null) {
                request.setAttribute("listObras", listObras);
                jsp = "/core/obra/listar.jsp";
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
    public static String pesquisar(HttpServletRequest request) {
        String jsp = "";
        try{
            GestaoObras gestaoObra = new GestaoObras();
            
            String tipo = request.getParameter("tipo");
            String nome = request.getParameter("nome");
            switch(tipo){
                case "titulo":
                    List<Obra> obrasCompativeis = gestaoObra.pesquisarTituloAprox(nome);
                    request.setAttribute("listObras", obrasCompativeis);
                    jsp = "/core/obra/listar.jsp";
                    break;
                    
                case "autor":
                    List<Obra> obrasComAutor = gestaoObra.pesquisarObrasAutor(nome);
                    request.setAttribute("listObras", obrasComAutor);
                    jsp = "/core/obra/listar.jsp";
                    break;
                    
                default:
                    String erro = "Erro na entrada do tipo!";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String gravarInsercao(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAutor gestaoAutor = new GestaoAutor();
            GestaoObras gestaoObras = new GestaoObras();
            GestaoAssuntoService gestaoAssuntos = new GestaoAssuntoService();
            
            String tituloObra = request.getParameter("titulo");
            String categoriaObra = request.getParameter("categoria");
            String notaObra = request.getParameter("nota");
            
            List<Autor> autores = new LinkedList<>();
            String[] nomeAutores = request.getParameter("autores").split("::");
            for(String autor: nomeAutores){
                Autor alvo = gestaoAutor.pesquisarNome(autor);
                autores.add(alvo);
            }
            
            List<Assunto> assuntos = new LinkedList<>();
            String[] nomeAssuntos = request.getParameter("assuntos").split("::");
            for(String assunto : nomeAssuntos){
                Assunto alvo = gestaoAssuntos.pesquisarAssunto(assunto);
                assuntos.add(alvo);
            }
            
            Integer anoObra = Integer.parseInt(request.getParameter("ano"));
            String editoraObra = request.getParameter("editora");
            String cidadeEditoraObra = request.getParameter("cidEditora");
            Integer edicaoObra = Integer.parseInt(request.getParameter("edicao"));
            Integer volumeObra = Integer.parseInt(request.getParameter("volume"));

            Obra obra = new Obra(categoriaObra, tituloObra, autores, assuntos, notaObra, anoObra, editoraObra, cidadeEditoraObra, edicaoObra, volumeObra);
            
            Long obraId = gestaoObras.cadastrarObra(obra);

            if (obraId != null) {
                jsp = ObraController.listar(request);
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
    
    public static String alterar(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Usuario que deseja alterar
            Long obraId = Long.parseLong(request.getParameter("obraId"));
            GestaoObras manterObra = new GestaoObras();
            Obra obra = manterObra.pesquisarObraID(obraId);
            if (obra != null) {
                request.setAttribute("obra", obra);
                jsp = "/core/obra/alterar.jsp";
            } else {
                String erro = "Ocorreu erro ao Alterar Obra!";
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
            GestaoAutor gestaoAutor = new GestaoAutor();
            GestaoObras gestaoObra = new GestaoObras();
            GestaoAssuntoService gestaoAssuntos = new GestaoAssuntoService();
            
            Long idObra = Long.parseLong(request.getParameter("obraId"));
            String tituloObra = request.getParameter("titulo");
            String categoriaObra = request.getParameter("categoria");
            String notaObra = request.getParameter("nota");
            
            List<Autor> autores = new LinkedList<>();
            String[] nomeAutores = request.getParameter("autores").split("::");
            for(String autor: nomeAutores){
                Autor alvo = gestaoAutor.pesquisarNome(autor);
                autores.add(alvo);
            }
            
            List<Assunto> assuntos = new LinkedList<>();
            String[] nomeAssuntos = request.getParameter("assuntos").split("::");
            for(String assunto : nomeAssuntos){
                Assunto alvo = gestaoAssuntos.pesquisarAssunto(assunto);
                assuntos.add(alvo);
            }
            
            Integer anoObra = Integer.parseInt(request.getParameter("ano"));
            String editoraObra = request.getParameter("editora");
            String cidadeEditoraObra = request.getParameter("cidEditora");
            Integer edicaoObra = Integer.parseInt(request.getParameter("edicao"));
            Integer volumeObra = Integer.parseInt(request.getParameter("volume"));

            Obra obra = new Obra(categoriaObra, tituloObra, autores, assuntos, notaObra, anoObra, editoraObra, cidadeEditoraObra, edicaoObra, volumeObra);
            obra.setId(idObra);
            
            try {
                gestaoObra.atualizaCadastroObra(obra);
                jsp = ObraController.listar(request);
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

    public static String excluir(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodUsuario que se deseja alterar
            Long obraId = Long.parseLong(request.getParameter("obraId"));
            GestaoObras gestaoObra = new GestaoObras();
            Obra obra = gestaoObra.pesquisarObraID(obraId);
            try {
                gestaoObra.excluirObra(obra);
                jsp = ObraController.listar(request);
            }
            catch(PersistenciaException ex) {
                String erro = "Ocorreu erro ao Excluir Obra!";
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
