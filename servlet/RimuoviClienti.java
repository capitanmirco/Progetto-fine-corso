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

@WebServlet(name = "rimuovicliente", urlPatterns = { "/rimuovicliente" })
public class RimuoviClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/lista.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request,response);*/
		HttpSession session = request.getSession();
		if(request.getParameter("remove") != null) {
			int id = Integer.parseInt(request.getParameter("remove"));
			byte disabilitato = 2;
			
			// se sono un admin
			if(session.getAttribute("email_admin")!=null) {
				Cliente c = Database.getInstance().getClienteById(id);
				c.setValidato(disabilitato);								// setto il suo stato a 2, quindi "disabilitato"
				
				Database.getInstance().updateCliente(c);
				System.out.println("cliente eliminato ad admin");

				response.sendRedirect("gestionepersona");
			}
			
			// se sono un utente
			if(session.getAttribute("utente") != null) {
				Cliente c = Database.getInstance().getClienteById(id);
				c.setValidato(disabilitato);								// setto il suo stato a 2, quindi "disabilitato"
				
				Database.getInstance().updateCliente(c);
				
				response.sendRedirect("gestionepersona");
				System.out.println("cliente eliminato da utente");
			}
			
			// se sono un cliente
			if(session.getAttribute("cliente") != null) {
				
				Cliente c=(Cliente) session.getAttribute("cliente");
				
				c.setValidato(disabilitato);								// setto il suo stato a 2, quindi "disabilitato"
				
				Database.getInstance().updateCliente(c);
				
				System.out.println("cliente eliminato");
				response.sendRedirect("logout");
			}
		
		}
		
	}

}
