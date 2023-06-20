<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8">
  <title>SGAB | Página dos Bibliotecarios</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta property="og:title" content="">
  <meta property="og:type" content="">
  <meta property="og:url" content="">
  <meta property="og:image" content="">

  <link rel="manifest" href="site.webmanifest">
  <link rel="apple-touch-icon" href="icon.png">


  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="css/styles.css">

  <meta name="theme-color" content="#fafafa">
</head>

<body>
  <header>
    <div id="pagina-inicial">
      <a href="" title="Página Inicial">SGAB</a>
    </div>
    <div id="logo-topo">
      <a href="https://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
        <img src="img/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais">
      </a>
    </div>
  </header>

  <main>
    <section id="nome-form">
      <h1>Página dos Bibliotecários</h1>
    </section>
    <section>
      <div class="caixa-gestao">
        <h2>Operações de Fornecedores</h2>
        <button ><a href="/core/fornecedor/cadastro.jsp"></a>Cadastrar fornecedor</button> <!-- fazer um hyperlink mandando para pagina de cadastro-->
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Livros</h2>
        <button class="button-gestao"><a href="/core/obra/inserir.jsp"></a>Cadastrar obra</button> <!--hyperlink parar as paginas de obra-->
        <button class="button-gestao"><a href="SGAB/sgab-view-web/web/core/obra/listar.jsp"></a>Listar obras</button>
        <button class="button-gestao">Restauração</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Autores</h2>
        <button class="button-gestao"><a href="SGAB/sgab-view-web/web/core/autores/cadastrar.jsp"></a>Cadastrar autores</button>>
      </div>
      <br>
       <div class="caixa-gestao">
        <h2>Operações de Assuntos</h2>
        <button class="button-gestao"><a href="SGAB/sgab-view-web/web/core/autores/inserir.jsp"></a>Cadastrar assuntos</button>>
      </div>
      <br>
      

    </section>
  </main>

  <footer>
    <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
  </footer>

  <!-- JS -->
  <script src="js/vendor/modernizr-3.11.2.min.js"></script>
  <script src="js/plugins.js"></script>
  <script src="js/main.js"></script>
  <script src="js/script.js"></script>

</body>

</html>

