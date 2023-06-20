<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="/core/header.jsp" %>
        
    <center>
        <h3>Cadastro de Pessoa</h3>
    </center>
        <section id="form">
            <div id="caixa-form">
                <form name="inserirPessoa" method="post">
                    <input type="hidden" name="table" value="Pessoa">
                    <input type="hidden" name="acao" value="gravar">
                    <div>
                        <label for="login">Informe o seu Login <span class="input-obrigatorio">*</span></label>
                        <input type="text" id="login" name="login" placeholder="Login" required>
                        <small>Digite um Login válido.</small>
                    </div>
                    <div>
                        <label for="cpf">Informe o seu CPF <span class="input-obrigatorio">*</span></label>
                        <input type="number" id="cpf" name="cpf" placeholder="CPF" required maxlength="11">
                        <small>Digite um CPF válido. Informe apenas números.</small>
                    </div>
                    <div>
                        <label for="nome">Informe o seu nome <span class="input-obrigatorio">*</span></label>
                        <input type="text" id="nome" name="nome" placeholder="Nome" required>
                        <small>Digite seu nome e sobrenome.</small>
                    </div>
                    <div>
                        <label for="email">Informe o seu endereço de email <span class="input-obrigatorio">*</span></label>
                        <input type="text" id="email" name="email" placeholder="Email" required>
                        <small>Digite um endereço de email válido.</small>
                    </div>
                    <div>
                        <label for="senha">Crie uma senha <span class="input-obrigatorio">*</span></label>
                        <input type="password" id="senha" name="senha" placeholder="Senha" required>
                        <small>A senha precisa ter 8 caracteres, pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.</small>
                    </div>
                    <div>
                        <label for="senha2">Confirme a sua senha <span class="input-obrigatorio">*</span></label>
                        <input type="password" id="senha2" name="senha2" placeholder="Senha" required>
                        <small>As senhas não correspondem.</small>
                    </div>
                    <div class="caixa-form-footer">
                        <input type="button" class="button" name="ordem" value="Cadastrar" onclick="gravarAlteracao(document.inserirPessoa)">
                        <a href="/sgab/main?acao=PessoaListar">Listar Pessoas</a><br>
                    </div>
                </form>
            </div>
        </section>

    <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
    <%@include file="/core/footer.jsp" %>