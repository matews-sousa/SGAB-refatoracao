
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
        <input class="button" type="button" onclick="validarCamposPesquisaObra(document.frmPesquisaObra)" value="Pesquisar" />
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
    
function validarCamposPesquisaObra(frm){
    let nome = frm.nomeObra.value;
    if (nome == ""){
        alert("Preencha o campo de nome!");
        frm.nomeObra.focus();
    } else if (frm.biblioteca.value == ""){
        alert("Insira a Biblioteca!");
    }
    else{
        frm.action = "/sgab/main?acao=AquisicaoCriar";
        frm.submit();
    }
}
</script>

<%@include file="/core/footer.jsp" %>
