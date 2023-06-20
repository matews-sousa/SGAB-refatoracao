package sgab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sgab.model.dto.Autor;
import sgab.model.service.GestaoAutor;

public class AutorController {
    public static String pesquisar(HttpServletRequest request){
        String jsp = "";
        try {
        String nome = request.getParameter("nomeAutor");
            GestaoAutor gestaoAutor = new GestaoAutor();
            Autor autor;
            try{
                Long id = Long.parseLong(request.getParameter("idAutor"));
                autor = gestaoAutor.pesquisarId(id);
                request.setAttribute("nome", autor.getNome());
                request.setAttribute("id", autor.getId());
                jsp = "/core/autores/pesquisapronta.jsp";
            }catch(NumberFormatException e){
                if(nome != null){
                autor = gestaoAutor.pesquisarNome(nome);
                request.setAttribute("nome", autor.getNome());
                request.setAttribute("id", autor.getId());
                jsp = "/core/autores/pesquisapronta.jsp";
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

   

    public static String alterar(HttpServletRequest request) {
        String jsp = "";
        try {
       String nome = request.getParameter("nomeAutor");
       Integer Id = Integer.parseInt(request.getParameter("idAutor"));

       GestaoAutor gestaoAutor = new GestaoAutor();

      if (Id != null && nome != null) {
        Autor autor = new Autor(nome);
        autor.setId(Id);
          gestaoAutor.alterarAutor(autor);
          jsp = "/core/autores/certo.jsp";

            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

 

    public static String insercao(HttpServletRequest request) {
        String jsp = "";
        try {
            String nome = request.getParameter("nomeAutor");

        GestaoAutor gestaoAutor = new GestaoAutor();

        Autor autor = new Autor(nome);
        gestaoAutor.cadastrarAutor(autor);
        jsp = "/core/autores/certo.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
            System.out.println("erro");
            
        }
        return jsp;
    }

    public static String excluir(HttpServletRequest request) {
        String jsp = "";
        try {
         Long Id = Long.parseLong(request.getParameter("idAutor"));

        GestaoAutor gestaoAutor = new GestaoAutor();

        if (Id != null) {
      
          gestaoAutor.removerAutor(Id);
          jsp = "/core/autores/certo.jsp";
        } }catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }    
    }