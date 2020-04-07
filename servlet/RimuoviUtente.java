package servlet;                                                                                                                     
                                                                                                                                     
import java.io.IOException;                                                                                                                                                                                                                       
                                                                                                                                     
import javax.servlet.ServletException;                                                                                               
import javax.servlet.annotation.WebServlet;                                                                                          
import javax.servlet.http.HttpServlet;                                                                                               
import javax.servlet.http.HttpServletRequest;                                                                                        
import javax.servlet.http.HttpServletResponse;                                                                                       
import javax.servlet.http.HttpSession;                                                                                               
                                                                                                                                     
import database.Database;                                                                                                            
import model.Utente;                                                                                                                 
                                                                                                                                     
@WebServlet("/rimuoviutente")                                                                                                        
public class RimuoviUtente extends HttpServlet {                                                                                     
	private static final long serialVersionUID = 1L;                                                                                 
	                                                                                                                                 
    public RimuoviUtente() {                                                                                                         
        super();                                                                                                                     
    }                                                                                                                                
                                                                                                                                     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		HttpSession session = request.getSession();  
		int id = Integer.parseInt(request.getParameter("remove"));
		byte disabilitato = 2;
		if(session.getAttribute("email_admin") !=null) {                                                                             
			                                                                                                                                                                                   
			Utente u = Database.getInstance().getUtenteById(id);                                                                     
			Database.getInstance().updateUtente(u);		                                                                             
			response.sendRedirect("listautenti");                                                                                    
		}            
		
		if(request.getParameter("numero_patente")!=null) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Utente u = Database.getInstance().getUtente(email, password);
			
			u.setValidato(disabilitato);								// setto il suo stato a 2, quindi "disabilitato"
			
			Database.getInstance().updateUtente(u);
			response.sendRedirect("logout");
		}
	}                                                                                                                                                                                                                                                     
                                                                                                                                     
}                                                                                                                                    
