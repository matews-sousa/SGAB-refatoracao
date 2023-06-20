<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Pessoa" %>

<%@include file="/core/header.jsp" %>

<%  Pessoa pessoa = (Pessoa) request.getAttribute("pessoa"); %>

    <center>
        <h3>Alteração de Pessoa</h3>
    </center>
        <section id="form">
            <div id="caixa-form">
                <form name="modificarPessoa" method="post">
                    <input type="hidden" name="table" value="Pessoa">
                    <input type="hidden" name="acao" value="alterar">
                    <div>
                        <label for="pessoaId">Código</label>
                        <input type="number" id="pessoaId" name="pessoaId" placeholder="ID" value="<%=pessoa.getId()%>" readonly>
                    </div>
                    <div>
                        <label for="cpf">CPF</label>
                        <input type="number" id="cpf" name="cpf" placeholder="CPF" value="<%=pessoa.getCpf()%>" readonly>
                    </div>
                    <div>
                        <label for="login">Login</label>
                        <input type="text" id="login" name="login" placeholder="Login" value="<%=pessoa.getLogin()%>" readonly>
                    </div>
                    <div>
                        <label for="nome">Nome</label>
                        <input type="text" id="nome" name="nome" placeholder="Nome" value="<%=pessoa.getNome()%>">
                        <small>Digite seu nome e sobrenome.</small>
                    </div>
                    <div>
                        <label for="email">Email</label>
                        <input type="text" id="email" name="email" placeholder="Email" value="<%=pessoa.getEmail()%>">
                        <small>Digite um endereço de email válido.</small>
                    </div>
                    <div>
                        <label for="senha">Senha</label>
                        <input type="password" id="senha" name="senha" placeholder="Senha" value="<%=pessoa.getSenha()%>">
                        <small>A senha precisa ter 8 caracteres, pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.</small>
                    </div>
                    <div id="senha2-div">
                        <label for="senha2">Confirme a nova senha <span class="input-obrigatorio">*</span></label>
                        <input type="password" id="senha2" name="senha2" placeholder="Senha">
                        <small>As senhas não correspondem.</small>
                    </div>
                    <div id="caixa-form-footer">
                        <input type="button" class="button" name="ordem" value="Alterar" onclick="gravarAlteracao(document.modificarPessoa)">
                        <input type="button" class="button" name="ordem" value="Excluir" onclick="excluir(<%=pessoa.getCpf()%>, document.modificarPessoa)">
                    </div>
                </form>
            </div>
        </section>
    </center>

    <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
    <script>
        let senha2DivEl = document.querySelector("#senha2-div");

        senhaEl.addEventListener("change", () => {
            let regexEl = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/;
            if(regexEl.test(senhaEl.value)) {
                senha2DivEl.style.display = "block";
                senha2DivEl.style.visibility = "visible";
                senha2DivEl.attributes.required = true;
            }
        });
    </script>
        <style>
        #nome, #email, #senha {
            background: #fff url(imgs/editar.png) no-repeat 95% center;
            background-size: 18px;
        }

        #senha2-div {
            visibility: hidden;
            display: none;
        }
    </style>
    <%@include file="/core/footer.jsp" %>
