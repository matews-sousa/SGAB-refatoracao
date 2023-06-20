<%-- 
    Document   : pedir-passo2-none
    Created on : 23 de jan. de 2022, 15:18:44
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/core/header.jsp" %>

<center><h3>Pedir Aquisição</h3><h4>Resultado Pesquisa</h4></center>
<section id="form">
  <div id="caixa-form">
    <form name="frmInsereObra" method="post">
      <p>Nenhuma obra encontrada.</p>
      <div class="buttons">
        <button type="button">
            <a href="/sgab/menu.jsp" style="text-decoration: none; color: inherit;">Voltar</a>
        </button>
        <button type="button" onclick="">
            <a href="/sgab/core/obra/inserir.jsp" style="text-decoration: none; color: inherit;">Cadastrar Obra</a>
        </button>
      </div>
    </form>
  </div>
</section>

<%@include file="/core/footer.jsp" %>