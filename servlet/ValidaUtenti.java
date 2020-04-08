package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Utente;

@WebServlet("/validautenti")
public class ValidaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidaUtenti() {
		super();

	}

	/*
	 * valida=1 --> validato - valida=0 --> da validare && id_cliente o id_utente =
	 * n
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (request.getParameter("valida") != null && request.getParameter("valida").equals("1")
				&& request.getParameter("id") != null && session.getAttribute("email_admin") != null) {
			boolean isNumericId = false;
			for (int i = 0; i < request.getParameter("id").length(); i++) {
				if (request.getParameter("id").charAt(i) >= 48 && request.getParameter("id").charAt(i) <= 57) {
					isNumericId = true;
				} else {
					isNumericId = false;
					break;
				}
			}

			/* if id is numeric */
			if (isNumericId) {
				Utente u = Database.getInstance().getUtenteById(Integer.parseInt(request.getParameter("id")));
				if (u != null) {
					if (request.getParameter("valida").charAt(0) >= 48
							&& request.getParameter("valida").charAt(0) <= 50) {
						u.setValidato(Byte.parseByte(request.getParameter("valida")));
						Database.getInstance().updateUtente(u);
					}
				}
			}
		} // end if

	}
	
		/* controlla se la stringa può essere parsata senza errori */
	private boolean isNumericId(String s) {
		boolean isNumericId = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
				isNumericId = true;
			} else {
				isNumericId = false;
				break;
			}
		}
		return isNumericId;
	}

}
