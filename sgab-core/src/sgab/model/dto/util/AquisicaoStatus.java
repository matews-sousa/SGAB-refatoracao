package sgab.model.dto.util;

public enum AquisicaoStatus {
   PENDENTE,       // esperando aprovação
   ATIVO,          // aprovado e ativo
   CANCELADO,     // nn foi aceito e ai é desativado/excluido
   FINALIZADA;    // terminou a aquisição
}