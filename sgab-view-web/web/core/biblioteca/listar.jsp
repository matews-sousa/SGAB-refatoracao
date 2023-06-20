<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Biblioteca" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Lista de Biblioteca</h3>
            <a href="/sgab/core/biblioteca/inserir.jsp">Nova Biblioteca</a>
            <form name="frmBiblioteca" method="post">
                <input type="hidden" name="table" value="Biblioteca">
                <input type="hidden" name="bibliotecaId" value="">
                
                <table id="commontable">
                    <tr>
                        <th>
                            Código
                        </th>                        
                        <th>
                            Unidade
                        </th>
                        <th>
                            Nome
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Biblioteca> listBiblioteca = (List<Biblioteca>) request.getAttribute("listBiblioteca");
                        for (Biblioteca biblioteca: listBiblioteca) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=BibliotecaAlterar&bibliotecaId=<%=biblioteca.getId()%>"><%=biblioteca.getId()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=BibliotecaAlterar&bibliotecaId=<%=biblioteca.getId()%>"><%=biblioteca.getUnidadeOrganizacional().getNome()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=BibliotecaAlterar&bibliotecaId=<%=biblioteca.getId()%>"><%=biblioteca.getNome()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=biblioteca.getId()%>, document.frmBiblioteca)">
                            </td> 
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>