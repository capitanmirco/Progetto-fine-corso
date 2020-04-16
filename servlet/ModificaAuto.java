package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Auto;
import model.Categoria;


@WebServlet("/modificaauto")
public class ModificaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModificaAuto() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("utente")!=null || session.getAttribute("email_admin")!=null) {

			//prendo l'id che mi passerÃ  il catalogo cliccando su modifica auto e creo un'auto
			if(request.getParameter("modifica")!=null) {
				
				int id=Integer.parseInt(request.getParameter("modifica"));
				Auto a=Database.getInstance().getAutoById(id);
				request.setAttribute("auto", a);
				
			}
			
				request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request,response);
				request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request,response);
				request.getServletContext().getRequestDispatcher("/jsp/formAuto.jsp").include(request,response);
				request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request,response);

		}
		
		else {
			response.sendRedirect("home");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("utente")!=null || session.getAttribute("email_admin")!=null) {
			//mi creo un'auto 
			int id=Integer.parseInt(request.getParameter("id"));
			
			Auto a= Database.getInstance().getAutoById(id);  
			
			double cilindrata=Double.parseDouble(request.getParameter("cilindrata"));
			int idCategoria=Integer.parseInt(request.getParameter("categoria"));
			
			Categoria c=Database.getInstance().getCategoriaById(idCategoria);
			
			
			a.setCilindrata(cilindrata);
			a.setColore(request.getParameter("colore"));
			a.setMarca(request.getParameter("marca"));
			a.setModello(request.getParameter("modello"));
			a.setTarga(request.getParameter("targa"));
			a.setCategoria(c);
			Database.getInstance().updateAuto(a);
			System.out.println("auto aggiornata");
			response.sendRedirect("catalogo");
		}
		
		else {
			response.sendRedirect("home");
		}
		
	}

}
