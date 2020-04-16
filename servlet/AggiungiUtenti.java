package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Database;
import model.Utente;

@WebServlet(name = "aggiungiutenti", urlPatterns = { "/aggiungiutenti" })
public class AggiungiUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente u = (Utente) request.getAttribute("utente");
		boolean registrato = Database.getInstance().addUtente(u);
		if(registrato) {
		request.setAttribute("validazione", true);
		}
		System.out.println("ok utente aggiunto");
	}
}
