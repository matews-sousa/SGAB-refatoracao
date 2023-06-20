<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
<section id="form">
            <div id="caixa-form" style="display:flex;flex-direction:column;">
                <h2>Gestão Autores</h2>
                <br>
                <a href="cadastrar.jsp" style="width:100%;text-align:center;cursor:pointer;">
                <button style="width:100%;padding:0.5rem 0; cursor:pointer">Cadastrar um autor</button></a>
                <br>
                <a href="excluir.jsp"  style="width:100%;text-align:center;cursor:pointer;">
                <button  style="width:100%;padding:0.5rem 0; cursor:pointer">Excluir um autor</button></a>
                <br>
                <a href="pesquisar.jsp"  style="width:100%;text-align:center;cursor:pointer;">
                <button  style="width:100%;padding:0.5rem 0; cursor:pointer">Pesquisar um autor</button></a>
                <br>
                <a href="alterar.jsp"  style="width:100%;text-align:center;cursor:pointer;">
                <button  style="width:100%;padding:0.5rem 0; cursor:pointer">Alterar um autor</button></a>
            </div>
        </section
<%@include file="/core/footer.jsp" %>