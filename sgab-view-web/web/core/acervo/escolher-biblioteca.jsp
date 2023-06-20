
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="/core/header.jsp" %>

<center><h3>Acessar Acervo</h3></center>
<section id="form">
  <div id="caixa-form">
    <form name="frmPesquisaBiblioteca" method="post">
      <p>Escreva o nome da Biblioteca que deseja acessar.</p>
      <div class="pesquisa-container">
        <input type="text" name="nomeBiblioteca" placeholder="Insira o nome da Biblioteca." />
        <input class="button" type="button" onclick="validarCamposPesquisaBiblioteca(document.frmPesquisaBiblioteca)" value="Pesquisar" />
      </div>
    </form>
  </div>
</section>
<script>
    
function validarCamposPesquisaBiblioteca(frm){
    let nome = frm.nomeBiblioteca.value;
    if (nome == ""){
        alert("Preencha o campo de nome!");
        frm.nomeBiblioteca.focus();
    }
    else{
        frm.action = "/sgab/main?acao=ListarAcervo";
        frm.submit();
    }
}
</script>

<%@include file="/core/footer.jsp" %>
