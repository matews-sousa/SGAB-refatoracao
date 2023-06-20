<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Inserir Biblioteca</h3>
             <form name="frmInserirBiblioteca" method="post">
                <input type="hidden" name="table" value="Biblioteca">
                <input type="hidden" name="acao" value="gravar">
                <table>
                    <tr>
                        <td>
                            Unidade Organizacional:
                        </td>
                        <td>
                            <input type="text" name="uOrgNome" value="">
                        </td>
                    </tr>                   
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type="text" name="bibliotecaNome" value="">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmInserirBiblioteca)">&nbsp;
                            <a href="/sgab/main?acao=BibliotecaListar">Listar Bibliotecas</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>

