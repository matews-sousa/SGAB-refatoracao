<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sgab.model.dto.Obra" %>
<%@page import="sgab.model.dto.Autor" %>
<%@page import="sgab.model.dto.Assunto" %>

<%@include file="/core/header.jsp" %>

<% 
   Obra obraAlvo = (Obra) request.getAttribute("obra");
%>
  <center><h3>Cadastro de Obra</h3></center>
      <section id="form">
        <div id="caixa-form">
          <form id="AlteraObra" name="GravaObra" method="post">
            <input type="hidden" name="table" value="AquisicaoObra">
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
              value="<%= obraAlvo.getTitulo()%>"
            />
           
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
            <input id="autores-input" type="hidden" name="autores" value="<% for(Autor autorAtual:obraAlvo.getAutor()){ %><%= autorAtual.getNome()%>::<% } %>">
            <div id="autores" style="padding-top: 10px;">
              <% for(Autor autorAtual:obraAlvo.getAutor()){ %>
                <div class="acoes" id="<%= autorAtual.getNome()%>"><span><%= autorAtual.getNome()%></span></div>
              <% } %>
            </div>
            
            <label>Assuntos</label>
            <span
                onclick="abreModal('pesquisaAssunto')"
                style="
                  float: right;
                  font-weight: bolder;
                  font-size: 1.5em;
                  cursor: pointer;
                  user-select: none;
                ">
                +
            </span>
            <input id="assuntos-input" type="hidden" name="assuntos" value="<% for(Assunto assuntoAtual:obraAlvo.getAssunto()){ %><%= assuntoAtual.getNome()%>::<% } %>">
            <div id="assuntos" style="padding-top: 10px;">
                <% for(Assunto assuntoAtual:obraAlvo.getAssunto()){ %>
                <div class="acoes" id="<%= assuntoAtual.getNome()%>"><span><%= assuntoAtual.getNome()%></span></div>
              <% } %>
            </div>

            <label for="nota">Nota</label>
            <input
              type="text"
              style="height: 5em;"
              id="nota"
              name="nota"
              value="<%= obraAlvo.getNota()%>"
            />
            <div class="divisao">
              <div>
                <label for="ano">Ano de publicação</label>
                <input
                  type="number"  
                  id="ano"
                  name="ano"
                  value=<%= obraAlvo.getAnoPublicacao()%>
                />
              </div>
              <div>
                <label for="editora">Editora</label>
                <input
                  type="text"
                  id="editora"
                  name="editora"
                  value="<%= obraAlvo.getEditora()%>"
                />
              </div>
            </div>
            <label for="cidEditora">Cidade da Editora</label>
            <input
              type="text"
              id="cidEditora"
              name="cidEditora"
              value="<%= obraAlvo.getCidadeEditora()%>"
            />
            <div class="divisao">
              <div>
                <label for="edicao">Edição</label>
                <input
                  type="number"
                  id="edicao"
                  name="edicao"
                  value="<%= obraAlvo.getEdicao()%>"
                />
              </div>
              <div>
                <label for="volume">Volume</label>
                <input
                  type="number"
                  id="volume"
                  name="volume"
                  value="<%= obraAlvo.getVolume()%>"
                />
              </div>
            </div>
            <div class="buttons">
                <button type="button" id="Confirmar" onclick="gravarAlteracao(document.GravaObra)">Cadastrar</button>
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
              <input type="hidden" value="ObraPesquisar" name="acao" />
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


