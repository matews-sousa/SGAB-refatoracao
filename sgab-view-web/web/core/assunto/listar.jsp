<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Assunto" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Lista de Assuntos</h3>
            <a href="/sgab/core/assunto/inserir.jsp">Novo Assunto</a>
            <form name="frmAssunto" method="post">
                <input type="hidden" name="table" value="Assunto">
                <input type="hidden" name="assuntoId" value="">
                
                <table id="commontable">
                    <tr>
                        <th>
                            Código
                        </th>
                        <th>
                            Nome
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Assunto> listAssunto = (List<Assunto>) request.getAttribute("listAssunto");
                        for (Assunto assunto: listAssunto) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=AssuntoAlterar&assuntoId=<%=assunto.getId()%>"><%=assunto.getId()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=AssuntoAlterar&assuntoId=<%=assunto.getId()%>"><%=assunto.getNome()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=assunto.getId()%>,document.frmAssunto)">
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>