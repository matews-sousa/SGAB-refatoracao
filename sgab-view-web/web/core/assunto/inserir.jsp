<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Inserir Assunto</h3>
             <form name="frmInserirAssunto" method="post">
                <input type="hidden" name="table" value="Assunto">
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
                        <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmInserirAssunto)">&nbsp;
                            <a href="/sgab/main?acao=AssuntoListar">Listar Assuntos</a><br>
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>

