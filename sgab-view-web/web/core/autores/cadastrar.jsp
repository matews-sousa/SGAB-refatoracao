<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
        <section id="nome-form">
            <h1>Cadastro de autores</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <h1>Cadastrar Autor</h1>
                <form name="cadastrar" method="POST">
                    <input type="hidden" name="table" value="Autor">
                    <input type="hidden" name="acao" value="gravar">  <!-- Nome da tabela que serÃ¡ alterada -->
                    <label for="nomeAutor">Adicionar Nome</label>
                    <input type="text" id="cadastroNome" name="nomeAutor" placeholder="Adicione um Nome">
                    <button type="submit" onclick="gravarAlteracao(document.cadastrar)" >Cadastrar</button>
                 </div>
                </form>
            </div>
        </section>
<%@include file="/core/footer.jsp" %>