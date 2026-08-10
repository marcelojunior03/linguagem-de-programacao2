package Exercicio3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/temperatura")
public class TemperaturaServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String temperaturaTexto =
                request.getParameter("temperatura");

        String operacao =
                request.getParameter("operacao");

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado</title>");
        out.println("</head>");
        out.println("<body>");

        try {

            if (temperaturaTexto == null ||
                temperaturaTexto.trim().isEmpty()) {

                out.println("<h2>Erro!</h2>");
                out.println(
                    "<p>Informe uma temperatura.</p>"
                );

            } else {

                double temperatura =
                    Double.parseDouble(temperaturaTexto);

                double resultado = 0;

                String unidade = "";

                switch (operacao) {

                    case "C_F":

                        resultado =
                            temperatura * 1.8 + 32;

                        unidade = "°F";

                        break;

                    case "F_C":

                        resultado =
                            (temperatura - 32) / 1.8;

                        unidade = "°C";

                        break;

                    case "C_K":

                        resultado =
                            temperatura + 273.15;

                        unidade = "K";

                        break;

                    case "K_C":

                        resultado =
                            temperatura - 273.15;

                        unidade = "°C";

                        break;

                    case "F_K":

                        resultado =
                            (temperatura + 459.67) / 1.8;

                        unidade = "K";

                        break;

                    case "K_F":

                        resultado =
                            temperatura * 1.8 - 459.67;

                        unidade = "°F";

                        break;

                    default:

                        out.println(
                            "<p>Operação inválida.</p>"
                        );

                        out.println("</body></html>");
                        return;
                }

                out.println("<h1>Resultado</h1>");

                out.println(
                    "<p>Temperatura informada: "
                    + temperatura
                    + "</p>"
                );

                out.println(
                    "<h2>Resultado: "
                    + resultado
                    + " "
                    + unidade
                    + "</h2>"
                );
            }

        } catch (NumberFormatException e) {

            out.println("<h2>Erro!</h2>");

            out.println(
                "<p>A temperatura deve ser um número.</p>"
            );
        }

        out.println("<br>");

        out.println(
            "<a href='temperatura.html'>Voltar</a>"
        );

        out.println("</body>");
        out.println("</html>");
    }
}