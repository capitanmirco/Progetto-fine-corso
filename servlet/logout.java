package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public logout() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(request.getSession().getAttribute("utente")!=null);
		System.out.println(request.getSession().getAttribute("cliente")!=null);
		System.out.println(request.getSession().getAttribute("mail_admin")!=null);
		System.out.println("logout");
		session.invalidate();
		response.sendRedirect("login");
	}
	
}
