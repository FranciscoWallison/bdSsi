package br.com.bdSsi.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.bdSsi.dao.UsuarioDAO;
import br.com.bdSsi.factory.ConnectionFactory;
import br.com.bdSsi.model.Usuario;

@WebServlet("/sistema")
public class AutenticaUsuarioServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioAutenticado = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Connection connection = new ConnectionFactory().getConnection();

		UsuarioDAO dao = new UsuarioDAO(connection);
		usuarioAutenticado = dao.autentica(login, senha);

		if (usuarioAutenticado != null) {
			HttpSession session = request.getSession();
			HttpSession sessao = request.getSession();
			sessao.setAttribute("nome", "SessionScope");
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			session.setMaxInactiveInterval(5 * 60);
			Cookie userName = new Cookie("usuario", login);
			userName.setMaxAge(5 * 60);
			response.addCookie(userName);

			response.sendRedirect("relatorios.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			// request.setAttribute("msgUsuario", "Login ou senha inválidos!");

			// response.sendRedirect("login.jsp?msgUsuario=Login ou senha
			// inválidos!");

			rd.forward(request, response);
		}
	}

}
