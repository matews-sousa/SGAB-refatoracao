<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Pessoa" %>
<%@page import="sgab.model.dto.Emprestimo" %>
<%@page import="sgab.model.dto.Exemplar" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
       
        <center>
            <h3>Lista de Empréstimos</h3>
            <a href="/sgab/core/emprestimos/emprestimos.jsp">Novo Empréstimo</a>
            <form name="listarEmprestimo" method="post">
                <input type="hidden" name="table" value="Emprestimo">
                <input type="hidden" name="emprestimoId" value="">

                <table id="emprestimo">
                    <tr>
                        <th>
                            Usuário
                        </th>
                        <th>
                            Id do Exemplar
                        </th>
                        <th>
                            Data
                        </th>
                        <th>
                            Status
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Emprestimo> listEmprestimos = (List<Emprestimo>) request.getAttribute("listEmprestimos");
                        for (Emprestimo emprestimo: listEmprestimos) {
                    %>
                        <tr>
                            <td>
                                <%=emprestimo.getPessoa().getNome()%></a>
                            </td>
                            <td>
                                <%=Long.toString(emprestimo.getExemplar().getId())%></a>
                            </td>
                            <td>
                                <%=emprestimo.getDate()%></a>
                            </td>
                            <td>
                                <%=emprestimo.getExemplar().getStatus()%></a>
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center>
        <%@include file="/core/footer.jsp" %>    
