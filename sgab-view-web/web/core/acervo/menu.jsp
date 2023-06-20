<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Biblioteca" %>
<%@page import="java.util.List" %>

<% Biblioteca biblioteca = (Biblioteca) request.getSession().getAttribute("bibliotecaOrigem");
   if(biblioteca == null){
        RequestDispatcher rd = request.getRequestDispatcher("");
        rd.forward(request, response);
    }%>


<%@include file="/core/header.jsp" %>
        <section>
            <div class="caixa-gestao">
                
                <center>
                    <h2>Acessar acervo de <%= biblioteca.getNome() %></h2>
                    <a href="/sgab/main?acao=ListarAcervoBiblioteca&bibliotecaOrigem=<%=biblioteca.getNome()%>"><button class="button-gestao">Acessar acervo</button></a></center>
            </div>
          <div class="caixa-gestao">
            <h2>Operações de Restauração</h2>
            <button class="button-gestao" onclick="abreModal('formEnvioRestauracao')">Enviar para restauração</button>
            <button class="button-gestao" onclick="abreModal('formRetornoRestauracao')">Registrar retorno</button>
            <button class="button-gestao" onclick="abreModal('formDesativacaoInvalidez')">Desativar livro</button>
            <a href="/sgab/main?acao=ListarRestaurar&bibliotecaOrigem=<%=biblioteca.getNome()%>"><button class="button-gestao">Listar livros em restauração</button></a>
          </div>
          <br>
          <div class="caixa-gestao">
            <h2>Operações de Consulta</h2>
            <button class="button-gestao" onclick="abreModal('formExemplarConsulta')">Registrar livro de consulta</button>
            <a href="/sgab/main?acao=ListarConsulta&bibliotecaOrigem=<%=biblioteca.getNome()%>"><button class="button-gestao" >Listar livros em consulta</button></a>
          </div>
          <br>
          <div class="caixa-gestao">
            <h2>Operações de Transferência entre Bibliotecas</h2>
            <button class="button-gestao" onclick="abreModal('formTransferExemplar')">Transferir livro</button>
            <button class="button-gestao" onclick="abreModal('formRecebExemplar')">Receber livro</button>
            <a href="/sgab/main?acao=ListarTransferencia&bibliotecaOrigem=<%=biblioteca.getNome()%>"><button class="button-gestao" >Listar transferências</button></a>

          </div>

        </section>
        
        <div id="mask" onclick="fechaModalAll()"></div>

        <!-- Formulários Pop-up -->

        <!-- Form de envio-->
        <div class="form-popup" id="formEnvioRestauracao">
          <div class="close-btn" onclick="fechaModal('formEnvioRestauracao')" >&times;</div>
          <form class="form-container" method="POST" action="/sgab/main?acao=RestaurarExemplar">
            <h2> Cadastro de Envio para Restauração</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idEnvio" required></label>
              <label>Data de envio: <input type="date" name="dataEnvio" required></label>
              <label>Justificativa: <input type="text" placeholder="Razão para envio à restauração" name="razaoEnvio" required></label>
              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de retorno-->
        <div class="form-popup" id="formRetornoRestauracao">
          <div class="close-btn" onclick="fechaModal('formRetornoRestauracao')">&times;</div>
          <form class="form-container" action="/sgab/main?acao=RetornoRestauracao" method="POST">
            <h2>Registro de Retorno da Restauração</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>
              <label>Data de retorno: <input type="date" name="dataRetorno" required></label>
              <label>Status de restauração:
                <label for="completa"><input type="radio" id="completa" name="fav_language" value="Completa">Completa</label>
                <label for="incompleta"><input type="radio" id="incompleta" name="fav_language" value="Incompleta">Incompleta</label>
              </label>
              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de desativação -->
        <div class="form-popup" id="formDesativacaoInvalidez">
          <div class="close-btn" onclick="fechaModal('formDesativacaoInvalidez')">&times;</div>
          <form class="form-container" action="/sgab/main?acao=DesativaExemplar" method="POST">
            <h2>Desativar livro por invalidez</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>
              <label>Data de desativação: <input type="date" name="dataDesativar" required></label>
              <label>Justificativa: <input type="text" placeholder="Razão para desativar" name="razaoDesativar" required></label>
              <label>Confirmação: <input type="password" placeholder="Senha do Bibliotecário" required name="password"></label>

              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de consulta -->
        <div class="form-popup" id="formExemplarConsulta">
          <div class="close-btn" onclick="fechaModal('formExemplarConsulta')">&times;</div>
          <form class="form-container" action="/sgab/main?acao=TransformaExemplarConsulta" method="POST">
            <h2>Registrar como Livro de Consulta</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>
              <label>Justificativa: <input type="text" placeholder="Razão para registrar como de consulta" name="razaoConsulta" required></label>
              <label>Confirmação: <input type="password" placeholder="Senha do Gestor" required name="password"></label>

              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de Transferencia -->
        <div class="form-popup" id="formTransferExemplar">
          <div class="close-btn" onclick="fechaModal('formTransferExemplar')">&times;</div>
          <form class="form-container" action="/sgab/main?acao=TransferirExemplar" method="POST">
            <h2>Transferir Exemplar para outra Bilioteca</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>

              <label>Nome da Biblioteca: <input type="text" placeholder="Identificação da Biblioteca Receptora" name="nomeBiblioteca"></label>

              <label> Confirmação: <input type="password" placeholder="Senha do Gestor" required name="password"></label>

              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

      <!-- JS -->
      <script src="/sgab/js/cssControl.js"></script>
    </body>

<%@include file="/core/footer.jsp" %>
