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

@WebServlet("/modificadati")
public class ModificaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaDati() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/modificaDati.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if ((request.getParameter("nome") != null)&&(!request.getParameter("nome").trim().equals("")) && (request.getParameter("cognome") != null)&&
				(!request.getParameter("cognome").trim().equals(""))
				&& (request.getParameter("email") != null)&&(!request.getParameter("email").trim().equals("")) && 
				(request.getParameter("password") != null)&&(!request.getParameter("password").trim().equals(""))
				&& (!request.getParameter("datadinascita").trim().equals(""))&& (request.getParameter("datadinascita") != null) &&
				(!request.getParameter("codicefiscale").trim().equals(""))&&(request.getParameter("codicefiscale") != null)) {

			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String dataDiNascita = request.getParameter("datadinascita");
			String codiceFiscale = request.getParameter("codicefiscale");

			if (session.getAttribute("cliente") != null) {

				Cliente c = (Cliente) session.getAttribute("cliente");
				System.out.println("nome iniziale" + c.getNome());

				String numeroPatente = request.getParameter("numeropatente");

				if(!c.getNome().equals(nome)) {
					c.setNome(nome);
				}

				if(!c.getCognome().equals(cognome)) {
					c.setCognome(cognome);
				}

				if(!c.getPassword().equals(password)) {
					c.setPassword(password);
				}

				if(!c.getEmail().equals(email)) {
					Cliente cliente_temp = Database.getInstance().getCliente(email);
					if(cliente_temp== null || (cliente_temp != null && cliente_temp.getIdCliente()==(c.getIdCliente()))) {
						c.setEmail(email);
					}
					else {
						request.setAttribute("erroremodificacliente", true);
						System.out.println("email esistente");
						doGet(request, response);
					}
				}

				if(!c.getDataDiNascita().equals(dataDiNascita)) {
					c.setDataDiNascita(dataDiNascita);
				}

				if(!c.getCodiceFiscale().equals(codiceFiscale)) {
					Cliente cliente_temp = Database.getInstance().getClienteByCF(codiceFiscale);
					if(cliente_temp== null || (cliente_temp != null && cliente_temp.getIdCliente()==(c.getIdCliente()))) {
						c.setCodiceFiscale(codiceFiscale);
					}
					else {
						request.setAttribute("erroremodificacliente", true);
						System.out.println("codice fiscale esistente");
						doGet(request, response);
					}
				}

				if(!c.getNumeroPatente().equals(numeroPatente)) {
					if((request.getParameter("numeropatente")!=null) && (!request.getParameter("numeropatente").trim().equals(""))) {
						Cliente cliente_temp = Database.getInstance().getClienteByPatente(numeroPatente);
						if(cliente_temp== null || (cliente_temp != null && cliente_temp.getIdCliente()==(c.getIdCliente()))) {
							c.setNumeroPatente(numeroPatente);
						}
						else {
							request.setAttribute("erroremodificacliente", true);
							System.out.println("patente esistente");
							doGet(request, response);
						}

					}
				}

				//System.out.println("nome cambiato" +c.getNome());

				if(request.getAttribute("erroremodificacliente") == null) {
					Database.getInstance().updateCliente(c);
					System.out.println("cliente modificato");
					response.sendRedirect("visualizzadati");
				}


			}


			if (session.getAttribute("utente") != null) {

				Utente u = (Utente) session.getAttribute("utente");

					if(!u.getNome().equals(nome)) {
						u.setNome(nome);
					}
					if(!u.getCognome().equals(cognome)) {
						u.setCognome(cognome);
					}
					if(!u.getEmail().equals(email)) {
						Utente utente_temp = Database.getInstance().getUtente(email);
						if(utente_temp== null || (utente_temp != null && utente_temp.getIdUtente()==(u.getIdUtente()))) {
							u.setEmail(email);
						}
						else {
							request.setAttribute("erroremodificautente", true);
							System.out.println("email esistente");
							doGet(request, response);
						}
					}
					if(!u.getPassword().equals(password)) {
						u.setPassword(password);
					}
					if(!u.getDataDiNascita().equals(dataDiNascita)) {
						u.setDataDiNascita(dataDiNascita);
					}
					if(!u.getCodiceFiscale().equals(codiceFiscale)) {
						Utente utente_temp = Database.getInstance().getUtenteByCF(codiceFiscale);
						if(utente_temp== null || (utente_temp != null && utente_temp.getIdUtente()==(u.getIdUtente()))) {
							u.setCodiceFiscale(codiceFiscale);
						}
						else {
							request.setAttribute("erroremodificautente", true);
							System.out.println("cf esistente");
							doGet(request, response);
						}
					}

					if(request.getAttribute("erroremodificautente") == null) {
						Database.getInstance().updateUtente(u);
						System.out.println("utente modificato");
						response.sendRedirect("visualizzadati");
					}
				}

			}

		}
	}
