<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Fornecedor" %>

<%@include file="/core/header.jsp" %>

        <% Fornecedor fornecedor = (Fornecedor) request.getAttribute("fornecedor"); %>

        <center>
            <h3>Alterar Fornecedor</h3>
            <form name="frmAltFornecedor" method="post">                
                <input type="hidden" name="table" value="Fornecedor">
                <input type="hidden" name="acao" value="alterar">                
                <table>
                    <tr>
                        <td>
                            Cnpj:
                        </td>
                        <td>
                            <input type="text" name="cnpj" value="<%=fornecedor.getCnpj()%>" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type="text" name="nome" value="<%=fornecedor.getNomeFornecedor()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type="text" name="email" value="<%=fornecedor.getEmail()%>">
                        </td>
                    </tr>                    
                    <tr>
                        <td>
                            Endereço:
                        </td>
                        <td>
                            <input type="text" name="endereco" value="<%=fornecedor.getEndereco()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            CEP:
                        </td>
                        <td>
                            <input type="text" name="cep" value="<%=fornecedor.getCep()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Telefone:
                        </td>
                        <td>
                            <input type="text" name="telefone" value="<%=fornecedor.getTelefone()%>">
                        </td>
                    </tr>
                    <tr>
                       <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmAltFornecedor)">
                            <a href="/sgab/main?acao=FornecedorListar">Listar Fornecedores</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>
