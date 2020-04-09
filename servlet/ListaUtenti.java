package Database;

import java.io.IOException;
import java.util.List;

import model.Cliente;
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
	List<Utente> listaDaValidare;
	List<Utente>listaValidati;
	List<Utente>listaRimossi;
       
   
    public ListaUtenti() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		listaUtenti = Database.getInstance().getListaUtenti();
		
		for (Utente u : listaUtenti) {
			
			if(u.getValidato()==0 ) {
				
				listaDaValidare.add(u);
				
			}
			
			if(u.getValidato()==1) {
				
				listaValidati.add(u);
				
			}
			
			if(u.getValidato()==2) {
				
				listaRimossi.add(u);
			
			}
		}
		request.setAttribute("listaUtentiNonValidati", listaDaValidare);
		request.setAttribute("listaUtentiValidati", listaValidati);
		request.setAttribute("listaUtentiCancellati", listaRimossi);
		
	
	}

	
	

}