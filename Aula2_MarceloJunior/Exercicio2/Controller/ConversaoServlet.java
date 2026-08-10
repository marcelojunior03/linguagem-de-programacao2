package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/conversao")
public class ConversaoServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String operacao =
            request.getParameter("operacao");

        String destino;

        switch (operacao) {

            case "milhasKm":
                destino = "milhasKm";
                break;

            case "kmMilhas":
                destino = "kmMilhas";
                break;

            case "pesMetros":
                destino = "pesMetros";
                break;

            case "metrosPes":
                destino = "metrosPes";
                break;

            default:
                response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Operação inválida."
                );
                return;
        }

        request.setAttribute("medida",
            request.getParameter("medida"));

        request.getRequestDispatcher(
            "/" + destino
        ).forward(request, response);
    }
}