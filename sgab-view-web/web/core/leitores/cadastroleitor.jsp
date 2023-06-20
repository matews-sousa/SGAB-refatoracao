<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
    <section>
      <div class="caixa-gestao">
        <h2>Operações de Leitores</h2>
        <button class="button-gestao" onclick="abreFormCadastro()">Cadastrar leitor</button> 
      </div>
      <br>
    </section>

    <!-- FormulÃ¡rios Pop-up -->

    <!-- Form de cadastro -->
    
    <section class="form-popup" id="formCadastro">
      <div class="close-btn" onclick="fechaFormCadastro()">&times;</div>
      <div id="caixa-form" style=>
          <form class="form-container" name="inserirLeitor" method="post">
              <input type="hidden" name="table" value="Leitor">
              <input type="hidden" name="acao" value="gravar">
              <div>
                  <label for="login">Informe o seu Login <span class="input-obrigatorio">*</span></label>
                  <input type="text" id="login" name="login" placeholder="Login" required>
                  <small>Digite um Login valido.</small>
              </div>
              <div class="caixa-form-footer">
                <button type="submit" onclick="gravarAlteracao(document.inserirLeitor)" >Cadastrar Leitor</button>
              </div>
          </form>
      </div>
  </section>
<script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
  <script src="/sgab/js/vendor/modernizr-3.11.2.min.js"></script>
  <script src="/sgab/js/helper.js"></script>
  <script src="/sgab/js/abreModal.js"></script>
  <script src="/sgab/js/validacao.js"></script>
  <script src="/sgab/js/cssControl.js"></script>
  <script src="/sgab/js/script.js"></script>
  <link rel="stylesheet" href="/sgab/css/normalize.css">
  <link rel="stylesheet" href="../../css/styles.css">
  <link rel="stylesheet" href="../../css/modal.css">
  <%@include file="/core/footer.jsp" %>