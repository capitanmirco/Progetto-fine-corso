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

/**
 * Servlet implementation class ValidaClienti
 */
@WebServlet(name ="validaclienti", urlPatterns = {"/validaclienti"})
public class ValidaClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidaClienti() {
        super();
    }

    /* valida=1 validato - valida=0 da validare &&  id_cliente o id_utente = n*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		/*check valida e check id passato correttamente*/
		if(request.getParameter("valida")!=null && request.getParameter("valida").equals("1") && request.getParameter("id")!=null
				&& session.getAttribute("email_admin")!=null) {
			
			boolean isNumericId = isNumericId(request.getParameter("id"));
			
			/*if id is numeric*/
			if(isNumericId) {
				Cliente c = Database.getInstance().getClienteById(Integer.parseInt(request.getParameter("id")));
				if(c!=null) {
					byte valida = 1;
					c.setValidato(valida);
					Database.getInstance().updateCliente(c);
					response.sendRedirect("gestionepersone");
				}
			}
		}//end if
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}
	
	/*controlla se la stringa può essere parsata senza errori*/
	private boolean isNumericId(String s) {
		boolean isNumericId=false;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) >= 48 && s.charAt(i)<= 57) {
				isNumericId=true;
			}else {
				isNumericId=false;
				break;
			}
		}
		return isNumericId;
	}

}
