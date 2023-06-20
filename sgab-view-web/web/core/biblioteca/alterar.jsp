<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Biblioteca" %>

<%@include file="/core/header.jsp" %>

        <% Biblioteca biblioteca = (Biblioteca) request.getAttribute("biblioteca"); %>

        <center>
            <h3>Alterar Biblioteca</h3>
            <form name="frmAltBiblioteca" method="post">                
                <input type="hidden" name="table" value="Biblioteca">
                <input type="hidden" name="acao" value="alterar">
                <table>
                    <tr>
                        <td>
                            Código:
                        </td>
                        <td>
                            <input type="text" name="bibliotecaId" value="<%=biblioteca.getId()%>" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Unidade Organizacional:
                        </td>
                        <td>
                            <input type="text" name="uOrgNome" value="<%=biblioteca.getUnidadeOrganizacional().getNome()%>" readonly>
                        </td>
                    </tr>                   
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type="text" name="bibliotecaNome" value="<%=biblioteca.getNome()%>">
                        </td>
                    </tr>
                    <tr>
                       <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmAltBiblioteca)">
                            <input type="button" value="Excluir" onclick="excluir(<%=biblioteca.getId()%>, document.frmAltBiblioteca)">
                            <a href="/sgab/core/biblioteca/inserir.jsp">Inserir Biblioteca</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>
