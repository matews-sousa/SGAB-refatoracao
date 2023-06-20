package sgab.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.Obra;
import sgab.model.service.GestaoAcervo;
import sgab.model.service.GestaoBibliotecaService;
import sgab.model.service.GestaoObras;

@WebServlet(name = "Main", urlPatterns = {"/main"})
public class Main extends HttpServlet {   
    private String jsp = "";
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");

        switch (acao) {
            case "Logar":
                jsp = LoginController.logar(request);
                break;
            case "AssuntoListar":
                jsp = AssuntoController.listar(request);
                break;
            case "AssuntoAlterar":
                jsp = AssuntoController.alterar(request);
                break;
            case "AssuntoGravarAlteracao":
                jsp = AssuntoController.gravarAlteracao(request);
                break;
            case "AssuntoGravarInsercao":
                jsp = AssuntoController.gravarInsercao(request);
                break;           
            case "AssuntoExcluir":
                jsp = AssuntoController.excluir(request);
                break;
            case "ObraListar":
                jsp = ObraController.listar(request);
                break;
            case "ObraPesquisar":
                jsp = ObraController.pesquisar(request);
                break;
            case "ObraGravarInsercao":
                jsp = ObraController.gravarInsercao(request);
                break;
            case "ObraAlterar":
                jsp = ObraController.alterar(request);
                break;
            case "ObraGravarAlteracao":
                jsp = ObraController.gravarAlteracao(request);
                break;
            case "ObraExcluir":
                jsp = ObraController.excluir(request);
                break;                               
            case "PessoaPesquisar":
                jsp = PessoaController.pesquisarLogin(request);
                break;
            case "PessoaListar":
                jsp = PessoaController.listar(request);
                break;
            case "PessoaAlterar":
                jsp = PessoaController.alterar(request);
                break;
            case "PessoaGravarAlteracao":
                jsp = PessoaController.gravarAlteracao(request);
                break;
            case "PessoaGravarInsercao":
                jsp = PessoaController.gravarInsercao(request);
                break;
            case "PessoaExcluir":
                jsp = PessoaController.excluir(request);
            case "UnidadeOrganizacionalListar":
                jsp = UnidadeOrganizacionalController.listar(request);
                break;
            case "UnidadeOrganizacionalAlterar":
                jsp = UnidadeOrganizacionalController.alterar(request);
                break;
            case "UnidadeOrganizacionalGravarAlteracao":
                jsp = UnidadeOrganizacionalController.gravarAlteracao(request);
                break;
            case "UnidadeOrganizacionalGravarInsercao":
                jsp = UnidadeOrganizacionalController.gravarInsercao(request);
                break;           
            case "UnidadeOrganizacionalExcluir":
                jsp = UnidadeOrganizacionalController.excluir(request);
                break;
            case "AdministradorGravarInsercao":
                jsp = AdministradorController.gravarInsercaoAdministrador(request);
                break;
            case "AdministradorGravarAlteracao":
                jsp = AdministradorController.alterarAdministrador(request);
                break;
            case "AdministradorPesquisar":
                jsp = AdministradorController.pesquisarAdministradorLogin(request);
                break;
            case "AdministradorListar":
                jsp = AdministradorController.listarAdministradores(request);
                break;
            case "AdministradorAlterar":
                jsp = AdministradorController.alterarAdministrador(request);
                break;
            case "GestorGravarInsercao":
                jsp = AdministradorController.gravarInsercaoGestor(request);
                break;
            case "GestorGravarAlteracao":
                jsp = AdministradorController.alterarGestor(request);
                break;
            case "GestorPesquisar":
                jsp = AdministradorController.pesquisarGestorLogin(request);
                break;
            case "GestorListar":
                jsp = AdministradorController.listarGestores(request);
                break;
            case "GestorAlterar":
                jsp = AdministradorController.alterarGestor(request);
                break;
            case "AutorCadastrar":
                jsp = AutorController.insercao(request);
                break;
            case "AutorAlterar":
                jsp = AutorController.alterar(request);
                break;
             case "AutorPesquisar":
                jsp = AutorController.pesquisar(request);
                break;
            case "AutorExcluir":
                jsp = AutorController.excluir(request);
                break;  
            case "FornecedorListar":
                jsp = FornecedorController.listar(request);
                break;
            case "FornecedorAlterar":
                jsp = FornecedorController.alterar(request);
                break;
            case "FornecedorGravarAlteracao":
                jsp = FornecedorController.gravarAlteracao(request);
                break;
            case "FornecedorGravarInsercao":
                jsp = FornecedorController.gravarInsercao(request);
                break;
            case "FornecedorExcluir":
                jsp = FornecedorController.excluir(request);
                break;
            case "BibliotecaListar":
                jsp = BibliotecaController.listar(request);
                break;
            case "BibliotecaAlterar":
                jsp = BibliotecaController.alterar(request);
                break;
            case "BibliotecaGravarAlteracao":
                jsp = BibliotecaController.gravarAlteracao(request);
                break;
            case "BibliotecaGravarInsercao":
                jsp = BibliotecaController.gravarInsercao(request);
                break;
            case "BibliotecaExcluir":
                jsp = BibliotecaController.excluir(request);
                break;
            case "IniciaCadastroAquisicao":
                jsp = "/core/aquisicoes/pedir-passo1-leitor.jsp";
                break;
            case "AquisicaoCriar":
                jsp = AquisicaoController.gravarAquisicaoBibliotecario(request);
                break;
            case "AquisicaoPendente":
                jsp= AquisicaoController.gravarPendente(request);
                break;
            case "ListarAquisicoes":
                jsp = AquisicaoController.listarPendentes(request);
                break;
            case "AceitarAquisicao":
                jsp = AquisicaoController.pedir(request);
                break;
            case "RecusarAquisicao":
                jsp = AquisicaoController.recusar(request);
                break;
            case "ListarAquisicoesAtivos":
                jsp = AquisicaoController.listarAtivos(request);
                break;
            case "FinalizarAquisicao":
                jsp = AquisicaoController.gravarFinalizado(request);
                break;
            case "ListarAquisicoesFinalizadas":
                jsp = AquisicaoController.listarFinalizados(request);
                break;
            case "AquisicaoPedidoCriarObra":
                jsp = AquisicaoController.gravarPendente(request);
                break;
            case "ConfereAquisicao":
                jsp = AquisicaoController.mostraAquisicao(request);
                break;
            case "CadastrarObraAquisicao":
                jsp = AquisicaoController.cadastrarObra(request);
                break;
            case "GravarObraAquisicao":
                jsp = AquisicaoController.removerPendente(request);
                break;
            case "LeitorCadastrar":
                jsp = LeitorController.cadastrar(request);
                break;                
            case "AtendentePesquisar":
                jsp = GestorController.pesquisarAtendenteLogin(request);
                break;
            case "AtendenteListar":
                jsp = GestorController.listarAtendentes(request);
                break;
            case "AtendenteAlterar":
                jsp = GestorController.alterarAtendente(request);
                break;
            case "AtendenteGravarAlteracao":
                jsp = GestorController.gravarAlteracaoAtendente(request);
                break;
            case "AtendenteGravarInsercao":
                jsp = GestorController.gravarInsercaoAtendente(request);
                break;
            case "BibliotecarioPesquisar":
                jsp = GestorController.pesquisarAtendenteLogin(request);
                break;
            case "BibliotecarioListar":
                jsp = GestorController.listarBibliotecarios(request);
                break;
            case "BibliotecarioAlterar":
                jsp = GestorController.alterarBibliotecario(request);
                break;
            case "BibliotecarioGravarAlteracao":
                jsp = GestorController.gravarAlteracaoBibliotecario(request);
                break;
            case "BibliotecarioGravarInsercao":
                jsp = GestorController.gravarInsercaoBiblioteca(request);
                break;
            case "ListarAcervo":
                jsp = AcervoController.escolherBiblioteca(request);
                break;
            case "RestaurarExemplar":
                jsp = AcervoController.enviarReparo(request);
                break;
            case "RetornoRestauracao":
                jsp = AcervoController.receberReparo(request);
                break;
            case "DesativaExemplar":
                jsp = AcervoController.desativarExemplar(request);
                break;
            case "TransformaExemplarConsulta":
                jsp = AcervoController.registrarLivroConsulta(request);
                break;
            case "TransferirExemplar":
                jsp = AcervoController.registrarTransferencia(request);
                break;
            case "UsuarioListar":
                jsp = UsuarioController.listar(request);
                break;
            case "UsuarioExcluir":
                jsp = UsuarioController.excluir(request);
                break;
            case "UsuarioInserir":
                jsp = UsuarioController.gravarInsercao(request);
                break;
            case "IniciarReservar":
                jsp = ReservaController.listarExemplares(request);
                break;
            case "ListarReservar":
                jsp = ReservaController.listarReservas(request);
                break;
            case "ReservarExemplar":
                jsp = ReservaController.reservar(request);
                break;
            case "ReservarPesquisarExemplar":
                jsp = ReservaController.pesquisarListaExemplares(request);
                break;
            case "ReservarPesquisar":
                jsp = ReservaController.pesquisarListaReservas(request);
                break;
            case "FinalizarReserva":
                jsp = ReservaController.finalizar(request);
                break;
            case "EmprestarReserva":
                jsp = ReservaController.emprestar(request);
                break;
            case "GravaDevolucao":
                jsp = DevolucaoController.GravaDevolucao(request);
                break;
            case "ListarRestaurar":
                jsp = AcervoController.listarRestaurar(request);
                break;
            case "ListarConsulta":
                jsp = AcervoController.listarConsulta(request);
                break;
            case "ListarTransferencia":
                jsp = AcervoController.listarTransferencia(request);
                break;
            case "MostraExemplar":
                jsp = AcervoController.mostraExemplar(request);
                break;
            case "ListarAcervoBiblioteca":
                jsp = AcervoController.listarAcervoBiblioteca(request);
                break;
            case "AceitaExemplar":
                jsp = AcervoController.aceitarExemplar(request);
                break;
            case "EmprestimoListar":
                jsp = EmprestimoController.listar(request);
                break;
            case "EmprestimoSolicitar":
                jsp = EmprestimoController.gravarEmprestimo(request);
                break;
        }
                 
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }    
}

