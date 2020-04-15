package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Auto;
import model.Utente;

@WebServlet(name = "ripristinaauto", urlPatterns = { "/ripristinaauto" })
public class RipristinaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RipristinaAuto() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email_admin") != null || session.getAttribute("utente") != null){
			byte disponibile = 1;
			
			if(request.getParameter("ripristinaauto") != null) {
				
				int id = Integer.parseInt(request.getParameter("ripristinaauto"));

				Auto a = Database.getInstance().getAutoById(id);
				a.setDisponibilita(disponibile);
				Database.getInstance().updateAuto(a);
				
				response.sendRedirect("gestioneauto");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
