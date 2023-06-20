<%-- 
    Document   : pedir-passo3
    Created on : 23 de jan. de 2022, 15:52:27
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/core/header.jsp" %>
<%@page import="sgab.model.dto.Obra" %>
<% 
    Obra obraAlvo = (Obra) request.getSession().getAttribute("obraAlvo");
    String justificativa = request.getParameter("justificativa");
    Long quantidade = null;
    if(request.getParameter("quantidadeDesejada") != null)
        quantidade = Long.parseLong(request.getParameter("quantidadeDesejada"));
%>

<section id="form">
  <div id="caixa-form">
    <form name="frmFinalizaAquisicao" method="post">
        <input type="hidden" value="Aquisicao" name="table" />
        <input type="hidden" value="terceiro" name="etapa" />
        <div id="obra">
            <label for="obra">Obra: </label>
            <input type="text" name="obra" style="max-width: 86%; display: inline;" disabled value="<%= obraAlvo.getTitulo() %>">
        </div>
        <div>
            <label for="nome">Escreva o nome do Fornecedor:</label>
            <input type="text" name="fornecedor" placeholder="Insira o nome do Fornecedor." />
        </div>
        <div style="width: 95%;">
            <label for="quantidade">Insira a quantidade que deseja pedir: </label>
            <input type="number" name="quantidade" style="max-width: 31%; display: inline;" value="<%= quantidade %>"> 
        </div>
        <%if(justificativa != null) {%>
            <label for="justificativa" style="display:block;">Justificativa da Quantidade</label>
            <textarea disabled name="justificativa" style="display:block; width: 95%; max-width: 95%; height: 4em; margin-bottom: 15px;"><%= justificativa %></textarea>
        <%}%>
        <input class="button" type="button" onclick="gravarAlteracao(document.frmFinalizaAquisicao)" value="Pedir" />
    </form>
  </div>
</section>
<%@include file="/core/footer.jsp" %>