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


@WebServlet("/aggiungiauto")
public class AggiungiAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	boolean presente=false;
	
   
    public AggiungiAuto() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.setAttribute("utente", "neve");
		
		// solo utenti e admin
		
		if(session.getAttribute("email_admin") != null || session.getAttribute("utente") != null) {
		
			request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/FormAutoProva.jsp").include(request, response);
			request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
		
		}
		
		else {
			response.sendRedirect("home");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			double cilindrata = Double.parseDouble(request.getParameter("cilindrata"));
			String colore= request.getParameter("colore");
			byte disponibilita = 1;
			String marca= request.getParameter("marca");
			String modello = request.getParameter("modello");
			String targa = request.getParameter("targa");
			
			int idCategoria=Integer.parseInt(request.getParameter("id_categoria"));
			Categoria c = Database.getInstance().getCategoriaById(idCategoria);
			
			if(cilindrata!=0 && colore!=null && marca!=null && modello!=null && targa!=null && idCategoria!=0) {
			
				Auto a= new Auto();
				a.setCilindrata(cilindrata);
				a.setColore(colore);
				a.setDisponibilita(disponibilita);
				a.setMarca(marca);
				a.setModello(modello);
				a.setTarga(targa);
				a.setCategoria(c);
				Database.getInstance().addAuto(a);
				
				System.out.println("auto aggiunta");
				
				response.sendRedirect("catalogo");
	
			}
}
	
}





