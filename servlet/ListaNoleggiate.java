package Database;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noleggio;


@WebServlet("/listanoleggi")
public class ListaNoleggiate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Noleggio> listaNoleggi;
    
    public ListaNoleggiate() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	listaNoleggi=Database.getInstance().getListaNoleggi();
	request.setAttribute("Noleggi_lista", listaNoleggi);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
