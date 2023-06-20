<%@page contentType="text/html" pageEncoding="UTF-8"%>

 
<%@page import="sgab.model.dto.Exemplar" %> 
<%@page import="sgab.model.dto.Autor" %>
<%@page import="sgab.model.dto.Reserva" %>
<%@page import="java.util.List" %>
<%@page import="sgab.model.dto.Reserva" %>


<%@include file="/core/header.jsp" %>
<style>
        #escolha{
            display: flex;
            position: relative;
            justify-content: space-around;

        }

        #escolha::after{
            content: "";
            background: black;
            position: absolute;
            bottom: 0;
            left: 50%;
            height: 100%;
            width: 1px;
        }

        .hpesquisa{
            flex: 0.5;
        }
        .pesquisa{
            cursor: pointer;
            flex: 0.5;
        }
    </style> 
      <center>
          <h3>Reservas - Acervo de Reservas</h3>
          <div class="acoes">
              <span></span>
              <form class="pesquisa-container" name="frmPesquisa" method="post">
                  <input type="hidden" value="ExemplarPesquisar" name="acao">
                  <select name="tipo">
                      <option value="null" selected>[Pesquisar por]</option>
                      <option value="titulo">Título</option>
                      <option value="leitor">Login do Leitor</option>
                  </select>
                  <input type="text" name="nome" placeholder="Escolha o tipo.">
                  <input type="button" class="button" onclick="validarPesquisaReservas(document.frmPesquisa)" value="Pesquisar">
              </form>
          </div>
          <form name="frmReserva" method="post">
                <input type="hidden" name="table" value="Reserva">
                <input type="hidden" name="reservaId" value="">
                <table style="width: 100%;">
                    <tr>
                      <th>LEITOR</th>  
                      <th>EXEMPLAR</th>
                      <th>DATA</th>
                    </tr>
                    <% 
                    List<Reserva> lista = (List<Reserva>) request.getAttribute("listReservas");
                    for(Reserva reserva : lista){
                    %>
                    
                    <tr>
                      <td><%= reserva.getPessoa().getNome()%></td>
                      <td><%= reserva.getExemplar().getObra().getTitulo()%></td>
                      <td><%= reserva.getHorario()%></td>
                      <td id="escolha" style="background-color: #aaaaaa; ">   
                                <input type="button" class="button" style="
                                    display: inline;  
                                    height: 26px; 
                                    border-color: #aaaaaa; 
                                    background-color: #aaaaaa;
                                    color: black;
                                    border-radius: 0;
                                    
                                    " value="Apagar" onclick="finalizar(<%=reserva.getId()%>,document.frmReserva)">
                                <input type="button" class="button" style="
                                    display: inline; 
                                    height: 26px; 
                                    border-color: #aaaaaa; 
                                    background-color: #aaaaaa;
                                    color: black;
                                    border-radius: 0;
                                " value="Emprestar" onclick="emprestar(<%=reserva.getId()%>, document.frmReserva)">
                    </tr> 
                    <% } %> 
        </table>
        </form>
        
    </center>
        
    <script>
        function finalizar(id, frm){
            frm.reservaId.value = id;
            frm.action = "/sgab/main?acao=FinalizarReserva";
            frm.submit();
        }
        
        function emprestar(id, frm){
            frm.reservaId.value = id;
            frm.action = "/sgab/main?acao=EmprestarReserva";
            frm.submit();
        }
    </script>    
    <%@include file="/core/footer.jsp" %>