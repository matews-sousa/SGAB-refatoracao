<center><h3>Inserir Obra</h3></center>
<section id="form">
  <div id="caixa-form">
    <form name="frmInsereObra" method="post">
      <input type="hidden" name="table" value="Obra" />
      <input type="hidden" name="acao" value="gravar" />
      <label for="categoria">Categoria</label>
      <select name="categoria" id="categoria">
        <option value="livro">Livro</option>
        <option value="mapa">Mapa</option>
        <option value="docComputacional">Documento computacional</option>
      </select>
      <label for="titulo">T�tulo</label>
      <input
        type="text"
        id="titulo"
        name="titulo"
        placeholder="Insira o t�tulo da obra"
      />
      <!-- TODO AUTORES -->
      <label>Autores</label>
      <span
        onclick="abreModal('pesquisaAutor')"
        style="
          float: right;
          font-weight: bolder;
          font-size: 1.5em;
          cursor: pointer;
          user-select: none;
        "
        >+</span
      >
      <input id="autores-input" type="hidden" name="autores" value="">
      <div id="autores" style="padding-top: 10px;"></div>

      <!-- TODO ASSUNTOS -->
      <label>Assuntos</label>
      <span
        onclick="abreModal('pesquisaAssunto')"
        style="
          float: right;
          font-weight: bolder;
          font-size: 1.5em;
          cursor: pointer;
          user-select: none;
        "
        >+</span
      >
      <input id="assuntos-input" type="hidden" name="assuntos" value="">
      <div id="assuntos" style="padding-top: 10px;"></div>

      <label for="nota">Nota</label>
      <input
        type="text"
        style="height: 5em"
        id="nota"
        name="nota"
        placeholder="Insira uma breve descri��o"
      />
      <div class="divisao">
        <div>
          <label for="ano">Ano de publica��o</label>
          <input type="number" id="ano" name="ano" placeholder="Ex.: 1987" />
        </div>
        <div>
          <label for="editora">Editora</label>
          <input
            type="text"
            id="editora"
            name="editora"
            placeholder="Ex.: Fundamento"
          />
        </div>
      </div>
      <label for="cidEditora">Cidade da Editora</label>
      <input
        type="text"
        id="cidEditora"
        name="cidEditora"
        placeholder="Ex.: S�o Paulo"
      />
      <div class="divisao">
        <div>
          <label for="edicao">Edi��o</label>
          <input
            type="number"
            id="edicao"
            name="edicao"
            placeholder="Insira a edi��o"
          />
        </div>
        <div>
          <label for="volume">Volume</label>
          <input type="number" id="volume" name="volume" placeholder="Ex.: 1" />
        </div>
      </div>
      <div class="buttons">
        <button type="button" onclick="gravarAlteracao(document.frmInsereObra)">
          Cadastrar
        </button>
      </div>
    </form>
  </div>
</section>

<!--Mask-->
<div id="mask" onclick="fechaModalAll()"></div>

<!-- Modal Autores-->
<div class="form-popup" id="pesquisaAutor">
  <div class="close-btn" onclick="fechaModal('pesquisaAutor')">&times;</div>
  <form class="form-container">
    <h2>Adicionar Autor</h2>
    <div>
      <div class="pesquisa-container">
        <input type="text" id="nomeAutor" placeholder="Insira o nome do autor." />
        <input class="button" type="button" onclick="ajaxAutor()" value="Pesquisar" />
      </div>
      <div id="resultados-pesquisa-autores"></div>
    </div>
  </form>
</div>

<!-- Modal Assuntos-->
<div class="form-popup" id="pesquisaAssunto">
  <div class="close-btn" onclick="fechaModal('pesquisaAssunto')">&times;</div>
  <form class="form-container">
    <h2>Adicionar Assunto</h2>
    <div class="pesquisa-container">
       <input type="text" id="nomeAssunto" placeholder="Insira o assunto." />
       <input class="button" type="button" onclick="ajaxAssunto()" value="Pesquisar" />
    </div>
    <div id="resultados-pesquisa-assuntos"></div>
  </form>
</div>

<script src="/sgab/js/cssControl.js"></script>
<script>
  let autoresResultEL = document.querySelector("#resultados-pesquisa-autores");
  let assuntosResultEL = document.querySelector("#resultados-pesquisa-assuntos");

  function ajaxAutor() {
    let xh;
    if (window.XMLHttpRequest) // c�digo dos browsers modernos
      xh = new XMLHttpRequest();
    else
      xh = new ActiveXObject("Microsoft.XMLHTTP");

    xh.onreadystatechange = function (){
      if (this.readyState == 4 && this.status == 200) {
        autoresResultEL.innerHTML = this.responseText;
      };
    }

    let nomeAutor = encodeURIComponent(document.querySelector("#nomeAutor").value);
    let parameters = "nomeAutor=" + nomeAutor;
    xh.open("POST", "/sgab/PesquisaAutorAjax", true);
    xh.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xh.send(parameters);
  }
  
  function ajaxAssunto() {
    let xh;
    if (window.XMLHttpRequest) // c�digo dos browsers modernos
      xh = new XMLHttpRequest();
    else
      xh = new ActiveXObject("Microsoft.XMLHTTP");

    xh.onreadystatechange = function (){
      if (this.readyState == 4 && this.status == 200) {
        assuntosResultEL.innerHTML = this.responseText;
      };
    }

    let assunto = encodeURIComponent(document.querySelector("#nomeAssunto").value);
    let parameters = "nomeAssunto=" + assunto;
    xh.open("POST", "/sgab/PesquisaAssuntoAjax", true);
    xh.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xh.send(parameters);
  }
  
  function adicionaAutor(nome){

      let autoresEL = document.querySelector("#autores");
      let autoresInputEl = document.querySelector("#autores-input");

      let novoAutorEl = document.createElement("div");
      novoAutorEl.innerHTML = "<span>" + nome + "</span><input type=\"button\" value=\"Excluir\" onclick=\"excluirAutor('" + nome + "')\">";
      novoAutorEl.classList.add("acoes");
      novoAutorEl.id = nome;

      autoresEL.appendChild(novoAutorEl);
      autoresInputEl.value = autoresInputEl.value + nome + "::";

  }
  
  function adicionaAssunto(nome){

      let assuntosEL = document.querySelector("#assuntos");
      let assuntosInputEl = document.querySelector("#assuntos-input");

      let novoAssuntoEl = document.createElement("div");
      novoAssuntoEl.innerHTML = "<span>" + nome + "</span><input type=\"button\" value=\"Excluir\" onclick=\"excluirAssunto('" + nome + "')\">";
      novoAssuntoEl.classList.add("acoes");
      novoAssuntoEl.id = nome;

      assuntosEL.appendChild(novoAssuntoEl);
      assuntosInputEl.value = assuntosInputEl.value + nome + "::";

  }

  function excluirAutor(nome){
    let descricao = nome + "::";
    let regex = new RegExp(descricao, "gm");
    let autoresInputEl = document.querySelector("#autores-input");

    let autorAlvoEl = document.querySelector("#" + nome);
    autorAlvoEl.parentNode.removeChild(autorAlvoEl);
    autoresInputEl.value = autoresInputEl.value.replace(regex, "");
  }
  
  function excluirAssunto(nome){
    let descricao = nome + "::";
    let regex = new RegExp(descricao, "gm");
    let assuntosInputEl = document.querySelector("#assuntos-input");

    let assuntoAlvoEl = document.querySelector("#" + nome);
    assuntoAlvoEl.parentNode.removeChild(assuntoAlvoEl);
    assuntosInputEl.value = assuntosInputEl.value.replace(regex, "");
  }
</script>
