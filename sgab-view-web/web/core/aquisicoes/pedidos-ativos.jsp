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
                <a onclick="listarPedidosFinalizados(document.frmAquisicao)" style="
                    cursor: pointer; text-decoration: underline; color: -webkit-link;
                ">Ir a lista de pedidos finalizados</a>
                <form name="frmAquisicao" method="post">
                      <input type="hidden" name="aquisicaoId" value="">
                      <table id="usuario" style="width: 50%;">
                          <tr>
                            <th class="hpesquisa"></th>
                            <th>ID</th>
                            <th>FORNECEDOR</th>
                            <th>OBRA</th>
                            <th>QUANT</th>
                            <th></th>
                          </tr>
                          <% 
                            List<Aquisicao> aquisicoes = (List<Aquisicao>) request.getAttribute("listAquisicoesAtivas");
                            for(Aquisicao aquisicao : aquisicoes){ %>
                          <tr>
                            <td><a href="/sgab/main?acao=ConfereAquisicao&aquisicaoId=<%=aquisicao.getId()%>">&#128270</a></td>
                            <td><%= aquisicao.getId() %></td>
                            <td><%= aquisicao.getFornecedor().getNomeFornecedor() %></td>
                            <td><%= aquisicao.getObra().getTitulo() %></td>
                            <td><%= aquisicao.getQuantidade() %></td>
                            <td style=" background-color: #aaaaaa; 
                                        display: flex;
                                        position: relative;
                                        justify-content: space-around;
                            ">
                                <input type="button" class="button" style="
                                    text-align: center;
                                    height: 26px; 
                                    border-color: #aaaaaa; 
                                    background-color: #aaaaaa;
                                    color: black;
                                    border-radius: 0;
                                    
                                " value="Finalizar" onclick="finalizar(<%=aquisicao.getId()%>,document.frmAquisicao)"></td>
                          </tr>
                          <% } %>
              </table>
              </form>
              
          </center>
<script>
    function finalizar(id, frm){
        frm.aquisicaoId.value = id;
        frm.action = "/sgab/main?acao=FinalizarAquisicao";
        frm.submit();
    }

    function listarPedidosPendentes(frm){
        frm.action = "/sgab/main?acao=ListarAquisicoes";
        frm.submit();
    }

    function listarPedidosFinalizados(frm){
        frm.action = "/sgab/main?acao=ListarAquisicoesFinalizadas";
        frm.submit();
    }
</script>
<%@include file="/core/footer.jsp" %>