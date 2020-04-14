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

@WebServlet("/areapersonale")
public class areaPersonale extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public areaPersonale() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request,response);
		if(session.getAttribute("cliente")!=null) {
			Cliente cliente=(Cliente) session.getAttribute("cliente");
			request.setAttribute("cliente",cliente);
		}else if(session.getAttribute("utente")!=null) {
			Utente utente=(Utente) session.getAttribute("utente");
			request.setAttribute("utente",utente);
		}
		request.getServletContext().getRequestDispatcher("/jsp/gestioneDati.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);

	}

}
