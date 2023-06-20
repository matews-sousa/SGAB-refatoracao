package sgab.util;

import java.util.ArrayList;
import java.util.List;
import sgab.model.dao.*;
import sgab.model.dto.*;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.util.UsuarioTipo;
import sgab.model.service.*;

public class InitDB {

    private static boolean initAccess;
    static {
        initAccess = false;
    }

    private static void cadastrarAssunto() {
        GestaoAssuntoService manterAssunto = new GestaoAssuntoService();
        manterAssunto.cadastrar(new Assunto("Algoritmos"));
        manterAssunto.cadastrar(new Assunto("Estruturas de Dados"));
        manterAssunto.cadastrar(new Assunto("Lógica de Programação"));
        manterAssunto.cadastrar(new Assunto("Linguagem de Programação"));
        manterAssunto.cadastrar(new Assunto("Projeto de Algoritmos"));
        manterAssunto.cadastrar(new Assunto("Compiladores"));
        manterAssunto.cadastrar(new Assunto("Teoria da Computação"));
        manterAssunto.cadastrar(new Assunto("Java"));        
        manterAssunto.cadastrar(new Assunto("Redes de Computadores"));
    }

    private static void cadastrarAutor() {

        GestaoAutor manterAutor = new GestaoAutor();
        manterAutor.cadastrarAutor(new Autor("Alfred V. Aho"));
        manterAutor.cadastrarAutor(new Autor("Andrew S. Tanenbaum"));
        manterAutor.cadastrarAutor(new Autor("Cay S. Horstmann"));
        manterAutor.cadastrarAutor(new Autor("Dale Skrien"));
        manterAutor.cadastrarAutor(new Autor("David J. Wetherall"));
        manterAutor.cadastrarAutor(new Autor("Thomas H. Cormen"));
        manterAutor.cadastrarAutor(new Autor("Herbert Schildt"));
        manterAutor.cadastrarAutor(new Autor("Carlos Drummond de Andrade"));
        manterAutor.cadastrarAutor(new Autor("Machado de Assis"));
        manterAutor.cadastrarAutor(new Autor("Manoel Bandeira"));
        manterAutor.cadastrarAutor(new Autor("Cecília Meireles"));
    }

    private static void cadastrarBiblioteca() {
        GestaoBibliotecaService manterBiblioteca = new GestaoBibliotecaService();
        UnidadeOrganizacionalDAO uOrgDAO = UnidadeOrganizacionalDAO.getInstance();

        Biblioteca biblioteca = new Biblioteca("Biblioteca Campus I");
        biblioteca.setUnidadeOrganizacional(uOrgDAO.pesquisarPorNome("Campus Nova Suíça"));
        manterBiblioteca.cadastrar(biblioteca);
        
        biblioteca = new Biblioteca("Biblioteca Campus II");
        biblioteca.setUnidadeOrganizacional(uOrgDAO.pesquisarPorNome("Campus Nova Gameleira"));
        manterBiblioteca.cadastrar(biblioteca);
        
        biblioteca = new Biblioteca("Biblioteca Unidade Contagem");
        biblioteca.setUnidadeOrganizacional(uOrgDAO.pesquisarPorNome("Unidade Contagem"));
        manterBiblioteca.cadastrar(biblioteca);
        
        biblioteca = new Biblioteca("Biblioteca Leopoldina");
        biblioteca.setUnidadeOrganizacional(uOrgDAO.pesquisarPorNome("Unidade Leopoldina"));
        manterBiblioteca.cadastrar(biblioteca);

        biblioteca = new Biblioteca("Biblioteca Varginha");
        biblioteca.setUnidadeOrganizacional(uOrgDAO.pesquisarPorNome("Unidade Varginha"));
        manterBiblioteca.cadastrar(biblioteca);
    }

    private static void cadastrarFornecedor() {
        GestaoFornecedoresService manterFornecedor = new GestaoFornecedoresService();

        Fornecedor fornecedor = new Fornecedor(123456L);
        fornecedor.setNomeFornecedor("Editora Prentice Hall");
        fornecedor.setEmail("representante@prentice-hall.com");
        fornecedor.setEndereco("Rua das Camélias, 2500");
        fornecedor.setCep(31123321L);
        fornecedor.setTelefone(553133196800L);
        manterFornecedor.cadastrar(fornecedor);
        
        fornecedor = new Fornecedor(234567L);
        fornecedor.setNomeFornecedor("Editora LTC");
        fornecedor.setEmail("representante@ltc.com.br");
        fornecedor.setEndereco("Av. Brasil, 5000");
        fornecedor.setCep(30535610L);
        fornecedor.setTelefone(551144443333L);
        manterFornecedor.cadastrar(fornecedor);
        
    }

    private static void cadastrarObra() {
        GestaoObras manterObra = new GestaoObras();
        GestaoAutor manterAutor = new GestaoAutor();        
        GestaoAssuntoService manterAssunto = new GestaoAssuntoService();
        List<Autor> autores;
        List<Assunto> assuntos;
        
        Obra obra = new Obra("Algoritmos - Teoria e Prática");
        obra.setCategoria("Livro");
        obra.setNota("Apresenta um texto abrangente sobre o moderno estudo de "
                + "algoritmos para computadores. É uma obra clássica, cuja "
                + "primeira edição tornou-se amplamente adotada nas melhores "
                + "universidades em todo o mundo, bem como padrão de referência "
                + "para profissionais da área.");
        obra.setAnoPublicacao(2012);
        obra.setEditora("LTC");
        obra.setCidadeEditora("Rio de Janeiro");
        obra.setEdicao(3);
        obra.setVolume(1);
        
        autores = new ArrayList<>();
        autores.add(manterAutor.pesquisarNome("Thomas H. Cormen"));
        obra.setAutor(autores);
        
        assuntos = new ArrayList<>();
        assuntos.add(manterAssunto.pesquisarAssunto("Algoritmos"));
        assuntos.add(manterAssunto.pesquisarAssunto("Estruturas de Dados"));
        assuntos.add(manterAssunto.pesquisarAssunto("Projeto de Algoritmos"));
        obra.setAssunto(assuntos);
        
        manterObra.cadastrarObra(obra);
    }

    private static void cadastrarPessoa() {
        GestaoPessoasService manterPessoa = new GestaoPessoasService();
        Pessoa pessoa;
        
        pessoa = new Pessoa("sauro", 12345678912L);
        pessoa.setNome("Jose da Silva Sauro");
        pessoa.setEmail("sauro@gmail.com");
        pessoa.setSenha("Sauro12!");
        pessoa.setTipo(UsuarioTipo.LEITOR);
        pessoa.setTipo(UsuarioTipo.GESTOR);
        manterPessoa.cadastrar(pessoa);
        
        pessoa = new Pessoa("quatro", 23456789012L);
        pessoa.setNome("Um Dois Tres de Oliveira Quatro");
        pessoa.setEmail("quatro@gmail.com");
        pessoa.setSenha("Oliveira1!");
        pessoa.setTipo(UsuarioTipo.ADMINISTRADOR);
        manterPessoa.cadastrar(pessoa);
        
    }
    
    private static void cadastrarUnidadeOrganizacional() {
        GestaoUnidadeOrganizacionalService uOrgService = new GestaoUnidadeOrganizacionalService();

        uOrgService.cadastrar(new UnidadeOrganizacional("Campus Nova Suíça", 
                "Av. Amazonas, 5253 - Nova Suíça, Belo Horizonte/MG"));
        uOrgService.cadastrar(new UnidadeOrganizacional("Campus Nova Gameleira", 
                "Av. Amazonas, 7675 - Nova Gameleira, Belo Horizonte/MG"));
        uOrgService.cadastrar(new UnidadeOrganizacional("Unidade Contagem", 
                "Alameda das Perdizes, 61 - Bairro Cabral, Contagem/MG"));
        uOrgService.cadastrar(new UnidadeOrganizacional("Unidade Leopoldina", 
                "Rua José Peres, 558 - Centro, Leopoldina/MG"));
        uOrgService.cadastrar(new UnidadeOrganizacional("Unidade Varginha", 
                "Av. dos Imigrantes, 1000 - Varginha/MG"));
    }
    
    public static void init() {
        if (initAccess)
            return;
        
        InitDB.cadastrarAssunto();
        InitDB.cadastrarAutor();
        InitDB.cadastrarUnidadeOrganizacional();
        InitDB.cadastrarBiblioteca();
        InitDB.cadastrarFornecedor();
        InitDB.cadastrarObra();
        InitDB.cadastrarPessoa();
        
        initAccess = true;
    }
    
}