package sgab.model.dto.util;//validação dos dados inseridos pelo usuário

import java.util.ArrayList;
import sgab.model.dto.Assunto;

/**
 *
 * @author Yuri
 */

public class AssuntoHelper {

    public static boolean validar(Assunto assunto) {
        if(assunto == null || assunto.getNome() == null || assunto.getNome().length() == 0)
            return false;

        return true;
    }

    public static int validar(Assunto assunto, ArrayList<Assunto> assuntoLista) {
        if (assuntoLista.contains(assunto)) {
            return 1;
        }
        if(assunto == null) {
            return 2;
        }
        return 0;
    }
}