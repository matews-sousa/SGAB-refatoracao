<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.util.UsuarioTipo" %>
<%@page import="sgab.model.dto.Pessoa"%>
<%@page import="sgab.autorizacao.ControleAutorizacao"%>

<%@include file="/core/header.jsp" %>

<section>
    <% if (ControleAutorizacao.checkPermissao("usuario-administrador", usuario.getTipo())) {%>
    <div class="caixa-gestao">
        <h2>Gestão de Administradores</h2>
        <button class="button-gestao" onclick="abreModal('formCadastrarAdministrador')">Cadastrar</button>
        <a href="/sgab/main?acao=UsuarioListar&usuarioTipo=<%=UsuarioTipo.ADMINISTRADOR%>"><button class="button-gestao">Listar</button></a>
    </div>
    <br>
    <% } if (ControleAutorizacao.checkPermissao("usuario-atendente", usuario.getTipo())) {%>
    <div class="caixa-gestao">
        <h2>Gestão de Atendentes</h2>
        <button class="button-gestao" onclick="abreModal('formCadastrarAtendente')">Cadastrar</button>
        <a href="/sgab/main?acao=UsuarioListar&usuarioTipo=<%=UsuarioTipo.ATENDENTE%>"><button class="button-gestao">Listar</button></a>
    </div>
    <br>
    <% } if (ControleAutorizacao.checkPermissao("usuario-bibliotecario", usuario.getTipo())) {%>
    <div class="caixa-gestao">
        <h2>Gestão de Bibliotecários</h2>
        <button class="button-gestao" onclick="abreModal('formCadastrarBibliotecario')">Cadastrar</button>
        <a href="/sgab/main?acao=UsuarioListar&usuarioTipo=<%=UsuarioTipo.BIBLIOTECARIO%>"><button class="button-gestao">Listar</button></a>
    </div>
    <br>
    <% } if (ControleAutorizacao.checkPermissao("usuario-gestor", usuario.getTipo())) {%>
    <div class="caixa-gestao">
        <h2>Gestão de Gestores</h2>
        <button class="button-gestao" onclick="abreModal('formCadastrarGestor')">Cadastrar</button>
        <a href="/sgab/main?acao=UsuarioListar&usuarioTipo=<%=UsuarioTipo.GESTOR%>"><button class="button-gestao">Listar</button></a>
    </div>
    <br>
    <% } if (ControleAutorizacao.checkPermissao("usuario-leitor", usuario.getTipo())) {%>
    <div class="caixa-gestao">
        <h2>Gestão de Leitores</h2>
        <button class="button-gestao" onclick="abreModal('formCadastrarLeitor')">Cadastrar</button>
        <a href="/sgab/main?acao=UsuarioListar&usuarioTipo=<%=UsuarioTipo.LEITOR%>"><button class="button-gestao">Listar</button></a>
    </div>
    <br>           
    <% }%>
</section>

<!-- Form cadastrar Administrador -->
<div class="form-popup" id="formCadastrarAdministrador">
    <div class="close-btn" onclick="fechaModal('formCadastrarAdministrador')">&times;</div>
    <form class="form-container" name="cadastrarAdministrador" method="POST">
        <div>
            <h2>Cadastrar Administrador</h2>
        </div>
        <div>
            <input type="hidden" name="usuarioTipo" value="ADMINISTRADOR">
            <div>
                <label>Código de pessoa: <span class="input-obrigatorio">*</span></label>
                <input type="text" name="pessoaId" placeholder="Id do administrador" required>
            </div>
            <button type="button" class="button-form" onclick="inserirUsuario(document.cadastrarAdministrador)">Gravar</button>
        </div>
    </form>
</div>

<!-- Form cadastrar Atendente -->
<div class="form-popup" id="formCadastrarAtendente">
    <div class="close-btn" onclick="fechaModal('formCadastrarAtendente')">&times;</div>
    <form class="form-container" name="cadastrarAtendente" method="POST">
        <div>
            <h2>Cadastrar Atendente</h2>
        </div>
        <div>
            <input type="hidden" name="usuarioTipo" value="ATENDENTE">
            <div>
                <label>Código de pessoa: <span class="input-obrigatorio">*</span></label>
                <input type="text" name="pessoaId" placeholder="Id do atendente" required>
            </div>
            <button type="button" class="button-form" onclick="inserirUsuario(document.cadastrarAtendente)">Gravar</button>
        </div>
    </form>
</div>

<!-- Form cadastrar Bibliotecário -->
<div class="form-popup" id="formCadastrarBibliotecario">
    <div class="close-btn" onclick="fechaModal('formCadastrarBibliotecario')">&times;</div>
    <form class="form-container" name="cadastrarBibliotecario" method="POST">
        <div>
            <h2>Cadastrar Bibliotecário</h2>
        </div>
        <div>
            <input type="hidden" name="usuarioTipo" value="BIBLIOTECARIO">
            <div>
                <label>Código de pessoa: <span class="input-obrigatorio">*</span></label>
                <input type="text" name="pessoaId" placeholder="Id do bibliotecário" required>
            </div>
            <button type="button" class="button-form" onclick="inserirUsuario(document.cadastrarBibliotecario)">Gravar</button>
        </div>
    </form>
</div>

<!-- Form cadastrar Gestor -->
<div class="form-popup" id="formCadastrarGestor">
    <div class="close-btn" onclick="fechaModal('formCadastrarGestor')">&times;</div>
    <form class="form-container" name="cadastrarGestor" method="POST">
        <div>
            <h2>Cadastrar Gestor</h2>
        </div>
        <div>
            <input type="hidden" name="usuarioTipo" value="GESTOR">
            <div>
                <label>Código de pessoa: <span class="input-obrigatorio">*</span></label>
                <input type="text" name="pessoaId" placeholder="Id do gestor" required>
            </div>
            <button type="button" class="button-form" onclick="inserirUsuario(document.cadastrarGestor)">Gravar</button>
        </div>
    </form>
</div>

<!-- Form cadastrar Leitor -->
<div class="form-popup" id="formCadastrarLeitor">
    <div class="close-btn" onclick="fechaModal('formCadastrarLeitor')">&times;</div>
    <form class="form-container" name="cadastrarLeitor" method="POST">
        <div>
            <h2>Cadastrar Leitor</h2>
        </div>
        <div>
            <input type="hidden" name="usuarioTipo" value="LEITOR">

            <div>
                <label>Código de pessoa: <span class="input-obrigatorio">*</span></label>
                <input type="text" name="pessoaId" placeholder="Id do leitor" required>
            </div>
            <button type="button" class="button-form" onclick="inserirUsuario(document.cadastrarLeitor)">Gravar</button>
        </div>
    </form>
</div>

<!-- <div id="mask" onclick="fechaModalAll()"></div> -->

<script src="/sgab/js/helper.js"></script>
<script src="/sgab/js/abreModal.js"></script>


<link rel="stylesheet" href="/sgab/css/normalize.css">
<link rel="stylesheet" href="/sgab/css/modal.css">
<link rel="stylesheet" href="/sgab/css/styles.css">

<%@include file="/core/footer.jsp" %>  