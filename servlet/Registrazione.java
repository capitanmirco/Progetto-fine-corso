package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;

import model.Cliente;
import model.Utente;

@WebServlet(name = "registrazione", urlPatterns = { "/registrazione" })
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registrazione() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/jsp/registrazione.jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ((request.getParameter("nome") != null) && (request.getParameter("cognome") != null)
				&& (request.getParameter("mail") != null) && (request.getParameter("password") != null)
				&& (request.getParameter("dataDiNascita") != null) && (request.getParameter("codiceFiscale") != null)) {

			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("mail");
			String password = request.getParameter("password");
			String dataDiNascita = request.getParameter("dataDiNascita");
			String codiceFiscale = request.getParameter("codiceFiscale");

			if (request.getParameter("cl_ut") != null && request.getParameter("cl_ut").equals("cl")
					&& (request.getParameter("numeroPatente") != null)) {

				if (!(Database.getInstance().getCliente(email) != null)) {

					String numeroPatente = request.getParameter("numeroPatente");
					Cliente c = new Cliente();

					c.setNome(nome);
					c.setCognome(cognome);
					c.setEmail(email);
					c.setPassword(password);
					c.setDataDiNascita(dataDiNascita);
					c.setCodiceFiscale(codiceFiscale);
					c.setNumeroPatente(numeroPatente);

					request.setAttribute("cliente", c);
					request.getServletContext().getNamedDispatcher("aggiungiclienti").forward(request, response);
				} else {
					System.out.println("Mail gia inserita");
				}
			} else if (request.getParameter("cl_ut") != null && request.getParameter("cl_ut").equals("ut")) {

				if (!(Database.getInstance().getUtente(email) != null)) {
					Utente u = new Utente();

					u.setNome(nome);
					u.setCognome(cognome);
					u.setEmail(email);
					u.setPassword(password);
					u.setDataDiNascita(dataDiNascita);
					u.setCodiceFiscale(codiceFiscale);

					request.setAttribute("utente", u);
					request.getServletContext().getNamedDispatcher("aggiungiutenti").forward(request, response);

				} else {
					System.out.println("Mail gia inserita");
				}
			}
		}
	}
}


