<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Pessoa" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
       
        <center>
            <h3>Lista de Pessoas</h3>
            <a href="/sgab/core/pessoa/inserir.jsp">Nova Pessoa</a>
            <form name="listarPessoa" method="post">
                <input type="hidden" name="table" value="Pessoa">
                <input type="hidden" name="pessoaId" value="">

                <table id="pessoa">
                    <tr>
                        <th>
                            Código
                        </th>
                        <th>
                            Login
                        </th>
                        <th>
                            CPF
                        </th>
                        <th>
                            Nome
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            Tipo
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Pessoa> listPessoas = (List<Pessoa>) request.getAttribute("listPessoas");
                        for (Pessoa pessoa: listPessoas) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getId()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getLogin()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getCpf()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getNome()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getEmail()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getTipo()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=pessoa.getId()%>,document.listarPessoa)">
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center>

        <%@include file="/core/footer.jsp" %>    