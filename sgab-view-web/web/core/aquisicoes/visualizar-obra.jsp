<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sgab.model.dto.Obra" %>
<%@page import="sgab.model.dto.Autor" %>
<%@page import="sgab.model.dto.Assunto" %>

<%@include file="/core/header.jsp" %>

<% 
   Long quantidade = (Long) request.getAttribute("quantidade");
   String justificativa = (String) request.getAttribute("justificativa");
   Obra obraAlvo = (Obra) request.getAttribute("obra");
%>
  <center><h3>Consulta de Aquisição</h3></center>
      <section id="form">
        <div id="caixa-form">
          <form id="AlteraObra" name="AlteraObra" method="post">
            <input type="hidden" name="table" value="Obra">
            <input type="hidden" name="acao" value="alterar">
            <input type="hidden" name="obraId" value="<%= request.getParameter("obraId") %>">
            
            <div style="width: 95%;">
                <label for="quantidade">Quantidade</label>
                <input disabled type="number" name="quantidade" style="max-width: 31%; display: inline;" value="<%= quantidade %>"> 
            </div>
            <label for="justificativa" style="display:block;">Justificativa da Quantidade</label>
            <textarea disabled name="justificativa" style="display:block; width: 95%; max-width: 95%; height: 4em; margin-bottom: 15px;"><%= justificativa %></textarea>
            <center><h3>Obra</h3></center>
            <label for="categoria">Categoria</label>
            <select disabled name="categoria" id="categoria">
              <option value="livro">Livro</option>
              <option value="mapa">Mapa</option>
              <option value="docComputacional">Documento computacional</option>
            </select>
            <label for="titulo">Título</label>
            <input
              type="text"
              disabled
              id="titulo"
              name="titulo"
              value="<%= obraAlvo.getTitulo()%>"
            />
           
            <label>Autores</label>
            <input id="autores-input" type="hidden" name="autores" value="<% for(Autor autorAtual:obraAlvo.getAutor()){ %><%= autorAtual.getNome()%>::<% } %>">
            <div id="autores" style="padding-top: 10px;">
              <% for(Autor autorAtual:obraAlvo.getAutor()){ %>
                <div class="acoes" id="<%= autorAtual.getNome()%>"><span><%= autorAtual.getNome()%></span><input type="button" value="Excluir" onclick="excluirAutor('<%= autorAtual.getNome()%>')"></div>
              <% } %>
            </div>
            
            <label>Assuntos</label>
            <input id="assuntos-input" type="hidden" name="assuntos" value="<% for(Assunto assuntoAtual:obraAlvo.getAssunto()){ %><%= assuntoAtual.getNome()%>::<% } %>">
            <div id="assuntos" style="padding-top: 10px;">
                <% for(Assunto assuntoAtual:obraAlvo.getAssunto()){ %>
                <div class="acoes" id="<%= assuntoAtual.getNome()%>"><span><%= assuntoAtual.getNome()%></span><input type="button" value="Excluir" onclick="excluirAssunto('<%= assuntoAtual.getNome()%>')"></div>
              <% } %>
            </div>

            <label for="nota">Nota</label>
            <input
              type="text"
              disabled
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
                  disabled
                  id="ano"
                  name="ano"
                  value=<%= obraAlvo.getAnoPublicacao()%>
                />
              </div>
              <div>
                <label for="editora">Editora</label>
                <input
                  type="text"
                  disabled
                  id="editora"
                  name="editora"
                  value="<%= obraAlvo.getEditora()%>"
                />
              </div>
            </div>
            <label for="cidEditora">Cidade da Editora</label>
            <input
              type="text"
              disabled
              id="cidEditora"
              name="cidEditora"
              value="<%= obraAlvo.getCidadeEditora()%>"
            />
            <div class="divisao">
              <div>
                <label for="edicao">Edição</label>
                <input
                  type="number"
                  disabled
                  id="edicao"
                  name="edicao"
                  value="<%= obraAlvo.getEdicao()%>"
                />
              </div>
              <div>
                <label for="volume">Volume</label>
                <input
                  type="number"
                  disabled
                  id="volume"
                  name="volume"
                  value="<%= obraAlvo.getVolume()%>"
                />
              </div>
              
            </div>
            <div class="buttons">
                <button type="button" id="alterar"><a href="/sgab/main?acao=ListarAquisicoes">Voltar</a></button>
            </div>
          </form>
        </div>
      </section>
   
    <%@include file="/core/footer.jsp" %>