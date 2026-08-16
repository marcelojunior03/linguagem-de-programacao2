package java.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("usuario") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String pagamento = request.getParameter("pagamento");
        String parcelamento = request.getParameter("parcelamento");

        session.setAttribute("nome", nome);
        session.setAttribute("cpf", cpf);
        session.setAttribute("sexo", sexo);
        session.setAttribute("endereco", endereco);
        session.setAttribute("cidade", cidade);
        session.setAttribute("estado", estado);
        session.setAttribute("pagamento", pagamento);
        session.setAttribute("parcelamento", parcelamento);

        response.sendRedirect("final.jsp");
    }
}