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

@WebServlet(name = "gestioneauto", urlPatterns = { "/gestioneauto" })
public class GestioneAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestioneAuto() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email_admin") != null || session.getAttribute("utente") != null){
			List<Auto> listaAuto = Database.getInstance().getAutoRimosse();
			request.setAttribute("rimosse", listaAuto);
		}

			request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/ripristinaauto.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
