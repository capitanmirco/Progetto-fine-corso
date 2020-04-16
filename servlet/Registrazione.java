package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

		if ((request.getParameter("nome") != null) && !(request.getParameter("nome").trim().equals(""))
				&& (request.getParameter("cognome") != null) && !(request.getParameter("cognome").trim().equals(""))
				&& (request.getParameter("email") != null) && !(request.getParameter("email").trim().equals(""))
				&& (request.getParameter("password") != null) && !(request.getParameter("password").trim().equals(""))
				&& (request.getParameter("datadinascita") != null)
				&& !(request.getParameter("datadinascita").trim().equals(""))
				&& (request.getParameter("codicefiscale") != null)
				&& !(request.getParameter("codicefiscale").trim().equals(""))) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate data = LocalDate.now().minusYears(18); // data attuale meno 18 anni
			LocalDate dataInserita = LocalDate.parse(request.getParameter("datadinascita").trim());
			int differenzaDate = data.compareTo(dataInserita); // restituisce la differenza tra le 2 date
			
			if (differenzaDate >= 0) {
				request.removeAttribute("erroredata");
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String dataDiNascita = request.getParameter("datadinascita");
				String codiceFiscale = request.getParameter("codicefiscale");
				

				if (request.getParameter("ut_cl") != null && request.getParameter("ut_cl").equals("cl")
						&& (request.getParameter("numeropatente") != null)
						&& !(request.getParameter("numeropatente").trim().equals(""))) {

					System.out.println(codiceFiscale);
					
					if (!(Database.getInstance().getClienteByCF(codiceFiscale) != null) && !(Database.getInstance().getCliente(email) != null) 
							&& !(Database.getInstance().getClienteByPatente(request.getParameter("numeropatente")) != null)) {
						
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
						request.getServletContext().getNamedDispatcher("aggiungiclienti").include(request, response);
						doGet(request, response);
						
					} else {
						request.setAttribute("errorecliente", "si");
						System.out.println("email, codice fiscale o numero patente già presente");
						doGet(request, response);
					}
					
				} else if (request.getParameter("ut_cl") != null && request.getParameter("ut_cl").equals("ut")) {

					if (!(Database.getInstance().getUtenteByCF(codiceFiscale) != null) && !(Database.getInstance().getUtente(email) != null)) {
						Utente u = new Utente();

						u.setNome(nome);
						u.setCognome(cognome);
						u.setEmail(email);
						u.setPassword(password);
						u.setDataDiNascita(dataDiNascita);
						u.setCodiceFiscale(codiceFiscale);

						request.setAttribute("utente", u);
						request.getServletContext().getNamedDispatcher("aggiungiutenti").include(request, response);
						doGet(request, response);

					} else {
						request.setAttribute("erroreutente", "si");
						System.out.println("email o codice fiscale già presente");
						doGet(request, response);
					}
				}
				
			} else {
				request.setAttribute("erroredata", "si");
				System.out.println("Tutto ok raga è minorenne");
				doGet(request, response);
			}
			
		}else {
			System.out.println("Inserisci tutti i campi");
			doGet(request, response);
		}
	}
}
