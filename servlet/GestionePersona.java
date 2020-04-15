package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class GestionePersone
 */
@WebServlet(name = "gestionepersona", urlPatterns = { "/gestionepersona" })
public class GestionePersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionePersona() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*solo per admin e utenti*/
		if(session.getAttribute("cliente")==null) {
			//configurare bene le jsp dopo il termine del lavoro front-end
			request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);

			/*gestione visualizzazioni lista in base al tipo di account loggato*/
			if(session.getAttribute("email_admin")!=null) {
				request.getServletContext().getNamedDispatcher("listautenti").include(request, response);
				request.getServletContext().getNamedDispatcher("listaclienti").include(request, response);
			}else if(session.getAttribute("utente")!=null) {
				request.getServletContext().getNamedDispatcher("listaclienti").include(request, response);
				request.removeAttribute("listaClientiNonValidati");
				request.removeAttribute("listaClientiCancellati");
			}

			request.getServletContext().getRequestDispatcher("/jsp/gestionePersona.jsp").include(request, response);		
			request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
		}else {
			response.sendRedirect("home");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
