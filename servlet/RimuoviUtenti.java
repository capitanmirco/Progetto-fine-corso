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
                                                                                                                                     
@WebServlet("/rimuoviutenti")                                                                                                        
public class RimuoviUtenti extends HttpServlet {                                                                                     
	private static final long serialVersionUID = 1L;                                                                                 
	                                                                                                                                 
    public RimuoviUtenti() {                                                                                                         
        super();                                                                                                                     
    }                                                                                                                                
                                                                                                                                     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		HttpSession session = request.getSession();
		/*request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/lista.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request,response);*/
		if(request.getParameter("remove") != null){
			int id = Integer.parseInt(request.getParameter("remove"));
			byte disabilitato = 2;
				if(session.getAttribute("email_admin") !=null) {                                                                             
			                                                                                                                                                                                   
					Utente u = Database.getInstance().getUtenteById(id);   
					u.setValidato(disabilitato);
					Database.getInstance().updateUtente(u);		                                                                             
					//response.sendRedirect("listautenti");   
					System.out.println("Utente eliminato da admin");
				}            
		
				if(session.getAttribute("utente")!=null) {
			
					Utente u = (Utente) session.getAttribute("utente");			
					u.setValidato(disabilitato);					
					Database.getInstance().updateUtente(u);
					System.out.println("Utente eliminato");
					response.sendRedirect("logoutservlet");
				}
			}   
		}
                                                                                                                                     
}                                                                                                                                   
