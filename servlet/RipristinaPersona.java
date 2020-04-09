package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Cliente;
import model.Utente;

@WebServlet("/ripristinapersona")
public class RipristinaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RipristinaPersona() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("email_admin") != null) {
			byte validato = 1;

			if (request.getParameter("ripristinautente") != null) {
				int id = Integer.parseInt(request.getParameter("ripristinautente"));

				Utente u = Database.getInstance().getUtenteById(id);
				u.setValidato(validato);
				Database.getInstance().updateUtente(u);

			} else if (request.getParameter("ripristinacliente") != null) {
				int id = Integer.parseInt(request.getParameter("ripristinacliente"));

				Cliente c = Database.getInstance().getClienteById(id);
				c.setValidato(validato);
				Database.getInstance().updateCliente(c);

			}
		}
	}

}
