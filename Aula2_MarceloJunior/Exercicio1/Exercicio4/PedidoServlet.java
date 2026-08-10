package Exercicio4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String livro =
            request.getParameter("livro");

        String preco =
            request.getParameter("preco");

        String imagem =
            request.getParameter("imagem");

        HttpSession session =
            request.getSession();

        session.setAttribute("livro", livro);
        session.setAttribute("preco", preco);
        session.setAttribute("imagem", imagem);

        PrintWriter out =
            response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Dados do Cliente</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Dados do Cliente</h1>");

        out.println(
            "<p>Livro escolhido: "
            + livro
            + "</p>"
        );

        out.println(
            "<p>Preço: R$ "
            + preco
            + "</p>"
        );

        out.println("<form action='pagamento' method='post'>");

        out.println(
            "Nome completo:<br>"
            + "<input type='text' name='nome'>"
        );

        out.println("<br><br>");

        out.println(
            "CPF:<br>"
            + "<input type='text' name='cpf'>"
        );

        out.println("<br><br>");

        out.println("Sexo:<br>");

        out.println(
            "<input type='radio' "
            + "name='sexo' "
            + "value='Masculino'> Masculino"
        );

        out.println(
            "<input type='radio' "
            + "name='sexo' "
            + "value='Feminino'> Feminino"
        );

        out.println("<br><br>");

        out.println(
            "Endereço:<br>"
            + "<input type='text' name='endereco'>"
        );

        out.println("<br><br>");

        out.println(
            "Cidade:<br>"
            + "<input type='text' name='cidade'>"
        );

        out.println("<br><br>");

        out.println("Estado:<br>");

        out.println("<select name='estado'>");

        out.println("<option value='SP'>SP</option>");
        out.println("<option value='RJ'>RJ</option>");
        out.println("<option value='MG'>MG</option>");
        out.println("<option value='ES'>ES</option>");

        out.println("</select>");

        out.println("<br><br>");

        out.println(
            "<input type='submit' value='Próximo'>"
        );

        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}