package sgab.autorizacao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sgab.model.dto.util.UsuarioTipo;

class Permissao {

    private String recurso;
    private Set<UsuarioTipo> usuarios;

    public Permissao(String recurso) {
        this.recurso = recurso;
        this.usuarios = new HashSet<>();
    }

    public void addUsuarioGrupo(UsuarioTipo usuario) {
        usuarios.add(usuario);
    }

    public String getRecurso() {
        return recurso;
    }

    public boolean check(UsuarioTipo usuario) {
        return usuarios.contains(usuario);
    }
}

public class ControleAutorizacao {

    private ControleAutorizacao() {
    }

    private final static Map<String, Permissao> permissoes;

    static {
        permissoes = new HashMap<>();
        inicializarPermissoes();
    }

    private static void inicializarPermissoes() {
        Permissao permissao = new Permissao("aquisicao");
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissao.addUsuarioGrupo(UsuarioTipo.LEITOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("assunto");
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("autor");
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("obra");
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("fornecedor");
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("acervo");
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("biblioteca");
        permissao.addUsuarioGrupo(UsuarioTipo.ADMINISTRADOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("unidade");
        permissao.addUsuarioGrupo(UsuarioTipo.ADMINISTRADOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("usuario");
        permissao.addUsuarioGrupo(UsuarioTipo.ADMINISTRADOR);
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissao.addUsuarioGrupo(UsuarioTipo.GESTOR);
        permissao.addUsuarioGrupo(UsuarioTipo.ATENDENTE);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("pessoa");
        permissao.addUsuarioGrupo(UsuarioTipo.ADMINISTRADOR);
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissao.addUsuarioGrupo(UsuarioTipo.GESTOR);
        permissao.addUsuarioGrupo(UsuarioTipo.ATENDENTE);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("reserva");
        permissao.addUsuarioGrupo(UsuarioTipo.BIBLIOTECARIO);
        permissao.addUsuarioGrupo(UsuarioTipo.LEITOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("usuario-administrador");
        permissao.addUsuarioGrupo(UsuarioTipo.ADMINISTRADOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("usuario-gestor");
        permissao.addUsuarioGrupo(UsuarioTipo.ADMINISTRADOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("usuario-bibliotecario");
        permissao.addUsuarioGrupo(UsuarioTipo.GESTOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("usuario-atendente");
        permissao.addUsuarioGrupo(UsuarioTipo.GESTOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("usuario-leitor");
        permissao.addUsuarioGrupo(UsuarioTipo.ATENDENTE);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("emprestimo");
        permissao.addUsuarioGrupo(UsuarioTipo.ATENDENTE);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("reserva");
        permissao.addUsuarioGrupo(UsuarioTipo.LEITOR);
        permissoes.put(permissao.getRecurso(), permissao);

        permissao = new Permissao("devolucao");
        permissao.addUsuarioGrupo(UsuarioTipo.ATENDENTE);
        permissoes.put(permissao.getRecurso(), permissao);
    }

    public static boolean checkPermissao(String recurso, UsuarioTipo usuario) {
        return permissoes.get(recurso).check(usuario);
    }

    public static boolean checkPermissao(String recurso, List<UsuarioTipo> tipoList) {
        for (UsuarioTipo usuario: tipoList)
            if (permissoes.get(recurso).check(usuario))
                return true;
        
        return false;
    }
    
    public static boolean checkAquisicao(List<UsuarioTipo> tipoList){
        if(tipoList.contains(UsuarioTipo.BIBLIOTECARIO)){
            return true;
        }
        
        return false;
    }
}
