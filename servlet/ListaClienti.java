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
	List<Cliente>listaNonValidati;
	List<Cliente>listaValidati;
	List<Cliente>listaCancellati;
       
    
    public ListaClienti() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	listaClienti = Database.getInstance().getListaClienti();
	
	for (Cliente cliente : listaClienti) {
		
		if(cliente.getValidato()==0 ) {
			
			listaNonValidati.add(cliente);
			
		}
		
		if(cliente.getValidato()==1) {
			
			listaValidati.add(cliente);
			
		}
		
		if(cliente.getValidato()==2) {
			
			listaCancellati.add(cliente);
			
		}
	}
	request.setAttribute("listaClientiNonValidati", listaNonValidati);
	request.setAttribute("listaClientiValidati", listaValidati);
	request.setAttribute("listaClientiCancellati", listaCancellati);
	
	
	
	
	}

	
	

}
