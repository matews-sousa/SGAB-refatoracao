package sgab.model.dto.util;

import sgab.model.dto.Reserva;
import java.util.List;
import java.util.LinkedList;
import sgab.model.dao.ReservaDAO;

public class ReservaHelper {
    
    public static List<String> validarReserva(Reserva reserva){
        List<String> erros = new LinkedList<>();

        if(reserva == null){
            erros.add("Reserva não pode ser null");
        }
        else{
            if ((reserva.getPessoa() == null))
                erros.add("Pessoa vaiza.");
            if ((reserva.getExemplar() == null))
                erros.add("Obrigatorio informar o exemplar.");
        }
        return erros;
    }
    
    public static List<String> validarReserva(Reserva reserva, ReservaDAO reservas){
        List<String> erros = new LinkedList<>();
        
        if(reserva == null){
            erros.add("Reserva não pode ser null");
        }
        else{
            if(reservas.listarTodos().size() == 0){
                if ((reserva.getPessoa() == null))
                    erros.add("Pessoa vaiza.");
                if ((reserva.getExemplar() == null))
                    erros.add("Obrigatorio informar o exemplar.");
            } else {
                if ((reserva.getPessoa() == null))
                    erros.add("Pessoa vaiza.");
                if ((reserva.getExemplar() == null))
                    erros.add("Obrigatorio informar o exemplar.");
                
                List<Reserva> result = reservas.listarTodos();
                for(Reserva res : result){
                    if(res.getPessoa().equals(reserva.getPessoa()) && res.getExemplar().equals(reserva.getExemplar())){
                        erros.add("Não pode ter mais de uma reserva para um mesmo exemplar.");
                    }
                }
            }
        }
        return erros;
    }
}
