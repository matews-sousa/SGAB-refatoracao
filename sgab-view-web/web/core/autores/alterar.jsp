<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Alterar</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="/sgab/css/styles.css">
</head>

<body>
  <header>
    <div id="pagina-inicial">
      <a href="" title="Página Inicial">
        Biblioteca
      </a>
    </div>
    <div id="logo-topo">
      <a href="http://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
        <img src="/sgab/images/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais">
      </a>
    </div>
  </header>
  <main>
    <section id="nome-form">
      <h1>Alteração do autor</h1>
    </section>
    <section id="form">
      <div id="caixa-form">
        <form  name="alterar" method="POST">
          <input type="hidden" name="table" value="Autor">  
          <input type="hidden" name="acao" value="alterar"><!-- Nome da tabela que será alterada -->
          <label for="idAutor">ID do autor</label>
          <input type="text" id="idAutor" name="idAutor" placeholder="Coloque o id do autor">
          <label for="nomeAutor">Novo nome do autor</label>
          <input type="text" id="nomeAutor" name="nomeAutor" placeholder="Digite o novo Nome">
          <button type="submit" onclick="gravarAlteracao(document.alterar)">Alterar</button>
        </form>
      </div>
    </section>
  </main>
  <footer>
  </footer>
  <script src="../../js/helper.js"></script>
</body>

</html>