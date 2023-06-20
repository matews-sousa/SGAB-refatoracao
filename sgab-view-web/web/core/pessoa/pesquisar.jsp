<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="/core/header.jsp" %>

    <center>
        <h3>Pesquisa de Pessoa</h3>
    </center>
    <section id="form">
        <div id="caixa-form">
            <form name="pesquisarPessoa" method="post">
                <input type="hidden" name="table" value="Pessoa">
                <input type="hidden" name="acao" value="pesquisarPorLogin">
                <div>
                    <label for="login">Informe o Login <span class="input-obrigatorio">*</span></label>
                    <input type="number" id="login" name="login" placeholder="Login" required>
                    <small>Digite um Login válido. </small>
                </div>
                <div class="caixa-form-footer">
                   <input type="button" class="button" name="ordem" value="Pesquisar" onclick="pesquisar(document.pesquisarPessoa)">
                </div>
            </form>
        </div>
    </section>
    <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
    <%@include file="/core/footer.jsp" %>
