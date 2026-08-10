package Exercicio2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String valor1Texto = request.getParameter("valor1");
        String valor2Texto = request.getParameter("valor2");
        String operacao = request.getParameter("operacao");

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado</title>");
        out.println("</head>");
        out.println("<body>");

        try {

            if (valor1Texto == null ||
                valor1Texto.trim().isEmpty() ||
                valor2Texto == null ||
                valor2Texto.trim().isEmpty()) {

                out.println("<h2>Erro!</h2>");
                out.println("<p>Preencha os dois valores.</p>");

            } else {

                double valor1 = Double.parseDouble(valor1Texto);
                double valor2 = Double.parseDouble(valor2Texto);

                double resultado = 0;

                switch (operacao) {

                    case "+":

                        resultado = valor1 + valor2;
                        break;

                    case "-":

                        resultado = valor1 - valor2;
                        break;

                    case "*":

                        resultado = valor1 * valor2;
                        break;

                    case "/":

                        if (valor2 == 0) {

                            out.println("<h2>Erro!</h2>");
                            out.println(
                                "<p>Não é possível dividir por zero.</p>"
                            );

                            out.println("</body></html>");
                            return;
                        }

                        resultado = valor1 / valor2;
                        break;

                    case "%":

                        if (valor1 % 1 != 0 ||
                            valor2 % 1 != 0) {

                            out.println("<h2>Erro!</h2>");
                            out.println(
                                "<p>A operação % aceita apenas números inteiros.</p>"
                            );

                            out.println("</body></html>");
                            return;
                        }

                        if (valor2 == 0) {

                            out.println("<h2>Erro!</h2>");
                            out.println(
                                "<p>Não é possível dividir por zero.</p>"
                            );

                            out.println("</body></html>");
                            return;
                        }

                        resultado = valor1 % valor2;
                        break;

                    default:

                        out.println("<p>Operação inválida.</p>");
                        out.println("</body></html>");
                        return;
                }

                out.println("<h1>Resultado</h1>");

                out.println("<p>Valor 1: " + valor1 + "</p>");
                out.println("<p>Valor 2: " + valor2 + "</p>");
                out.println("<p>Operação: " + operacao + "</p>");

                out.println(
                    "<h2>Resultado: " + resultado + "</h2>"
                );
            }

        } catch (NumberFormatException e) {

            out.println("<h2>Erro!</h2>");
            out.println(
                "<p>Os valores devem ser números.</p>"
            );
        }

        out.println("<br>");
        out.println("<a href='calculadora.html'>Voltar</a>");

        out.println("</body>");
        out.println("</html>");
    }
}