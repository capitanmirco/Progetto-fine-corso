package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Auto;
import model.Noleggio;

@WebServlet("/interrompinoleggiate")
public class InterrompiNoleggiate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InterrompiNoleggiate() {
        super();
       
    }

    // stato=0 --> in corso, stato=1 --> terminato, stato=2 --> noleggio interrotto
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("stato")!=null && request.getParameter("stato").equals("2") && request.getParameter("idNoleggio")!= null) {
			Integer id_noleggio = Integer.parseInt(request.getParameter("idNoleggio"));
			Noleggio n = Database.getInstance().getNoleggioById(id_noleggio);
			Auto a = n.getAuto();
			byte disponibile = 1;
			byte interrotto = 2;
			n.setStato(interrotto);
			a.setDisponibilita(disponibile);
			Database.getInstance().updateNoleggio(n);
			Database.getInstance().updateAuto(a);
		}
	}


}
