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

@WebServlet("/updatedati")
public class ModificaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaDati() {
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
			
			System.out.println(nome+cognome+email+password+dataDiNascita+codiceFiscale);
			if (session.getAttribute("cliente") != null) {

				Cliente c = (Cliente) session.getAttribute("cliente");
				if(request.getParameter("numeropatente")!=null&&(!request.getParameter("numeropatente").trim().equals(""))) {
				String numeroPatente = request.getParameter("numeropatente");

				c.setNome(nome);
				c.setCognome(cognome);
				c.setEmail(email);
				c.setPassword(password);
				c.setDataDiNascita(dataDiNascita);
				c.setCodiceFiscale(codiceFiscale);
				c.setNumeroPatente(numeroPatente);

				Database.getInstance().updateCliente(c);
				}
			}

			if (session.getAttribute("utente") != null) {

				Utente u = (Utente) session.getAttribute("utente");
				

				u.setNome(nome);
				u.setCognome(cognome);
				u.setEmail(email);
				u.setPassword(password);
				u.setDataDiNascita(dataDiNascita);
				u.setCodiceFiscale(codiceFiscale);

				Database.getInstance().updateUtente(u);
			}

		}
		response.sendRedirect("home");
	}

}
