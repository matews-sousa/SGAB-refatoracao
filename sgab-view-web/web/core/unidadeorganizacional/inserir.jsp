<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Inserir Unidade Organizacional</h3>
             <form name="frmInserirUnidadeOrganizacional" method="post">
                <input type="hidden" name="table" value="UnidadeOrganizacional">
                <input type="hidden" name="acao" value="gravar">
                <table>           
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type="text" name="nome" value="">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço:
                        </td>
                        <td>
                            <input type="text" name="endereco" value="">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmInserirUnidadeOrganizacional)">&nbsp;
                            <a href="/sgab/main?acao=UnidadeOrganizacionalListar">Listar Unidades Organizacionais</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>

