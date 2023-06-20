<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
<section id="form">
            <div id="caixa-form" style="display:flex;flex-direction:column;">
                <h2>Emprestimos</h2>
                <br>
                <form name="listarEmprestimo">
                    <input type="hidden" name="table" value="Emprestimo">
                    <input type="hidden" name="acao" value="EmprestimoListar">
                    <button style="width:100%;padding:0.5rem 0; cursor:pointer" onclick="pesquisar(document.listarEmprestimo)">Listar</button></a>
                </form>
                <br>
                <a href="emprestimos.jsp"  style="width:100%;text-align:center;cursor:pointer;">
                <button  style="width:100%;padding:0.5rem 0; cursor:pointer">Solicitar </button></a>
            </div>
</section>
<%@include file="/core/footer.jsp" %>
