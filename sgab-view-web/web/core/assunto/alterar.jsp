<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Assunto" %>

<%@include file="/core/header.jsp" %>

        <% Assunto assunto = (Assunto) request.getAttribute("assunto"); %>

        <center>
            <h3>Alterar Usuário</h3>
            <form name="frmAltAssunto" method="post">                
                <input type="hidden" name="table" value="Assunto">
                <input type="hidden" name="acao" value="alterar">
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type="text" name="assuntoId" value="<%=assunto.getId()%>" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type="text" name="nome" value="<%=assunto.getNome()%>">
                        </td>
                    </tr>
                    <tr>
                       <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmAltAssunto)">
                            <input type="button" value="Excluir" onclick="excluir(<%=assunto.getId()%>, document.frmAltAssunto)">
                            <a href="/sgab/core/assunto/inserir.jsp">Inserir Assunto</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>
