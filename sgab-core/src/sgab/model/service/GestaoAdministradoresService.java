package sgab.model.service;

import java.util.List;
import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.UsuarioTipo;
import sgab.model.dto.util.PessoaHelper;
import sgab.model.dto.util.AdministradoresHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import sgab.model.exception.NegocioException;

public class GestaoAdministradoresService{
    private final PessoasDAO pessoasDAO;

    public GestaoAdministradoresService() {
        pessoasDAO = PessoasDAO.getInstance();
    }

    public Long cadastrarAdministrador(Pessoa pessoa) {
        pessoa.setTipo(UsuarioTipo.ADMINISTRADOR);
        List<String> exMsgs = PessoaHelper.validarPessoa(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }
    
    public Long cadastrarGestor(Pessoa pessoa) {
        pessoa.setTipo(UsuarioTipo.GESTOR);
        List<String> exMsgs = PessoaHelper.validarPessoa(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }
    
    public List<Pessoa> pesquisarGestorAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> gestores = new LinkedList<>();
        for(long i = 1; i <= pessoas.size(); i++){
            Pessoa pessoa = pessoasDAO.pesquisar(i);
            List<UsuarioTipo> tipos = pessoa.getTipo();
            for(UsuarioTipo tipo : tipos){
              if(tipo == UsuarioTipo.GESTOR){
                gestores.add(pessoa);
             }
          }
        }
        return gestores;
    }
    
     public List<Pessoa> pesquisarAdministradoresAtivos() {
        List<Pessoa> pessoas = pessoasDAO.listarAtivos();
        List<Pessoa> administradores = new LinkedList<>();
        for(long i = 1; i <= pessoas.size(); i++){
            Pessoa pessoa = pessoasDAO.pesquisar(i);
            List<UsuarioTipo> tipos = pessoa.getTipo();
            for(UsuarioTipo tipo : tipos){
              if(tipo == UsuarioTipo.ADMINISTRADOR){
                administradores.add(pessoa);
             }  
          }
        }
        return administradores;
    }
     
    public Pessoa pesquisarAdministradoresPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        List<UsuarioTipo> tipos = result.getTipo();
        for(UsuarioTipo tipo : tipos ){
          if(tipo == UsuarioTipo.ADMINISTRADOR){
            return result;            
          }
          else{
            return null;
          } 
        }
        return null;
    }
    
    public Pessoa pesquisarGestorPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        List<UsuarioTipo> tipos = result.getTipo();
        for(UsuarioTipo tipo : tipos ){
          if(tipo == UsuarioTipo.GESTOR){
            return result;            
          }
          else{
            return null;
          } 
        }
        return null;
    }

    public void alterarGestor(Pessoa pessoa){
        List<String> exMsgs = AdministradoresHelper.validarGestorAlteracao(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        pessoasDAO.alterar(pessoa);
    }
    
    public void alterarAdministrador(Pessoa pessoa){
        List<String> exMsgs =  AdministradoresHelper.validarAdministradorAlteracao(pessoa, pessoasDAO);
            
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        pessoasDAO.alterar(pessoa);
    }

    public void excluir(Pessoa pessoa){
        pessoasDAO.delete(pessoa.getId());    
    }   
    
   

}

