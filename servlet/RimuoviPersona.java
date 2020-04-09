package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Utente;


@WebServlet("/rimuovipersona")
public class RimuoviPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RimuoviPersona() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("utente")!=null) {
			request.getServletContext().getNamedDispatcher("rimuoviutente").include(request,response);
			response.sendRedirect("home");
		}
		else if(session.getAttribute("cliente")!=null){
			request.getServletContext().getRequestDispatcher("rimuovicliente").include(request,response);
			response.sendRedirect("home");
		}
		else {
			request.getServletContext().getNamedDispatcher("home").include(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
