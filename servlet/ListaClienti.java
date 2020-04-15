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


@WebServlet(name="listaclienti", urlPatterns = {"/listaclienti"})
public class ListaClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ListaClienti() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> listaClienti= new ArrayList<Cliente>();
		List<Cliente>listaNonValidati = new ArrayList<Cliente>();
		List<Cliente>listaValidati =new ArrayList<Cliente>();
		List<Cliente>listaCancellati =new ArrayList<Cliente>();


		listaClienti = Database.getInstance().getListaClienti();

		for (Cliente cliente : listaClienti) {
			if(cliente.getValidato()==0 && !listaNonValidati.contains(cliente)) {

				listaNonValidati.add(cliente);

			}else if(cliente.getValidato()==1 && !listaValidati.contains(cliente)) {

				listaValidati.add(cliente);


			}else if(cliente.getValidato()==2 && !listaCancellati.contains(cliente)) {
				listaCancellati.add(cliente);

			}
		}
		request.setAttribute("listaClientiNonValidati", listaNonValidati);
		request.setAttribute("listaClientiValidati", listaValidati);
		request.setAttribute("listaClientiCancellati", listaCancellati);

	}	

}
