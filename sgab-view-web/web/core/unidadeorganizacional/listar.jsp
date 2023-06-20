<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.UnidadeOrganizacional" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Lista de Unidades Organizacionais</h3>
            <a href="/sgab/core/unidadeorganizacional/inserir.jsp">Nova Unidade Organizacional</a>
            <form name="frmUnidadeOrganizacional" method="post">
                <input type="hidden" name="table" value="UnidadeOrganizacional">
                <input type="hidden" name="uOrgId" value="">
                
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
                        List<UnidadeOrganizacional> listUOrg = (List<UnidadeOrganizacional>) request.getAttribute("listUnidadeOrganizacional");
                        for (UnidadeOrganizacional uOrg: listUOrg) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=UnidadeOrganizacionalAlterar&uOrgId=<%=uOrg.getId()%>"><%=uOrg.getId()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=UnidadeOrganizacionalAlterar&uOrgId=<%=uOrg.getId()%>"><%=uOrg.getNome()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=UnidadeOrganizacionalAlterar&uOrgId=<%=uOrg.getId()%>"><%=uOrg.getEndereco()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=uOrg.getId()%>,document.frmUnidadeOrganizacional)">
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>