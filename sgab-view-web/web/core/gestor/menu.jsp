<!doctype html>
<html class="no-js" lang="">
<html>
<head>
  <meta charset="utf-8">
  <title>SGAB | Página do Atendente</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta property="og:title" content="">
  <meta property="og:type" content="">
  <meta property="og:url" content="">
  <meta property="og:image" content="">

  <link rel="manifest" href="site.webmanifest">
  <link rel="apple-touch-icon" href="icon.png">
  <meta name="theme-color" content="#fafafa">
</head>

<%@include file="/core/header.jsp" %>

  <main>
    <section id="nome-form">
    </section>
    <section>
      <div class="caixa-gestao">
        <h2>Operações de Bibliotecários</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroBibliotecario')">Cadastrar</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoBibliotecario')">Editar</button>
        <button class="button-gestao" onclick="abreModal('formListarBibliotecario')">Listar</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Atendente</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroAtendente')">Cadastrar</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoAtendente')">Editar</button>
        <button class="button-gestao" onclick="abreModal('formListarAtendente')">Listar</button>
      </div>
      <br>
    </section>

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroBibliotecario">
      <div class="close-btn" onclick="fechaModal('formCadastroBibliotecario')">&times;</div>
      <form class="form-container" method="POST" name="GravarBibliotecario">
        <h2> Cadastrar</h2>
        <div>
          
          <h3>Cadastrar</h3>

          <input type="hidden" name="table" value="Bibliotecario">
          <input type="hidden" name="acao" value="gravar">
            
          <label>Nome do bibliotecário(a): <input type="text" placeholder="Nome de usuário do(a) bibliotecário(a):" name="login" required></label>

          <button type="button" class="button-form" onclick="gravarAlteracao(document.GravarBibliotecario)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar bibliotecário -->
    <div class="form-popup" id="formEdicaoBibliotecario">
      <div class="close-btn" onclick="fechaModal('formEdicaoBibliotecario')">&times;</div>
      <form class="form-container" method="POST" name="EdicaoBibliotecario">
        <h2> Editar bibliotecário:</h2>
        
        <h3>Editar</h3>
        
        <div>
          <input type="hidden" name="table" value="Bibliotecario">
          <input type="hidden" name="acao" value="alterar">
          <label>Nome de usuario: <input type="email" placeholder="Nome ou Email do(a) bibliotecário(a)" name="login" required></label>
          <button type="button" class="button-form" onclick="gravarAlteracao(document.EdicaoBibliotecario)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- FormulÃ¡rios Pop-up -->

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroAtendente">
      <div class="close-btn" onclick="fechaModal('formCadastroAtendente')">&times;</div>
      <form class="form-container" method="POST" name="GravarAtendente">
        <h2> Cadastrar</h2>
        <div>
          
          <h3>Cadastrar</h3>
          <input type="hidden" name="table" value="Atendente">
          <input type="hidden" name="acao" value="gravar">
            
          <label>Nome do bibliotecário(a): <input type="text" placeholder="Nome de usuário do(a) atendente:" name="login" required></label>
          
          <button type="button" class="button-form" onclick="gravarAlteracao(document.GravarAtendente)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar atendente -->
    <div class="form-popup" id="formEdicaoAtendente">
      <div class="close-btn" onclick="fechaModal('formEdicaoAtendente')">&times;</div>
      <form class="form-container" method="POST" name="EdicaoAtendente">
        <h2> Editar</h2>
        <div>
          <input type="hidden" name="table" value="Atendente">
          <input type="hidden" name="acao" value="alterar">
          <label>Nome de usuario: <input type="email" placeholder="Nome ou Email do(a) bibliotecário(a)" name="login" required></label>
          <button type="button" class="button-form" onclick="gravarAlteracao(document.EdicaoAtendente)">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formListarBibliotecario">
      <div class="close-btn" onclick="fechaModal('formListarBibliotecario')">&times;</div>
      <form class="form-container" method="POST" name="loginBibliotecario">
        <div>
        <input type="hidden" name="table" value="Bibliotecario">
        <input type="hidden" name="acao" value="pesquisarPorLogin">
        
        <button type="button" class="button-form" onclick="pesquisar(document.loginBibliotecario)">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formListarAtendente">
      <div class="close-btn" onclick="fechaModal('formListarAtendente')">&times;</div>
      <form class="form-container" method="POST" name="loginAtendente">
        <div>
        <input type="hidden" name="table" value="Atendente">
        <input type="hidden" name="acao" value="pesquisarPorLogin">
        
        <button type="button" class="button-form" onclick="pesquisar(document.loginAtendente)">Enviar</button>
        </div>
      </form>
    </div>

    <div id="mask" onclick="fechaModalAll()"></div>

  <%@include file="/core/footer.jsp" %>
  <!-- JS -->
  <script src="../../js/abreModal.js"></script>
  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/modal.css">
  <link rel="stylesheet" href="../../css/styles.css">


