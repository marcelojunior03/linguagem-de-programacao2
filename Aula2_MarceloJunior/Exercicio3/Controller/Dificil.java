package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dificil")
public class DificilServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        double pontos = 0;

        String q1 =
            request.getParameter("q1");

        String q2 =
            request.getParameter("q2");

        String q3 =
            request.getParameter("q3");

        if ("b".equals(q1)) {
            pontos += 1.0;
        } else {
            pontos -= 0.5;
        }

        if ("a".equals(q2)) {
            pontos += 1.0;
        } else {
            pontos -= 0.5;
        }

        if ("b".equals(q3)) {
            pontos += 1.0;
        } else {
            pontos -= 0.5;
        }

        request.setAttribute(
            "nivel",
            "Difícil"
        );

        request.setAttribute(
            "pontos",
            pontos
        );

        request.getRequestDispatcher(
            "View/resultado.jsp"
        ).forward(request, response);
    }
}