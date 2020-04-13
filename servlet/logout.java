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
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/home.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		risposta1_jsp=request.getParameter("email");
		risposta2_jsp=request.getParameter("password");
		if(admin_email.equals(risposta1_jsp)&&admin_password.equals(risposta2_jsp)){
			session.setAttribute("email_admin", request.getParameter("email"));
			System.out.println("OK malfidati!!!!!");
		}else if(Database.getInstance().getUtente(risposta1_jsp, risposta2_jsp)!=null)
		{
			Utente utente=Database.getInstance().getUtente(risposta1_jsp,risposta2_jsp);
			if(utente.getValidato()==1) {
			session.setAttribute("utente", utente);
			System.out.println("Ciao!!!");
			}
		}else if(Database.getInstance().getCliente(risposta1_jsp, risposta2_jsp)!=null){
			Cliente cliente=Database.getInstance().getCliente(risposta1_jsp,risposta2_jsp);
			if(cliente.getValidato()==1) {
			session.setAttribute("cliente",cliente);
			System.out.println("OK!!!!!");
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
		response.sendRedirect("login");
	}
	
}
