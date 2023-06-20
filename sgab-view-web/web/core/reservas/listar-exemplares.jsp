<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sgab.model.dto.Exemplar" %> 
<%@page import="sgab.model.dto.Autor" %> 
<%@page import="sgab.model.dto.util.ExemplarStatus" %> 
<%@page import="java.util.List" %>


<%@include file="/core/header.jsp" %>
<style>
        .hpesquisa{
            flex: 0.5;
        }
        .pesquisa{
            cursor: pointer;
            flex: 0.5;
        }
    </style>  
      <center>
          <h3>Acervo de Exemplares Possíveis para Reservar</h3>
          <div class="acoes">
              <span></span>
              <form class="pesquisa-container" name="frmPesquisa" method="post">
                  <input type="hidden" value="ExemplarPesquisar" name="acao">
                  <select name="tipo">
                      <option value="null" selected>[Pesquisar por]</option>
                      <option value="titulo">Título</option>
                      <option value="autor">Autor</option>
                      <option value="biblioteca">Biblioteca</option>
                  </select>
                  <input type="text" name="nome" placeholder="Escolha o tipo.">
                  <input type="button" class="button" onclick="validarReservaPesquisaExemplar(document.frmPesquisa)" value="Pesquisar">
              </form>
          </div>
          <form name="frmExemplar" method="post">
                <input type="hidden" name="table" value="Exemplar">
                <input type="hidden" name="exemplarId" value="">
                <table style="width: 100%;">
                    <tr>
                      <th>TÍTULO</th>
                      <th>AUTORES</th>
                      <th>EDITORA</th>
                      <th>EDIÇÃO</th>
                      <th>VOLUME</th>
                      <th>ANO</th>
                      <th>BIBLIOTECA</th>
                      <th>ESTADO</th>
                      <th></th>
                    </tr>
                    <% 
                    List<Exemplar> lista = (List<Exemplar>) request.getAttribute("listExemplares");
                    for(Exemplar exemplar : lista){
                    %>
                    <tr>
                      <td><%= exemplar.getObra().getTitulo()%></td>
                      <td>
                      
                      <% for(Autor autor: exemplar.getObra().getAutor()){ %>
                      <%= autor.getNome()%>;
                      <% } %> 
                      
                      </td>
                      <td><%= exemplar.getObra().getEditora()%></td>
                      <td><%= exemplar.getObra().getEdicao()%></td>
                      <td><%= exemplar.getObra().getVolume()%></td>
                      <td><%= exemplar.getObra().getAnoPublicacao()%></td>
                      <td><%= exemplar.getBibliotecaPosse().getNome()%></td>
                      <td><%= exemplar.getStatus()%></td>
                      <td><input type="button" style="
                                display: block; 
                                margin-left: auto; 
                                margin-right: auto; 
                                padding: 4px 4px; 
                                height: 26px; 
                                border-color: #aaaaaa; 
                                background-color: #aaaaaa;
                                color: black;
                                width: 100%;
                                border-radius: 0;
                                " class="button" value="Reservar" onclick="reservar(<%= exemplar.getId()%>, document.frmExemplar)"></td>
                    </tr>
                    <% } %> 
        </table>
        </form>
        
    </center>
    <script>
        function reservar(id, frm) {
            frm.exemplarId.value = id;
            frm.action = "/sgab/main?acao=ReservarExemplar";
            frm.submit();
        }
    </script>      
    <%@include file="/core/footer.jsp" %>


