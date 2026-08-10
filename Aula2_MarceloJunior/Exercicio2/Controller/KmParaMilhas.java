package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/kmMilhas")
public class KmParaMilhasServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            double medida = Double.parseDouble(
                request.getParameter("medida")
            );

            double resultado = medida * 0.62;

            request.setAttribute(
                "resultado",
                resultado
            );

            request.setAttribute(
                "unidade",
                "milhas"
            );

            request.getRequestDispatcher(
                "View/resultado.jsp"
            ).forward(request, response);

        } catch (NumberFormatException e) {

            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Informe uma medida numérica."
            );
        }
    }
}