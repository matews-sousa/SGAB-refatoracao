<%-- 
    Document   : pedir-passo2
    Created on : 23 de jan. de 2022, 15:32:40
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sgab.model.dto.Obra" %>
<%@page import="sgab.model.dto.Autor" %>
<%@page import="sgab.model.dto.Pessoa" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
<center>
                <h3>Criar Aquisição</h3>
                <h4>Resultado Pesquisa</h4>
                <form name="frmPedidos" method="post">
                      <input type="hidden" value="segundo" name="etapa" />
                      <input type="hidden" name="obraId" value="">
                      <table id="usuario" style="width: 100%;">
                          <tr>
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
                            List<Obra> lista = (List<Obra>) request.getAttribute("obras");
                            for(Obra obra : lista){
                          %>
                          <tr>
                            <tr>
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
                                <td><input style="
                                    display: block; 
                                    margin-left: auto; 
                                    margin-right: auto; 
                                    padding: 4px 4px; 
                                    height: 26px; 
                                    border-color: #aaaaaa; 
                                    background-color: #aaaaaa;
                                    color: black;
                                    width: 100%;
                                    border-radius: 0;
                                " type="button" value="Pedir" onclick="fazerPedido(document.frmPedidos, <%= obra.getId() %>)" class="button" ></td>
                          </tr>
                          <% } %>
              </table>
              </form>
              
          </center>
<script>
    function fazerPedido(frm, id){
        frm.obraId.value = id;
        frm.action = "/sgab/main?acao=AquisicaoCriar";
        frm.submit();
    }
</script>
<%@include file="/core/footer.jsp" %>
