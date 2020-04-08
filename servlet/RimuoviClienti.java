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

@WebServlet(name = "rimuoviclienti", urlPatterns = { "/rimuoviclienti" })
public class RimuoviClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("remove"));
		byte disabilitato = 2;
		
		if(request.getParameter("remove") != null && request.getParameter("email") != null && request.getParameter("password") != null) {
			
			// se sono un admin
			if(request.getParameter("email").equals("matteo.aiello@gmail.com") && request.getParameter("password").equals("progettofinaleGeneration")) {
				Cliente c = Database.getInstance().getClienteById(id);
				c.setValidato(disabilitato);								// setto il suo stato a 2, quindi "disabilitato"
				
				Database.getInstance().updateCliente(c);
				
				response.sendRedirect("listaclienti");
			}
			
			// se sono un utente
			if(session.getAttribute("utente") != null) {
				Cliente c = Database.getInstance().getClienteById(id);
				c.setValidato(disabilitato);								// setto il suo stato a 2, quindi "disabilitato"
				
				Database.getInstance().updateCliente(c);
				
				response.sendRedirect("listaclienti");
			}
			
			// se sono un cliente
			if(session.getAttribute("cliente") != null) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				Cliente c = Database.getInstance().getCliente(email, password);
				
				c.setValidato(disabilitato);								// setto il suo stato a 2, quindi "disabilitato"
				
				Database.getInstance().updateCliente(c);
				
				response.sendRedirect("logout");
			}
		
		}
		
	}

}

