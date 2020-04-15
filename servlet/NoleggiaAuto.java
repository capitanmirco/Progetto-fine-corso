package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Auto;
import model.Cliente;
import model.Noleggio;

@WebServlet(name = "noleggiaauto", urlPatterns = { "/noleggiaauto" })
public class NoleggiaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoleggiaAuto() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cliente")!=null && request.getParameter("noleggia") != null) {	// posso fare un noleggio solo se sono un cliente
			
				int id_auto = Integer.parseInt(request.getParameter("noleggia"));				// una volta che premo il pulsante per noleggiare l'auto, prendo l'id di quell'auto corrispondente
				Auto auto = Database.getInstance().getAutoById(id_auto);						// prendo i dati dell'auto tramite l'id che ho appena preso
				
				Cliente cliente = (Cliente) session.getAttribute("cliente");					// prendo i dati del cliente che sta facendo la prenotazione
				
				String dataInizio = request.getParameter("inizioNolo");							// prendo la data di inizio noleggio
				String dataFine = request.getParameter("fineNolo");								// prendo la data di fine noleggio
				
				Noleggio n = new Noleggio();													// creo un noleggio settando l'auto, il cliente e le date di inizio e fine
				n.setAuto(auto);
				n.setCliente(cliente);
				n.setDataInizio(dataInizio);
				n.setDataFine(dataFine);
				
				request.setAttribute("noleggio", n);											// metto il noleggio nella request
				
				request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
				request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
				request.getServletContext().getRequestDispatcher("/jsp/riepilogo.jsp").include(request, response);
				request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
			
		}
		else {
			response.sendRedirect("home");														// se non sono un cliente o non sono loggato, vado alla home
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numero_carta = Integer.parseInt(request.getParameter("numero_carta"));
	}

}
