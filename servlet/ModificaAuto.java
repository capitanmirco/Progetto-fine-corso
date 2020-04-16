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
				if(!c.getDataDiNascita().equals(dataDiNascita)) {
					c.setDataDiNascita(dataDiNascita);
				}
				if(!c.getCodiceFiscale().equals(codiceFiscale)) {
					c.setCodiceFiscale(codiceFiscale);
				}
				if(!c.getNumeroPatente().equals(numeroPatente)) {
					c.setNumeroPatente(numeroPatente);
				}
				if (!(Database.getInstance().getClienteByCF(codiceFiscale) != null) && !(Database.getInstance().getCliente(email) != null) 
						&& !(Database.getInstance().getClienteByPatente(request.getParameter("numeropatente")) != null)) {
				
					if(request.getParameter("numeropatente")!=null&&(!request.getParameter("numeropatente").trim().equals(""))) {
						

						Database.getInstance().updateCliente(c);
						
						response.sendRedirect("visualizzadati");
					}
				}
				else {
					request.setAttribute("erroremodificacliente", "si");
					System.out.println("hai scritto qualcosa di brutto");
					doGet(request, response);
				}
				
			}
			

			if (session.getAttribute("utente") != null) {
				
				if (!(Database.getInstance().getUtenteByCF(codiceFiscale) != null) && !(Database.getInstance().getUtente(email) != null)) {

				Utente u = (Utente) session.getAttribute("utente");
				

				u.setNome(nome);
				u.setCognome(cognome);
				u.setEmail(email);
				u.setPassword(password);
				u.setDataDiNascita(dataDiNascita);
				u.setCodiceFiscale(codiceFiscale);

				Database.getInstance().updateUtente(u);
				response.sendRedirect("visualizzadati");
			}
				else {
					request.setAttribute("erroremodificautente", "si");
					System.out.println("hai scritto qualcosa di brutto");
					doGet(request, response);
				}
		}
		
	}

}
}
