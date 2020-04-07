package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Auto;
import model.Categoria;

@WebServlet("/rimuoviauto")
public class RimuoviAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RimuoviAuto() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listaAuto", Database.getInstance().getListaAuto());
		
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("[pagina lista auto]").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getAttribute("utente")!=null || request.getAttribute("email_admin")!=null) {
			int id = Integer.parseInt(request.getParameter("[id auto da rimuovere]"));
			Auto a = Database.getInstance().getAutoById(id);
			a.setDisponibilita((byte) 2);
			Database.getInstance().updateAuto(a);
			response.sendRedirect("/rimuoviauto");
		}else {
			response.sendRedirect("[home]");
		}
	}
}
