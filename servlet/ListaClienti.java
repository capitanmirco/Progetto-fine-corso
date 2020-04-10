package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Cliente;


@WebServlet("/listaclienti")
public class ListaClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Cliente> listaClienti;
	List<Cliente>listaNonValidati;
	List<Cliente>listaValidati;
	List<Cliente>listaCancellati;
       
    
    public ListaClienti() {
        listaNonValidati=new ArrayList<Cliente>();
        listaValidati=new ArrayList<Cliente>();
        listaCancellati=new ArrayList<Cliente>();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
	
	listaClienti = Database.getInstance().getListaClienti();
	
	for (Cliente cliente : listaClienti) {
		if(cliente.getValidato()==0) {
			
			listaNonValidati.add(cliente);
			
		}else if(cliente.getValidato()==1) {
			
			listaValidati.add(cliente);

			
		}else if(cliente.getValidato()==2) {
			listaCancellati.add(cliente);
			
		}
	}
	request.setAttribute("listaClientiNonValidati", listaNonValidati);
	request.setAttribute("listaClientiValidati", listaValidati);
	request.setAttribute("listaClientiCancellati", listaCancellati);
	request.getServletContext().getRequestDispatcher("/jsp/lista.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	
	
	
	
	}	

}
