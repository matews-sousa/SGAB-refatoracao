<%-- 
    Document   : listar
    Created on : 10 de jan. de 2022, 19:17:30
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sgab.model.dto.Obra" %>
<%@page import="sgab.model.dto.Autor" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>

      <center>
          <h3>Lista de Obras</h3>
          <div class="acoes">
              <a href="/sgab/core/obra/inserir.jsp">Nova Obra</a>
              <form class="pesquisa-container" name="frmPesquisa" method="post">
                  <input type="hidden" value="ObraPesquisar" name="acao">
                  <select name="tipo">
                      <option value="null" selected>[Pesquisar por]</option>
                      <option value="titulo">Título</option>
                      <option value="autor">Autor</option>
                  </select>
                  <input type="text" name="nome" placeholder="Escolha o tipo.">
                  <input type="button" class="button" onclick="validarCamposPesquisaObra(document.frmPesquisa)" value="Pesquisar">
              </form>
          </div>
          <form name="frmObra" method="post">
                <input type="hidden" name="table" value="Obra">
                <input type="hidden" name="obraId" value="">
                <table id="usuario" style="width: 100%;">
                    <tr>
                      <th class="hpesquisa"></th>
                      <th>ID</th>
                      <th>TÍTULO</th>
                      <th>AUTORES</th>
                      <th>EDITORA</th>
                      <th>EDIÇÃO</th>
                      <th>VOLUME</th>
                      <th>ANO</th>
                      <th></th>
                    </tr>
                    <% 
                    List<Obra> lista = (List<Obra>) request.getAttribute("listObras");
                    for(Obra obra : lista){
                    %>
                    <tr>
                      <td class="pesquisa"><a href="/sgab/main?acao=ObraAlterar&obraId=<%=obra.getId()%>">&#128270</a></td>
                      <td><%= obra.getId()%></td>
                      <td><%= obra.getTitulo()%></td>
                      <td>
                      <% for(Autor autor: obra.getAutor()){ %>
                        <%= autor.getNome()%>;
                      <% } %>
                      </td>
                      <td><%= obra.getEditora()%></td>
                      <td><%= obra.getEdicao()%></td>
                      <td><%= obra.getVolume()%></td>
                      <td><%= obra.getAnoPublicacao()%></td>
                      <td><input type="button" value="Excluir" onclick="excluir(<%=obra.getId()%>,document.frmObra)"></td>
                    </tr>
                    <% } %>
        </table>
        </form>
        
    </center>
        
    <style>
        .hpesquisa{
            flex: 0.5;
        }
        .pesquisa{
            cursor: pointer;
            flex: 0.5;
        }
    </style>        
    <%@include file="/core/footer.jsp" %>


