<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/core/header.jsp" %>

  </div>
      <div class="caixa-gestao">
        <h2>Operação de Devolução</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroDevolucao')">Cadastrar</button>   
      </div>
      <br>
    </section>

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroDevolucao">
      <div class="close-btn" onclick="fechaModal('formCadastroDevolucao')">&times;</div>
      <form class="form-container" method="POST" name="GravarGestor">
        <h2> Cadastrar</h2>
        <div>
          
          <h3>Cadastrar</h3>

          <input type="hidden" name="table" value="Devolucao">
          <input type="hidden" name="acao" value="gravar">
            
          <div>
                <label for="id">Informe o Id do Exemplar<span class="input-obrigatorio">*</span></label>
                <input type="text" id="id" name="id" placeholder="Id" required>
                <small>Digite um Id válido.</small>
           </div>
          
          <button type="button" class="button-form" onclick="gravarAlteracao(document.GravarGestor)">Enviar</button>
        </div>
      </form>
    </div>

    <div id="mask" onclick="fechaModalAll()"></div>
  </main>

  <!-- JS -->
  <script src="../../js/abreModal.js"></script>
  <script src="../../js/helper.js"></script>
  <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/modal.css">
  <link rel="stylesheet" href="../../css/styles.css">
  
</body>

<%@include file="/core/footer.jsp" %>


</html>
