package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Auto;



@WebServlet("/VisualizzaCatalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Auto> catalogoAuto;
	
       
   
    public Catalogo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
	catalogoAuto= Database.getInstance().getListaAuto();
	request.setAttribute("catalogo", catalogoAuto);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	
	
	
	
	
	}

}
