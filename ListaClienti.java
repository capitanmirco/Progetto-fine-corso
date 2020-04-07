package Database;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;


@WebServlet("/listaclienti")
public class ListaClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Cliente> listaClienti;
       
    
    public ListaClienti() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	listaClienti = Database.getInstance().getListaClienti();
	request.setAttribute("Clienti_lista", listaClienti);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
