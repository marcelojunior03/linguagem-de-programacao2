package java.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String senha = request.getParameter("senha");

        if ("admin".equals(username) && "123".equals(senha)) {

            HttpSession session = request.getSession();

            session.setAttribute("usuario", username);

            List<String> produtos = new ArrayList<>();

            Cookie[] cookies = request.getCookies();

            if (cookies != null) {

                for (Cookie cookie : cookies) {

                    if (cookie.getName().startsWith("produto")) {

                        String valor = URLDecoder.decode(
                                cookie.getValue(),
                                StandardCharsets.UTF_8
                        );

                        produtos.add(valor);
                    }
                }
            }

            session.setAttribute("produtos", produtos);

            response.sendRedirect("pedido.jsp");

        } else {

            response.sendRedirect("login.jsp?erro=1");
        }
    }
}