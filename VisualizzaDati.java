package Database;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Utente;


@WebServlet("/visualizzadati")
public class VisualizzaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoNoleggio");
	EntityManager em = emf.createEntityManager();
	String numeroPatente;
       
   
    public VisualizzaDati() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("utente")!=null) {
		 Utente u = (Utente) session.getAttribute("utente");
	    request.setAttribute("Utente", u);
		request.getServletContext().getRequestDispatcher("jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("jsp/paginautente.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("jsp/footer.jsp").include(request, response);
		}
		if(session.getAttribute("cliente")!=null) {
			Cliente c= (Cliente) session.getAttribute("cliente");
		request.setAttribute("Cliente", c);
		request.getServletContext().getRequestDispatcher("jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("jsp/paginacliente.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("jsp/footer.jsp").include(request, response);
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	
    

}
