package java.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrinho")
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String[] produtos = request.getParameterValues("produto");

        if (produtos == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        for (String produto : produtos) {

            String imagem = "";
            String descricao = "";
            double preco = 0;

            switch (produto) {

                case "1":
                    imagem = "https://cdn.awsli.com.br/954/954868/produto/68627041/40c163f71e.jpg";
                    descricao = "Notebook Dell";
                    preco = 3500.00;
                    break;

                case "2":
                    imagem = "https://www.lognetinfo.com.br/imagens/original/23359A.jpg";
                    descricao = "Teclado Mecânico";
                    preco = 250.00;
                    break;

                case "3":
                    imagem = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNV8cNEjLFJfdqr4donIbmPieW8bWnS4rpGFxy5_6WlA&s=10";
                    descricao = "Mouse Gamer";
                    preco = 150.00;
                    break;

                case "4":
                    imagem = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8BG0Pnji6VH5MnMyeJjCkUVMMlmknyq4FFv1IzHCd6QTkhfWWy4KWhN-P&s=10";
                    descricao = "Monitor 24 polegadas";
                    preco = 900.00;
                    break;
            }

            String valor = imagem + "|"
                    + descricao + "|"
                    + preco;

            valor = URLEncoder.encode(
                    valor,
                    StandardCharsets.UTF_8
            );

            Cookie cookie = new Cookie(
                    "produto" + produto,
                    valor
            );

            cookie.setMaxAge(60 * 60);

            response.addCookie(cookie);
        }

        response.sendRedirect("login.jsp");
    }
}