package sgab.model.dto.util;

public enum UsuarioTipo {
   ADMINISTRADOR,
   ATENDENTE,
   BIBLIOTECARIO,
   LEITOR,
   GESTOR;


   public static UsuarioTipo strTo(String strTipo) {
      switch (strTipo) {
         case "ADMINISTRADOR" :
            return ADMINISTRADOR;
         case "ATENDENTE" :
            return ATENDENTE;
         case "BIBLIOTECARIO" :
            return BIBLIOTECARIO;
         case "LEITOR" :
            return LEITOR;
         case "GESTOR" :
            return GESTOR;
      }

      throw new RuntimeException(strTipo + " não é um tipo válido.");
   }

}