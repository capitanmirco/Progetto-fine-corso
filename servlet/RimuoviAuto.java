package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Auto;

@WebServlet("/rimuoviauto")
public class RimuoviAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RimuoviAuto() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		List<Auto> listaAuto = Database.getInstance().getListaAuto();
		
		for(int i=0; i<listaAuto.size(); i++) {
			
				if(listaAuto.get(i).getDisponibilita()==2) {
					listaAuto.remove(i);
				}
				
		}
		
		request.setAttribute("listaAuto", listaAuto);
		
		byte disponibilita = 2;
		
		if(session.getAttribute("utente")!=null || session.getAttribute("email_admin")!=null) {
			
		
			request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/lista.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
			
			if(request.getParameter("remove")!=null) {
				int id = Integer.parseInt(request.getParameter("remove"));
				Auto a = Database.getInstance().getAutoById(id);
				a.setDisponibilita(disponibilita);
				Database.getInstance().updateAuto(a);
				response.sendRedirect("rimuoviauto");
			}

		}
		
		else {
			response.sendRedirect("home");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
