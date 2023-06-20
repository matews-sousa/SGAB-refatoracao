<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Exemplar" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
    <center>
            <h3>Exemplares de Consulta</h3>
            <form name="frmObra" method="post">
                <input type="hidden" name="table" value="Obra">
                <input type="hidden" name="obraId" value="">
                <table id="usuario">
                    <tr>
                      <th class="hpesquisa"></th>
                      <th>ID</th>
                      <th>NOME</th>
                    </tr>
                    <% 
                    List<Exemplar> lista = (List<Exemplar>) request.getAttribute("exemplaresListar");
                    for(Exemplar exemplar : lista){
                    %>
                    <tr>
                      <td class="pesquisa"><a href="/sgab/main?acao=MostraExemplar&exemplarId=<%= exemplar.getId()%>">&#128270</a></td>
                      <td><%= exemplar.getId()%></td>
                      <td><%= exemplar.getObra().getTitulo()%></td>
                    </tr>
                    <% } %>
        </table>
        </form>
            </center>


<%@include file="/core/footer.jsp" %>