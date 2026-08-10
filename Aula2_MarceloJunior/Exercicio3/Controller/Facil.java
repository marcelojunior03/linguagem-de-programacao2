package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/facil")
public class FacilServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int pontos = 0;

        String q1 =
            request.getParameter("q1");

        String q2 =
            request.getParameter("q2");

        String q3 =
            request.getParameter("q3");


        if ("c".equals(q1)) {
            pontos++;
        }

        if ("b".equals(q2)) {
            pontos++;
        }

        if ("b".equals(q3)) {
            pontos++;
        }

        request.setAttribute(
            "nivel",
            "Fácil"
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