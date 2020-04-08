package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.cj.Session;
import database.Database;


@WebServlet("/updatedati")
public class ModificaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ModificaDati() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getServletContext().getNamedDispatcher("registrazione").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		


		HttpSession session = request.getSession();

		if (session.getAttribute("cliente") !=null) {	

			Cliente c = (Cliente) session.getAttribute("cliente");

			String nome = request.getParameter("nome");
			String cognome =  request.getParameter("cognome");
			String email =  request.getParameter("mail");
			String password =  request.getParameter("password");
			String dataDiNascita = request.getParameter("dataDiNascita");
			String codiceFiscale = request.getParameter("codiceFiscale");
			String numeroPatente =  request.getParameter("numeroPatente");

			c.setNome(nome);
			c.setCognome(cognome);
			c.setEmail(email);
			c.setPassword(password);
			c.setDataDiNascita(dataDiNascita);
			c.setCodiceFiscale(codiceFiscale);
			c.setNumeroPatente(numeroPatente);

			Database.getInstance().updateCliente(c);
		}

		if (session.getAttribute("utente") !=null) {

			Utente u = (Utente) session.getAttribute("utente") ;

			String nomeu = request.getParameter("nome");
			String cognomeu =  request.getParameter("cognome");
			String emailu =  request.getParameter("mail");
			String passwordu =  request.getParameter("password");
			String dataDiNascitau = request.getParameter("dataDiNascita");
			String codiceFiscaleu = request.getParameter("codiceFiscale");

			u.setNome(nomeu);
			u.setCognome(cognomeu);
			u.setEmail(emailu);
			u.setPassword(passwordu);
			u.setDataDiNascita(dataDiNascitau);
			u.setCodiceFiscale(codiceFiscaleu);

			Database.getInstance().updateUtente(u);
		}


	}

}
