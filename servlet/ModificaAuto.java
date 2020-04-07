package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Auto;
import model.Categoria;
import model.Utente;


@WebServlet("/ModificaAuto")
public class ModificaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModificaAuto() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("modifica"));
		Auto a=Database.getInstance().getAutoById(id);
		request.setAttribute("auto", a);

		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/formAuto.jsp").include(request,response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Auto a=new Auto();
		int id=Integer.parseInt(request.getParameter("id"));
		double cilindrata=Double.parseDouble(request.getParameter("cilindrata"));
		byte disponibilita=Byte.parseByte(request.getParameter("disponibilita"));
		int idCategoria=Integer.parseInt(request.getParameter("idCategoria"));
		Categoria c=Database.getInstance().getCategoriaById(idCategoria);
		a.setIdAuto(id);
		a.setCilindrata(cilindrata);
		a.setColore(request.getParameter("colore"));
		a.setDisponibilita(disponibilita);
		a.setMarca(request.getParameter("marca"));
		a.setModello(request.getParameter("modello"));
		a.setTarga(request.getParameter("targa"));
		a.setCategoria(c);
		Database.getInstance().updateAuto(a);
		response.sendRedirect("catalogo");
	}

}
