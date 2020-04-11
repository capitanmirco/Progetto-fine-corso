package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import model.Cliente;
import model.Noleggio;


@WebServlet("/listanoleggi")
public class ListaNoleggiate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Noleggio> noleggiIncorso;
	List<Noleggio> storicoNoleggi;
    
    public ListaNoleggiate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	HttpSession session = request.getSession();    	
    	
    	noleggiIncorso = new ArrayList<Noleggio>();
    	storicoNoleggi = new ArrayList<Noleggio>();

    	request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
    	request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);

    	/*se loggato come admin o utente*/
    	if(session.getAttribute("email_admin")!=null || session.getAttribute("utente")!=null) {
    		List<Noleggio>listaNoleggi=Database.getInstance().getListaNoleggi();
    		if(!listaNoleggi.isEmpty()) {
    			for(Noleggio n : listaNoleggi) {
    				if(n.getStato()==1 && !noleggiIncorso.contains(n)) {
    					noleggiIncorso.add(n);
    				}
    			}
    			request.setAttribute("Noleggi_lista", noleggiIncorso);
    		}
    	}//if loggato come utente/admin

    	/*se loggato come cliente*/
    	if(session.getAttribute("cliente")!=null) {
    		Cliente c = (Cliente) session.getAttribute("cliente");
    		System.out.println(c.getIdCliente());
    		List<Noleggio>listaNoleggi=Database.getInstance().getListaNoleggi();

    		/*noleggi in corso*/
    		if(!listaNoleggi.isEmpty()) {
    			for(Noleggio n : listaNoleggi) {
    				if(n.getStato()==1 && n.getCliente().getIdCliente()==c.getIdCliente() && !noleggiIncorso.contains(n)) {
    					System.out.println(n.getDataFine());
    					noleggiIncorso.add(n);
    				}
    			}
    			request.setAttribute("Noleggi_lista", noleggiIncorso);
    		}

    		/*storico noleggi*/
    		if(listaNoleggi!=null) {
    			for(Noleggio n : listaNoleggi) {
    				if((n.getStato()==0 || n.getStato()==2) && n.getCliente().getIdCliente()==c.getIdCliente() &&
    						!storicoNoleggi.contains(n)) {
    					storicoNoleggi.add(n);
    				}
    			}
    			request.setAttribute("storico_noleggi", storicoNoleggi);
    		}
    	}//if loggato cliente

    	request.getServletContext().getRequestDispatcher("/jsp/gestione-noleggio.jsp").include(request, response);				
    	request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
