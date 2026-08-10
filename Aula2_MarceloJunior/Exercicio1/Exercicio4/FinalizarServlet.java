package Exercicio4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/finalizar")
public class FinalizarServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session =
            request.getSession();

        String livro =
            (String) session.getAttribute("livro");

        String precoTexto =
            (String) session.getAttribute("preco");

        String imagem =
            (String) session.getAttribute("imagem");

        String nome =
            (String) session.getAttribute("nome");

        String cpf =
            (String) session.getAttribute("cpf");

        String sexo =
            (String) session.getAttribute("sexo");

        String endereco =
            (String) session.getAttribute("endereco");

        String cidade =
            (String) session.getAttribute("cidade");

        String estado =
            (String) session.getAttribute("estado");

        String pagamento =
            request.getParameter("pagamento");

        String parcelamento =
            request.getParameter("parcelamento");

        double preco =
            Double.parseDouble(precoTexto);

        int parcelas =
            Integer.parseInt(parcelamento);

        double valorParcela =
            preco / parcelas;

        PrintWriter out =
            response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Pedido Finalizado</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Pedido Finalizado</h1>");

        out.println("<hr>");

        out.println("<h2>Livro</h2>");

        out.println(
            "<img src='"
            + imagem
            + "' width='150' height='200'>"
        );

        out.println(
            "<p><strong>Nome:</strong> "
            + livro
            + "</p>"
        );

        out.println(
            "<p><strong>Preço:</strong> R$ "
            + String.format("%.2f", preco)
            + "</p>"
        );

        out.println("<hr>");

        out.println("<h2>Dados do Cliente</h2>");

        out.println(
            "<p><strong>Nome:</strong> "
            + nome
            + "</p>"
        );

        out.println(
            "<p><strong>CPF:</strong> "
            + cpf
            + "</p>"
        );

        out.println(
            "<p><strong>Sexo:</strong> "
            + sexo
            + "</p>"
        );

        out.println(
            "<p><strong>Endereço:</strong> "
            + endereco
            + "</p>"
        );

        out.println(
            "<p><strong>Cidade:</strong> "
            + cidade
            + "</p>"
        );

        out.println(
            "<p><strong>Estado:</strong> "
            + estado
            + "</p>"
        );

        out.println("<hr>");

        out.println("<h2>Pagamento</h2>");

        out.println(
            "<p><strong>Forma de pagamento:</strong> "
            + pagamento
            + "</p>"
        );

        out.println(
            "<p><strong>Parcelamento:</strong> "
            + parcelas
            + "x</p>"
        );

        out.println(
            "<p><strong>Valor da parcela:</strong> R$ "
            + String.format("%.2f", valorParcela)
            + "</p>"
        );

        out.println("<hr>");

        out.println(
            "<h2>Pedido realizado com sucesso!</h2>"
        );

        out.println("</body>");
        out.println("</html>");
    }
}