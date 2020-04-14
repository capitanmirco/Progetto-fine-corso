package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Auto;



@WebServlet(name = "catalogo", urlPatterns = { "/catalogo" })
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
   
    public Catalogo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<Auto> catalogoAuto;
	catalogoAuto = Database.getInstance().getAutoDisponibili();
	request.setAttribute("listaAuto", catalogoAuto);
	request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/catalogo.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/catalogo.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);

	}

}

