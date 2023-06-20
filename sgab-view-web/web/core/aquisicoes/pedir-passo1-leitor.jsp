<%-- 
    Document   : pedir-passo1-leitor
    Created on : 23 de jan. de 2022, 17:18:10
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/core/header.jsp" %>

<center><h3>Fazer Aquisição</h3></center>
<section id="form">
  <div id="caixa-form">
    <form name="frmPesquisaObra" method="post">
      <p>Escreva o nome da Obra que deseja fazer uma aquisição.</p>
      <div class="pesquisa-container">
        <input type="hidden" value="primeiro" name="etapa" />
        <input type="text" name="nomeObra" placeholder="Insira o nome da obra." />
        <input class="button" type="button" onclick="validarCamposObras(document.frmPesquisaObra)" value="Pesquisar" />
      </div>
      <label>Biblioteca</label>
          <span
            id="adiciona-biblioteca"
            onclick="abreModal('pesquisaBiblioteca')"
            style="
              float: right;
              font-weight: bolder;
              font-size: 1.5em;
              cursor: pointer;
              user-select: none;
            "
            >+</span>
      <input id="biblioteca-input" type="hidden" name="biblioteca" value="">
      <div id="biblioteca" style="padding-top: 10px;"></div>
      <center><h3>Dados não Obrigatórios</h3></center>
      <div style="width: 95%;">
            <label for="quantidade">Insira a quantidade que deseja pedir: </label>
            <input type="number" name="quantidade" style="max-width: 31%; display: inline;"> 
      </div>
      <label for="justificativa" style="display:block;">Justifique a Quantidade</label>
      <textarea name="justificativa" style="display:block; max-width: 95%; width: 95%; height: 4em; margin-bottom: 15px;"></textarea>
    </form>
  </div>
</section>

<div id="mask" onclick="fechaModalAll()"></div>

<div class="form-popup" id="pesquisaBiblioteca">
  <div class="close-btn" onclick="fechaModal('pesquisaBiblioteca')">&times;</div>
  <form class="form-container">
    <h2>Adicionar Biblioteca</h2>
    <div class="pesquisa-container">
       <input type="text" id="nomeBiblioteca" placeholder="Insira o nome da Biblioteca." />
       <input class="button" type="button" onclick="ajaxBiblioteca()" value="Pesquisar" />
    </div>
    <div id="resultados-pesquisa-biblioteca"></div>
  </form>
</div>

<script src="/sgab/js/cssControl.js"></script>
<script src="/sgab/js/ajaxControl.js"></script>

<script>
    
function validarCamposObras(frm){
    let nome = frm.nomeObra.value;
    if (nome == ""){
        alert("Preencha o campo de nome!");
        frm.nomeObra.focus();
    }
    else if (frm.biblioteca.value == ""){
        alert("Insira a Biblioteca!");
    } else if(frm.quantidade.value != "" && frm.justificativa.value == ""){
        alert("Insira a Justificativa!");
        frm.justificativa.focus();
    }
    else{
        frm.action = "/sgab/main?acao=AquisicaoPendente";
        frm.submit();
    }
}
</script>

<%@include file="/core/footer.jsp" %>
