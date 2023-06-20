<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>

<%
    Long exemplarId = (Long) request.getSession().getAttribute("exemplarId");
    String leitorLogin = (String) request.getSession().getAttribute("leitorLogin");
%>

        <section id="nome-form">
            <h1>Empréstimo de obras</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <h1>Empréstimo de obras</h1>
            <form name="emprestimo" method="POST">
                    <input type="hidden" name="table" value="Emprestimo">
                    <input type="hidden" name="acao" value="solicita">  <!-- Nome da tabela que serÃ¡ alterada -->
            <input id="obras-input" type="hidden" name="obras" value="">
            <div id="obras" style="padding-top: 10px;"></div>
                    <label for="idEmprestimo">Id</label>
                    <%if(exemplarId != null) {%>
                    <input type="text" name="idEmprestimo" placeholder="Insira o código da obra." value="<%=exemplarId%>"/>
                    <%} else {%>
                    <input type="text" name="idEmprestimo" placeholder="Insira o código da obra."/>
                    <%}%>
                    <label for="loginLeitor">Login do Leitor</label>
                    <%if(leitorLogin != null && leitorLogin != "") {%>
                    <input type="text" id="cadastroNome" name="loginLeitor" placeholder="Login do Leitor" value="<%=leitorLogin%>">
                    <%} else {%>
                    <input type="text" id="cadastroNome" name="loginLeitor" placeholder="Login do Leitor">
                    <%}%>
                    <input type="button" class="button" onclick="gravarAlteracao(document.emprestimo)" value="Solicitar emprestimo">
                 </div>
                </form>
            </div>
                        
        </section>
         </div>
        
        <script src="/sgab/js/abreModal.js"></script>
        <script src="/sgab/js/ajaxControl.js"></script>
        
<%
    request.getSession().setAttribute("eprestimoId", null);
    request.getSession().setAttribute("leitorLogin", null);
%>
<%@include file="/core/footer.jsp" %>