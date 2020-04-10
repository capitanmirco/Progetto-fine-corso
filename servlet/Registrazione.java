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
		
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/registrazione.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ((request.getParameter("nome") != null) 
				&& !(request.getParameter("nome").trim().equals(" ")) 
				&& (request.getParameter("cognome") != null)
				&& !(request.getParameter("cognome").trim().equals(" "))
				&& (request.getParameter("email") != null) 
				&& !(request.getParameter("email").trim().equals(" "))
				&& (request.getParameter("password") != null) 
				&& !(request.getParameter("password").trim().equals(" "))
				&& (request.getParameter("datadinascita") != null) 
				&& !(request.getParameter("datadinascita").trim().equals(" "))
				&& (request.getParameter("codicefiscale") != null)
				&& !(request.getParameter("codicefiscale").trim().equals(" "))){

			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String dataDiNascita = request.getParameter("datadinascita");
			String codiceFiscale = request.getParameter("codicefiscale");

			if (request.getParameter("ut_cl") != null && request.getParameter("ut_cl").equals("cl")
					&& (request.getParameter("numeropatente") != null)) {

				if (!(Database.getInstance().getCliente(email) != null)) {

					String numeroPatente = request.getParameter("numeropatente");
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
					System.out.println("Cliente gia' registrato con questa email");
				}
			} else if (request.getParameter("ut_cl") != null && request.getParameter("ut_cl").equals("ut")) {

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
					System.out.println("Utente gia' registrato con questa email");
				}
			}			
		}
	}
}
