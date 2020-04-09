package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "validapersona", urlPatterns = { "/validapersona" })
public class ValidaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidaPersona() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		if(session.getAttribute("email_admin")!=null) {
				
			if(request.getParameter("validacliente")!=null && request.getParameter("id")!=null) {
				request.getServletContext().getNamedDispatcher("validaclienti").include(request, response);
			}
			else if(request.getParameter("validautente")!=null && request.getParameter("id")!=null) {
				request.getServletContext().getNamedDispatcher("validautenti").include(request, response);
			}
		}
		else {
			response.sendRedirect("home");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}