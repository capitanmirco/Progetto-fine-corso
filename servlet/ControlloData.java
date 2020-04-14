package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Auto;
import model.Noleggio;

@WebServlet(name = "controllodata", urlPatterns = { "/controllodata" })
public class ControlloData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlloData() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate data_attuale = LocalDate.now();
		List<Noleggio> listaNoleggi = Database.getInstance().getListaNoleggi();

		if(listaNoleggi != null) {

			for(Noleggio disponibili: listaNoleggi) {
				
				if(disponibili.getStato()==1) {
					LocalDate data_fine = LocalDate.parse(disponibili.getDataFine());

					if(data_fine.isBefore(data_attuale)) {
						byte finito = 0;
						disponibili.setStato(finito);
						Database.getInstance().updateNoleggio(disponibili);
						Auto a = Database.getInstance().getAutoById(disponibili.getAuto().getIdAuto());
						
							if(!noleggiAttivi(a)) {
								byte disponibile = 1;
								a.setDisponibilita(disponibile);
							}
					}
					
				}

			}
		}
		else {
			System.out.println("sono null");
		}
	}
	
	public boolean noleggiAttivi(Auto a) {
		boolean noleggiAttivi = false;
		List<Noleggio> listaNoleggi = Database.getInstance().getListaNoleggi();
		if(listaNoleggi!= null) {
			for(Noleggio n : listaNoleggi) {
				if(n.getAuto().getIdAuto() == a.getIdAuto() && n.getStato()==1) {
					noleggiAttivi = true;
				}
			}
		}
		
		return noleggiAttivi;
		
	}

}
