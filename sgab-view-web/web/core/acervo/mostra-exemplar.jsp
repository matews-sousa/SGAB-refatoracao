<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sgab.model.dto.Exemplar" %>
<%@page import="sgab.model.dto.util.ExemplarStatus" %>

<%@include file="/core/header.jsp" %>

<% 
   Exemplar exemplar = (Exemplar) request.getAttribute("exemplarAlvo");
%>
  <center><h3>Histórico do Exemplar <%= exemplar.getId()%></h3></center>
      <section id="form">
        <div id="caixa-form">
          <form>
            <label for="justificativa" style="display:block;">Histórico do Exemplar</label>
            <% if(exemplar.getHistorico()!=null){ %>
            <textarea disabled style="display:block; width: 95%; max-width: 95%; min-height: 4em; margin-bottom: 15px;"><%= exemplar.getHistorico() %></textarea>
            <%} else{ %>
            <textarea disabled style="display:block; width: 95%; max-width: 95%; min-height: 4em; margin-bottom: 15px;">O Exemplar ainda não tem um histórico de atividades.</textarea>
            <% } %>
            
            <% if(exemplar.getStatus() == ExemplarStatus.TRANSFERENCIA){ %>
                <a href="/sgab/main?acao=AceitaExemplar&userId=<%=exemplar.getId()%>"><button type="button" class="button-gestao">Aceitar exemplar</button></a>
            <% } %>
            
            <div class="buttons">
                <button type="button" id="alterar"><a href="/sgab/core/acervo/menu.jsp">Voltar</a></button>
            </div>
          </form>
        </div>
      </section>
   
    <%@include file="/core/footer.jsp" %>