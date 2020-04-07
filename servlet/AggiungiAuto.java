package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import it.java.todolist.Utente;
import model.Auto;


@WebServlet("/AggiungiAuto")
public class AggiungiAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList <Auto> listaAuto;
	boolean presente=false;
	
   
    public AggiungiAuto() {
        super();
       listaAuto=new ArrayList <Auto>();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/aggiungiauto.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double cilindrata = Double.parseDouble(request.getParameter("cilindrata"));
		String colore= request.getParameter("colore");
		byte disponibilita = Byte.parseByte("disponibilita");
		String marca= request.getParameter("marca");
		String modello = request.getParameter("modello");
		String targa = request.getParameter("targa");
		
		Auto a= new Auto();
		a.setCilindrata(cilindrata);
		a.setColore(colore);
		a.setDisponibilita(disponibilita);
		a.setMarca(marca);
		a.setModello(modello);
		a.setTarga(targa);
		Database.getInstance().addAuto(a);
		
		response.sendRedirect("catalogo");
		
	}
	
	
}


