/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.model.service;

import java.util.List;
import sgab.model.dao.AcervoDAO;
import sgab.model.dto.Autor;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.dto.util.AcervoHelper;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.exception.NegocioException;
import sgab.model.exception.PersistenciaException;

/**
 *
 * @author HP
 */
public class GestaoAcervo {
    private AcervoDAO acervoDAO;
    
    public GestaoAcervo(){
        acervoDAO = AcervoDAO.getInstance();
    }
    
    public Long cadastrarExemplar(Exemplar exemplar){
        
        List<String> erros = AcervoHelper.validarExemplar(exemplar);
        if(!erros.isEmpty()){
            throw new NegocioException(erros);
        }
        
        acervoDAO.inserir(exemplar);
        return exemplar.getId();
    }
    
    public boolean desativarExemplar(Long id){
        Exemplar exemplarAlvo = acervoDAO.pesquisar(id);
        if(exemplarAlvo == null)
            throw new NegocioException("Nenhum exemplar desse id encontrado");
        exemplarAlvo.setStatus(ExemplarStatus.DESATIVADA);
        return true;
    }
    
    public Exemplar pesquisarExemplar(Long id){
        return acervoDAO.pesquisar(id);
    }
    
    public boolean transferir(Long id, Biblioteca novaBiblioteca){
        Exemplar exemplarAlvo = acervoDAO.pesquisar(id);
        if(exemplarAlvo == null)
            throw new NegocioException("Nenhum exemplar desse id encontrado");
        exemplarAlvo.setBibliotecaPosse(novaBiblioteca);
        exemplarAlvo.setStatus(ExemplarStatus.TRANSFERENCIA);
        return true;
    }
    
    public boolean finalizarReparo(Long id){
        return acervoDAO.disponibilizar(id);
    }
    
    public boolean finalizarTransferencia(Long id){
        return acervoDAO.disponibilizar(id);
    }
    
    public boolean EnviarRestaurar(Long id){
        acervoDAO.mudaStatus(id, ExemplarStatus.REPARO);
        return true;
    }
    
    public List<Exemplar> listaConsulta(Biblioteca biblioteca){
        if(biblioteca == null){
            throw new NegocioException("Biblioteca não encontrada.");
        }
        return acervoDAO.listarConsulta(biblioteca);
    }
    
    public List<Exemplar> listaAcervo(Biblioteca biblioteca){
        if(biblioteca == null){
            throw new NegocioException("Biblioteca não encontrada.");
        }
        //**# return acervoDAO.listarConsulta(biblioteca); */
        return acervoDAO.listarAcervoBiblioteca(biblioteca);
    }
    
    public List<Exemplar> listaRestauracao(Biblioteca biblioteca){
        if(biblioteca == null){
            throw new NegocioException("Biblioteca não encontrada.");
        }
        return acervoDAO.listarRestauracao(biblioteca);
    }
    
    public List<Exemplar> listaTransferencia(Biblioteca biblioteca){
        if(biblioteca == null){
            throw new NegocioException("Biblioteca não encontrada.");
        }
        return acervoDAO.listarTransferencia(biblioteca);
    }
    
    public List<Exemplar> listaParaReserva(){
        return acervoDAO.listarAcervoParaReserva();
    }
    
    public List<Exemplar> listaParaReserva(String titulo){
        return acervoDAO.listarAcervoParaReserva(titulo);
    }
    
    public List<Exemplar> listaParaReserva(Autor autor){
        return acervoDAO.listarAcervoParaReserva(autor);
    }
    
    public List<Exemplar> listaParaReserva(Biblioteca biblioteca){
        return acervoDAO.listarAcervoParaReserva(biblioteca);
    }
}

