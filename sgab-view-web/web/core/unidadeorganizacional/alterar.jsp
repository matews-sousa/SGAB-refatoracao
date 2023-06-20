<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.UnidadeOrganizacional" %>

<%@include file="/core/header.jsp" %>

        <% UnidadeOrganizacional uOrg = (UnidadeOrganizacional) request.getAttribute("unidadeOrganizacional"); %>

        <center>
            <h3>Alterar Unidade Organizacional</h3>
            <form name="frmAltUnidadeOrganizacional" method="post">                
                <input type="hidden" name="table" value="UnidadeOrganizacional">
                <input type="hidden" name="acao" value="alterar">
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type="text" name="uOrgId" value="<%=uOrg.getId()%>" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type="text" name="nome" value="<%=uOrg.getNome()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço:
                        </td>
                        <td>
                            <input type="text" name="endereco" value="<%=uOrg.getEndereco()%>">
                        </td>
                    </tr>
                    <tr>
                       <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmAltUnidadeOrganizacional)">
                            <input type="button" value="Excluir" onclick="excluir(<%=uOrg.getId()%>, document.frmAltUnidadeOrganizacional)">
                            <a href="/sgab/core/usuario/inserir.jsp">Inserir Unidade Organizacional</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>
