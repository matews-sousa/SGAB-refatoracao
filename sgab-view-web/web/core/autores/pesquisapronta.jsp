<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
        <section id="form">
            <div id="caixa-form">
                <c:set var="nome" value="<%= request.getAttribute("nome")%>"/>
                <c:set var="id" value="<%= request.getAttribute("id")%>"/>
                <p>Nome do autor: ${nome}</p>
                <p>Id do autor: ${id}</p>
            </div>
        </section>
<%@include file="/core/footer.jsp" %>