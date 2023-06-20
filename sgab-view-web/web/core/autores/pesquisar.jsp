<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp"%>
        <section id="form">
            <div id="caixa-form">
                <h2>Pesquisa por ID</h2>
                <form name="pesquisarAutorPorId" method="POST">
                    <input type="hidden" name="table" value="Autor">  <!-- Nome da tabela que serÃ¡ alterada -->
                    <input type="hidden" name="acao" value="pesquisar">
                    <label for="idAutor">Digite o ID</label>
                    <input type="text" id="idAutor" name="idAutor" placeholder="Adicione um id">
                    <button onclick="pesquisar(document.pesquisarAutorPorId)" type="button">Pesquisar</button>
                </form>
                <h2>Pesquisa por Nome</h2>
                <form name="pesquisarAutorPorNome" method="POST">
                    <input type="hidden" name="table" value="Autor">  <!-- Nome da tabela que serÃ¡ alterada -->
                    <input type="hidden" name="acao" value="pesquisar">
                    <label for="nomeAutor">Digite o nome</label>
                    <input type="text" id="nomeAutor" name="nomeAutor" placeholder="Adicione um Nome">
                    <button onclick="pesquisar(document.pesquisarAutorPorNome)" type="submit">Pesquisar</input>
                </form>
            </div>
        </section>
        <%@include file="/core/footer.jsp" %>