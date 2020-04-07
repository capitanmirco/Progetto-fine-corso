package Database;

import java.io.IOException;
import java.util.List;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listautenti")
public class ListaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Utente> listaUtenti;
       
   
    public ListaUtenti() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	listaUtenti = Database.getInstance().getListaUtenti();
	request.setAttribute("Utenti_lista", listaUtenti);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
