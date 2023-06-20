/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.ExemplarTipo;
import sgab.model.service.GestaoAcervo;
import sgab.model.service.GestaoBibliotecaService;
import sgab.model.service.GestaoPessoasService;
import sgab.util.PasswordDigest;

/**
 *
 * @author HP
 */
public class AcervoController {
    public static String escolherBiblioteca(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            String nomeBiblioteca = request.getParameter("nomeBiblioteca");
            Biblioteca bibliotecaAlvo = gestaoBiblioteca.pesquisarProNome(nomeBiblioteca);
            
            if (bibliotecaAlvo != null) {
                request.getSession().setAttribute("bibliotecaOrigem", bibliotecaAlvo);
                jsp = "/core/acervo/menu.jsp";
            } else {
                String erro = "Essa biblioteca não existe!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String enviarReparo(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            Long id = Long.parseLong(request.getParameter("idEnvio"));
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(id);
            if(exemplarAlvo != null){
                gestaoAcervo.EnviarRestaurar(id);
            
                String justificativa = request.getParameter("razaoEnvio");

                String data = request.getParameter("dataEnvio");
                exemplarAlvo.setHistorico(exemplarAlvo.getHistorico() + "\n" + data + " - Exemplar enviado para restauração.\n"
                        + "Motivo: " + justificativa);
                
                jsp = "/core/acervo/operacao-sucesso.jsp";
            }
            else{
                String erro = "Esse exemplar não foi encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String receberReparo(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            Long id = Long.parseLong(request.getParameter("idRetorno"));
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(id);
            if(exemplarAlvo != null){
                gestaoAcervo.finalizarReparo(id);
            
                String status = request.getParameter("fav_language");
                String data = request.getParameter("dataRetorno");
                exemplarAlvo.setHistorico(exemplarAlvo.getHistorico() + "\n" + data + " - Exemplar recebido da restauração.\n"
                        + "Status: " + status);
                jsp = "/core/acervo/operacao-sucesso.jsp";
            }
            else{
                String erro = "Esse exemplar não foi encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String desativarExemplar(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            GestaoPessoasService gestaoPessoa = new GestaoPessoasService();
            
            Long id = Long.parseLong(request.getParameter("idRetorno"));
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(id);
            if(exemplarAlvo != null){
                String password = request.getParameter("password");
                password = PasswordDigest.passwordDigestMD5(password);
                
                Pessoa user = (Pessoa) request.getSession().getAttribute("usuario");
                if(user.getSenha().equals(password)){
                    gestaoAcervo.desativarExemplar(id);

                    String justificativa = request.getParameter("razaoDesativar");
                    String data = request.getParameter("dataDesativar");
                    exemplarAlvo.setHistorico(exemplarAlvo.getHistorico() + "\n" + data + " - Exemplar desativado.\n"
                            + "Justificativa: " + justificativa);
                    jsp = "/core/acervo/operacao-sucesso.jsp";
                }
                else{
                    String erro = "A senha não coincide!";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                }
            }
            else{
                String erro = "Esse exemplar não foi encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String registrarLivroConsulta(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            GestaoPessoasService gestaoPessoa = new GestaoPessoasService();
            
            Long id = Long.parseLong(request.getParameter("idRetorno"));
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(id);
            if(exemplarAlvo != null){
                String password = request.getParameter("password");
                password = PasswordDigest.passwordDigestMD5(password);
                
                Pessoa user = (Pessoa) request.getSession().getAttribute("usuario");
                if(user.getSenha().equals(password)){
                    exemplarAlvo.setTipo(ExemplarTipo.CONSULTA);

                    String justificativa = request.getParameter("razaoConsulta");
                    exemplarAlvo.setHistorico(exemplarAlvo.getHistorico() + "\nExemplar definido como de consulta.\n"
                            + "Justificativa: " + justificativa);
                    jsp = "/core/acervo/operacao-sucesso.jsp";
                }
                else{
                    String erro = "A senha não coincide!";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                }
            }
            else{
                String erro = "Esse exemplar não foi encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String registrarTransferencia(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            GestaoPessoasService gestaoPessoa = new GestaoPessoasService();
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            
            Long id = Long.parseLong(request.getParameter("idRetorno"));
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(id);
            if(exemplarAlvo != null){
                String nomeBiblioteca = request.getParameter("nomeBiblioteca");
                Biblioteca bibliotecaEnviar = gestaoBiblioteca.pesquisarProNome(nomeBiblioteca);
                
                if(bibliotecaEnviar != null){
                    String password = request.getParameter("password");
                    password = PasswordDigest.passwordDigestMD5(password);

                    Pessoa user = (Pessoa) request.getSession().getAttribute("usuario");
                    if(user.getSenha().equals(password)){
                        gestaoAcervo.transferir(id, bibliotecaEnviar);
                        exemplarAlvo.setHistorico(exemplarAlvo.getHistorico() + "\nExemplar enviado para outra Biblioteca.");
                        jsp = "/core/acervo/operacao-sucesso.jsp";
                    }
                    else{
                        String erro = "A senha não coincide!";
                        request.setAttribute("erro", erro);
                        jsp = "/core/erro.jsp";
                    }
                }
                else{
                    String erro = "A biblioteca não foi encontrada!";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                }
            }
            else{
                String erro = "Esse exemplar não foi encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String registrarRecebimento(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            Long id = Long.parseLong(request.getParameter("idExemplar"));
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(id);
            if(exemplarAlvo != null){
                String password = request.getParameter("password");
                password = PasswordDigest.passwordDigestMD5(password);
                
                Pessoa user = (Pessoa) request.getSession().getAttribute("usuario");
                if(user.getSenha().equals(password)){
                    gestaoAcervo.finalizarTransferencia(id);
                    exemplarAlvo.setHistorico(exemplarAlvo.getHistorico() + "\nExemplar recebido de outra Biblioteca.\n");
                    jsp = "/core/acervo/operacao-sucesso.jsp";
                }
                else{
                    String erro = "A senha não coincide!";
                    request.setAttribute("erro", erro);
                    jsp = "/core/erro.jsp";
                }
            }
            else{
                String erro = "Esse exemplar não foi encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String listarRestaurar(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            
            Biblioteca alvo = gestaoBiblioteca.pesquisarProNome(request.getParameter("bibliotecaOrigem"));
            
            List<Exemplar> exemplares = gestaoAcervo.listaRestauracao(alvo);
            request.setAttribute("exemplaresListar", exemplares);
            jsp = "/core/acervo/listarReparo.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String listarConsulta(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            
            Biblioteca alvo = gestaoBiblioteca.pesquisarProNome(request.getParameter("bibliotecaOrigem"));
            
            List<Exemplar> exemplares = gestaoAcervo.listaConsulta(alvo);
            request.setAttribute("exemplaresListar", exemplares);
            jsp = "/core/acervo/listarConsulta.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String listarTransferencia(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            
            Biblioteca alvo = gestaoBiblioteca.pesquisarProNome(request.getParameter("bibliotecaOrigem"));
            
            List<Exemplar> exemplares = gestaoAcervo.listaTransferencia(alvo);
            request.setAttribute("exemplaresListar", exemplares);
            jsp = "/core/acervo/listarTransferencia.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String mostraExemplar(HttpServletRequest request) {
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            Long id = Long.parseLong(request.getParameter("exemplarId"));
            Exemplar exemplar = gestaoAcervo.pesquisarExemplar(id);
            
            request.setAttribute("exemplarAlvo", exemplar);
            jsp = "/core/acervo/mostra-exemplar.jsp";
        }
        catch(Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String listarAcervoBiblioteca(HttpServletRequest request) {
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            
            Biblioteca alvo = gestaoBiblioteca.pesquisarProNome(request.getParameter("bibliotecaOrigem"));
            List<Exemplar> exemplares = gestaoAcervo.listaAcervo(alvo);
            request.setAttribute("exemplaresListar", exemplares);
            jsp = "/core/acervo/listarAcervo.jsp";
        }
        catch(Exception e){
            e.printStackTrace();
            jsp= "";
        }
        return jsp;
    }
    
    public static String aceitarExemplar(HttpServletRequest request){
        String jsp = "";
        try{
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            Long id = Long.parseLong(request.getParameter("userId"));
            Exemplar exemplarAlvo = gestaoAcervo.pesquisarExemplar(id);
            if(exemplarAlvo != null){
                gestaoAcervo.finalizarTransferencia(id);

                exemplarAlvo.setHistorico(exemplarAlvo.getHistorico() + "\nExemplar aceito na nova Biblioteca.\n");
                jsp = "/core/acervo/operacao-sucesso.jsp";
            }
            else{
                String erro = "Esse exemplar não foi encontrado!";
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
