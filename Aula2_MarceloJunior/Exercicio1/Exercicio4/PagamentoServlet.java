package Exercicio4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/pagamento")
public class PagamentoServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session =
            request.getSession();

        String nome =
            request.getParameter("nome");

        String cpf =
            request.getParameter("cpf");

        String sexo =
            request.getParameter("sexo");

        String endereco =
            request.getParameter("endereco");

        String cidade =
            request.getParameter("cidade");

        String estado =
            request.getParameter("estado");

        session.setAttribute("nome", nome);
        session.setAttribute("cpf", cpf);
        session.setAttribute("sexo", sexo);
        session.setAttribute("endereco", endereco);
        session.setAttribute("cidade", cidade);
        session.setAttribute("estado", estado);

        String livro =
            (String) session.getAttribute("livro");

        String precoTexto =
            (String) session.getAttribute("preco");

        double preco =
            Double.parseDouble(precoTexto);

        PrintWriter out =
            response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Pagamento</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Pagamento</h1>");

        out.println(
            "<p>Livro: "
            + livro
            + "</p>"
        );

        out.println(
            "<p>Preço: R$ "
            + String.format("%.2f", preco)
            + "</p>"
        );

        out.println(
            "<form action='finalizar' method='post'>"
        );

        out.println("<h3>Forma de Pagamento</h3>");

        out.println(
            "<input type='radio' "
            + "name='pagamento' "
            + "value='Cartão de Crédito'> "
            + "Cartão de Crédito"
        );

        out.println("<br>");

        out.println(
            "<input type='radio' "
            + "name='pagamento' "
            + "value='Pix'> Pix"
        );

        out.println("<br>");

        out.println(
            "<input type='radio' "
            + "name='pagamento' "
            + "value='Boleto Bancário'> "
            + "Boleto Bancário"
        );

        out.println("<br><br>");

        out.println("<h3>Parcelamento</h3>");

        out.println("<select name='parcelamento'>");

        out.println(
            "<option value='1'>"
            + "1 x R$ "
            + String.format("%.2f", preco)
            + "</option>"
        );

        out.println(
            "<option value='2'>"
            + "2 x R$ "
            + String.format("%.2f", preco / 2)
            + "</option>"
        );

        out.println(
            "<option value='3'>"
            + "3 x R$ "
            + String.format("%.2f", preco / 3)
            + "</option>"
        );

        out.println("</select>");

        out.println("<br><br>");

        out.println(
            "<input type='submit' value='Finalizar'>"
        );

        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}