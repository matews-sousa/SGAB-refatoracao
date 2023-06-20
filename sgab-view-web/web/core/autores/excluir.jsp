<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp"%>
        <section id="form">
            <div id="caixa-form">
                <form name="excluirAutor" method="POST">
                    <input type="hidden" name="table" value="Autor">
                    <input type="hidden" name="acao" value="excluir">  <!-- Nome da tabela que serÃ¡ alterada -->
                    <label for="idAutor">Id do autor excluido: </label>
                    <input type="text" id="idAutor" name="idAutor" placeholder="Id">
                    <button onclick="excluir(undefined,document.excluirAutor)" type="button">Excluir</button>
                </form>
            </div>
        </section>
        <%@include file="/core/footer.jsp" %>