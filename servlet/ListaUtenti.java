package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;

@WebServlet(name="listautenti", urlPatterns = {"/listautenti"})
public class ListaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListaUtenti() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Utente> listaUtenti;
		List<Utente> listaDaValidare;
		List<Utente> listaValidati;
		List<Utente> listaRimossi;
		
		listaDaValidare = new ArrayList<Utente>();
		listaValidati = new ArrayList<Utente>();
		listaRimossi = new ArrayList<Utente>();

		listaUtenti = Database.getInstance().getListaUtenti();

		for (Utente u : listaUtenti) {

			if (u.getValidato() == 0 && !listaDaValidare.contains(u)) {
				listaDaValidare.add(u);

			}

			if (u.getValidato() == 1 && !listaValidati.contains(u)) {
				listaValidati.add(u);

			}

			if (u.getValidato() == 2 && !listaRimossi.contains(u)) {

				listaRimossi.add(u);
			}
		}
		request.setAttribute("listaUtentiNonValidati", listaDaValidare);
		request.setAttribute("listaUtentiValidati", listaValidati);
		request.setAttribute("listaUtentiCancellati", listaRimossi);
	}
}
