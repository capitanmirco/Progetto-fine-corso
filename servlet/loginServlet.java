package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Utente;
import model.Auto;
import model.Categoria;
import model.Cliente;
import model.Noleggio;
import database.Database;


@WebServlet("/loginservlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String admin_email="matteo.aiello@gmail.com";
	private String admin_password="progettofinaleGeneration";

    public loginServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String risposta1_jsp;
		String risposta2_jsp;
		HttpSession session=request.getSession();
		risposta1_jsp=request.getParameter("campo_da_prendere_da_front_end_per_email");
		risposta2_jsp=request.getParameter("campo_da_prendere_da front_end_per_password");
		if(admin_email.equals(risposta1_jsp)&&admin_password.equals(risposta2_jsp)){
			session.setAttribute("email_admin", request.getParameter("campo_da_prendere_da_front_end_per_email"));
		}else if(Database.getIstance().getUtente(risposta1_jsp, risposta2_jsp)!=null)
		{
			Utente utente=Database.getIstance().getUtente(risposta1_jsp,risposta2_jsp);
			session.setAttribute("utente", utente);
		}else if(Database.getIstance().getCliente(risposta1_jsp, risposta2_jsp)!=null){
			Cliente cliente=Database.getIstance().getCliente(risposta1_jsp,risposta2_jsp);
			session.setAttribute("cliente",cliente);
		}else if(risposta1_jsp==null||risposta2_jsp==null)
		{
			String errore_null="Non hai inserito tutti i campi!!!";
			session.setAttribute("errore_null", errore_null);
		}
		else {
			String errore="siete scemi";
			session.setAttribute("errore", errore);
		}
	}
	/*public Utente checkUtente(String email,String password) {
		Utente utente=Database.getIstance().getUtente(email, password);
		return utente;
	}
	public Cliente checkCliente(String email,String password) {
		Cliente cliente=
	}*/

}
