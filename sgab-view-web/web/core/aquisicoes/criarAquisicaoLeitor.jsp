<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
<% String nomeObra = (String) request.getAttribute("nomeObra"); %>

<center>
    <h3>Criar aquisição de Obra</h3>
    <p>Preencha o Título, a Biblioteca que deseja, e os campos que achar necessário para identificar a Obra que deseja requisitar.</p>    
</center>
<section id="form">
  <div id="caixa-form">
    <form name="frmCriaAquisicao" method="post">
      <input type="hidden" name="table" value="AquisicaoLeitor" />
      <input type="hidden" value="segundo-criarObra" name="etapa" />
      <label for="categoria">Categoria</label>
      <select name="categoria" id="categoria">
        <option value="livro">Livro</option>
        <option value="mapa">Mapa</option>
        <option value="docComputacional">Documento computacional</option>
      </select>
      <label for="titulo">Título</label>
      <input
        type="text"
        id="titulo"
        name="titulo"
        placeholder="Insira o título da obra"
        value="<%= nomeObra %>"
      />
      <!-- TODO AUTORES -->
      <label>Autores</label>
      <span
        onclick="abreModal('pesquisaAutor')"
        style="
          float: right;
          font-weight: bolder;
          font-size: 1.5em;
          cursor: pointer;
          user-select: none;
        "
        >+</span
      >
      <input id="autores-input" type="hidden" name="autores" value="">
      <div id="autores" style="padding-top: 10px;"></div>

      <!-- TODO ASSUNTOS -->
      <label>Assuntos</label>
      <span
        onclick="abreModal('pesquisaAssunto')"
        style="
          float: right;
          font-weight: bolder;
          font-size: 1.5em;
          cursor: pointer;
          user-select: none;
        "
        >+</span
      >
      <input id="assuntos-input" type="hidden" name="assuntos" value="">
      <div id="assuntos" style="padding-top: 10px;"></div>

      <label for="nota">Nota</label>
      <input
        type="text"
        style="height: 5em"
        id="nota"
        name="nota"
        placeholder="Insira uma breve descrição"
      />
      <div class="divisao">
        <div>
          <label for="ano">Ano de publicação</label>
          <input type="number" id="ano" name="ano" placeholder="Ex.: 1987" />
        </div>
        <div>
          <label for="editora">Editora</label>
          <input
            type="text"
            id="editora"
            name="editora"
            placeholder="Ex.: Fundamento"
          />
        </div>
      </div>
      <label for="cidEditora">Cidade da Editora</label>
      <input
        type="text"
        id="cidEditora"
        name="cidEditora"
        placeholder="Ex.: São Paulo"
      />
      <div class="divisao">
        <div>
          <label for="edicao">Edição</label>
          <input
            type="number"
            id="edicao"
            name="edicao"
            placeholder="Insira a edição"
          />
        </div>
        <div>
          <label for="volume">Volume</label>
          <input type="number" id="volume" name="volume" placeholder="Ex.: 1" />
        </div>
      </div>
      <div class="buttons">
        <button type="button" onclick="gravarAlteracao(document.frmCriaAquisicao)">
          Enviar
        </button>
      </div>
    </form>
  </div>
</section>

<!--Mask-->
<div id="mask" onclick="fechaModalAll()"></div>

<!-- Modal Autores-->
<div class="form-popup" id="pesquisaAutor">
  <div class="close-btn" onclick="fechaModal('pesquisaAutor')">&times;</div>
  <form class="form-container">
    <h2>Adicionar Autor</h2>
    <div>
      <div class="pesquisa-container">
        <input type="text" id="nomeAutor" placeholder="Insira o nome do autor." />
        <input class="button" type="button" onclick="ajaxAutor()" value="Pesquisar" />
      </div>
      <div id="resultados-pesquisa-autores"></div>
    </div>
  </form>
</div>

<!-- Modal Assuntos-->
<div class="form-popup" id="pesquisaAssunto">
  <div class="close-btn" onclick="fechaModal('pesquisaAssunto')">&times;</div>
  <form class="form-container">
    <h2>Adicionar Assunto</h2>
    <div class="pesquisa-container">
       <input type="text" id="nomeAssunto" placeholder="Insira o assunto." />
       <input class="button" type="button" onclick="ajaxAssunto()" value="Pesquisar" />
    </div>
    <div id="resultados-pesquisa-assuntos"></div>
  </form>
</div>

<script src="/sgab/js/cssControl.js"></script>
<script src="/sgab/js/ajaxControl.js"></script>

<%@include file="/core/footer.jsp" %>
