package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Auto;
import model.Noleggio;

@WebServlet("/interrompinoleggiate")
public class InterrompiNoleggiate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InterrompiNoleggiate() {
        super();
       
    }

    // stato=1 --> in corso, stato=0 --> terminato, stato=2 --> noleggio interrotto
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("stato")!=null && request.getParameter("stato").equals("2") && request.getParameter("idNoleggio")!= null) {
			Integer id_noleggio = Integer.parseInt(request.getParameter("idNoleggio"));
			Noleggio n = Database.getInstance().getNoleggioById(id_noleggio);
			Auto a = n.getAuto();
			byte disponibile = 1;
			byte interrotto = 2;
			n.setStato(interrotto);
			Database.getInstance().updateNoleggio(n);
			
			if(!noleggiAttivi(a)) {
				a.setDisponibilita(disponibile);
				Database.getInstance().updateAuto(a);
			}
			
			response.sendRedirect("listanoleggi");
		}
	}
	
	/*controlla se presenti altri noleggi per quel veicolo*/
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
