<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // carga inicial de dados para teste
    ServletContext applicationContext = request.getServletContext();
    if (applicationContext.getAttribute("initDB") == null) {
        sgab.util.InitDB.init();
        applicationContext.setAttribute("initDB", Boolean.TRUE);
    }

    Long pessoaId = (Long) request.getSession().getAttribute("pessoaId");
    if (pessoaId != null) {
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher("/core/menu.jsp");
        rd.forward(request, response);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SGAB | Sistema de Gestão de Acervo Bibliográfico </title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="css/styles.css">
        <script src="/sgab/js/helper.js"></script>
    </head>
    <body>
        <header>
            <div id="pagina-inicial">
                <a href="" title="Página Inicial">
                    SGAB
                </a>
            </div>
            <div id="logo-topo">
                <a href="http://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
                    <img src="/sgab/images/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais" />
                </a>
            </div>
        </header>
        <main>
            <section id="nome-form">
                <h1>Login</h1>
            </section>
            <section id="form">
                <div id="caixa-form">
                    <form name="frmLogin" method='post'>
                        <label>Login: <input type="text" id="login" name="login" placeholder="Login" required> </label>
                        <br />
                        <label>Senha: <input type="password" id="senha" name="senha" placeholder="Senha" required> </label>
                        <br />
                        <button type="button" onclick="validarCamposLogin(document.frmLogin)">Acessar</button>                       
                    </form>
                </div>
            </section>
        </main>
        <footer>
            <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
        </footer>
    </body>
</html>