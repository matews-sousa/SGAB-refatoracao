<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Fornecedor" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Lista de Fornecedores </h3>
            <a href="/sgab/core/fornecedor/inserir.jsp">Novo Fornecedor</a>
            <form name="frmFornecedor" method="post">
                <input type="hidden" name="table" value="Fornecedor">
                <!-- used in controller.excluir -->
                <input type="hidden" name="fornecedorCNPJ" value="">
                
                <table id="commontable">
                    <tr>
                        <th>
                            Código
                        </th>
                        <th>
                            Nome
                        </th>
                        <th>
                            Endereço
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Fornecedor> listFornecedor = (List<Fornecedor>) request.getAttribute("listFornecedor");
                        for (Fornecedor fornecedor: listFornecedor) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=FornecedorAlterar&cnpj=<%=fornecedor.getCnpj()%>"><%=fornecedor.getCnpj()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=FornecedorAlterar&cnpj=<%=fornecedor.getCnpj()%>"><%=fornecedor.getNomeFornecedor()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=FornecedorAlterar&cnpj=<%=fornecedor.getCnpj()%>"><%=fornecedor.getEndereco()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=fornecedor.getCnpj()%>, document.frmFornecedor)">
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 

        <%@include file="/core/footer.jsp" %>