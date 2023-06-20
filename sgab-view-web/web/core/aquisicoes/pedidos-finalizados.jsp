<%-- 
    Document   : pedidos-pendentes
    Created on : 23 de jan. de 2022, 19:49:26
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sgab.model.dto.Aquisicao" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
<center>
                <h3>Pedidos Ativos</h3>
                <a onclick="listarPedidosPendentes(document.frmAquisicao)" style="
                    cursor: pointer; text-decoration: underline; color: -webkit-link;
                ">Voltar a lista de pedidos pendentes</a>	&nbsp;	&nbsp;
                <a onclick="listarPedidosAtivos(document.frmAquisicao)" style="
                    cursor: pointer; text-decoration: underline; color: -webkit-link;
                ">Voltar a lista de pedidos ativos</a>
                <form name="frmAquisicao" method="post">
                      <input type="hidden" name="aquisicaoId" value="">
                      <table id="usuario" style="width: 50%;">
                          <tr>
                            <th>ID</th>
                            <th>FORNECEDOR</th>
                            
                            <th>OBRA</th>
                            <th>QUANT</th>
                          </tr>
                          <% 
                            List<Aquisicao> aquisicoes = (List<Aquisicao>) request.getAttribute("listAquisicoesFinalizadas");
                            for(Aquisicao aquisicao : aquisicoes){ %>
                          <tr>
                            <td><%= aquisicao.getId() %></td>
                            <td><%= aquisicao.getFornecedor().getNomeFornecedor() %></td>
                            <td><%= aquisicao.getObra().getTitulo() %></td>
                            <td><%= aquisicao.getQuantidade() %></td>
                          </tr>
                          <% } %>
              </table>
              </form>
              
          </center>
<script>
    function listarPedidosPendentes(frm){
        frm.action = "/sgab/main?acao=ListarAquisicoes";
        frm.submit();
    }

    function listarPedidosAtivos(frm){
        frm.action = "/sgab/main?acao=ListarAquisicoesAtivos";
        frm.submit();
    }
</script>
<%@include file="/core/footer.jsp" %>