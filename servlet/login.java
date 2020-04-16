package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Utente;
import model.Cliente;
import database.Database;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String admin_email="matteo.aiello@gmail.com";
	private String admin_password="progettofinaleGeneration";
	String risposta1_jsp;
	String risposta2_jsp;

    public login() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String[] pag = request.getParameter("pagina").split("/");
		System.out.print("*****"+pag[2]);
		response.sendRedirect(pag[2]);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		risposta1_jsp=request.getParameter("email");
		risposta2_jsp=request.getParameter("password");
		if(admin_email.equals(risposta1_jsp)&&admin_password.equals(risposta2_jsp)){
			session.setAttribute("email_admin", request.getParameter("email"));
			session.removeAttribute("errore");
			System.out.println("OK malfidati!!!!!");
			doGet(request, response);
			
			
		}else if(Database.getInstance().getUtente(risposta1_jsp, risposta2_jsp)!=null)
		{
			Utente utente=Database.getInstance().getUtente(risposta1_jsp,risposta2_jsp);
			if(utente.getValidato()==1) {
			session.setAttribute("utente", utente);
			session.removeAttribute("errore");
			System.out.println("Ciao!!!");
			
			doGet(request, response);
			}
		}else if(Database.getInstance().getCliente(risposta1_jsp, risposta2_jsp)!=null){
			Cliente cliente=Database.getInstance().getCliente(risposta1_jsp,risposta2_jsp);
			if(cliente.getValidato()==1) {
			session.setAttribute("cliente",cliente);
			session.removeAttribute("errore");
			System.out.println("OK!!!!!");
			
			doGet(request, response);
			}
		}else if(risposta1_jsp==null||risposta2_jsp==null)
		{
			String errore_null="Non hai inserito tutti i campi!!!";
			session.setAttribute("errore_null", errore_null);
		}
		else {
			String errore="siete scemi";
			session.setAttribute("errore", errore);
			System.out.println(errore);
		}
		
	}
	
}
