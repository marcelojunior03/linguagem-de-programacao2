package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nivel =
            request.getParameter("nivel");

        if ("facil".equals(nivel)) {

            response.sendRedirect(
                "View/quizFacil.jsp"
            );

        } else if ("dificil".equals(nivel)) {

            response.sendRedirect(
                "View/quizDificil.jsp"
            );

        } else {

            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Nível inválido."
            );
        }
    }
}