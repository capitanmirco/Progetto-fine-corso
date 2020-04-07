package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.security.ntlm.Client;

import database.Database;
import model.Cliente;
import model.Utente;



@WebServlet(name="registrazione", urlPatterns = {"/registrazione"})
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoNoleggio");
	EntityManager em = emf.createEntityManager();

	public Registro() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/jsp/registro.jsp").include(request,response);//????????????

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("id"); //ogg.ID
		String cl = request.getParameter("cl"); //cliente
		String ut = request.getParameter("ut"); //utente


		if(id.equals(cl)) {

			//cliente
			String nome = request.getParameter("nome");
			String cognome =  request.getParameter("cognome");
			String email =  request.getParameter("mail");
			String password =  request.getParameter("password");
			String dataDiNascita = request.getParameter("dataDiNascita"); 
			String codiceFiscale = request.getParameter("codiceFiscale");
			String numeroPatente =  request.getParameter("numeroPatente");

			if((nome != null)&&(cognome != null)&&(email != null)&&(password != null) && (dataDiNascita != null)&&(codiceFiscale != null)&&(numeroPatente != null)){


				List<Cliente> lista = Database.getInstance().getListaClienti();

				for(Cliente elementoClienteSingolo : lista) {

					if(!(elementoClienteSingolo.getEmail()).equals(email)){



						Cliente c = new Cliente();

						c.setNome(nome);
						c.setCognome(cognome);
						c.setEmail(email);
						c.setPassword(password);
						c.setDataDiNascita(dataDiNascita);
						c.setCodiceFiscale(codiceFiscale);
						c.setNumeroPatente(numeroPatente);

						request.setAttribute("cliente", c);
						request.getServletContext().getNamedDispatcher("aggiungiclienti").include(request, response);
						System.out.println("ok cliente aggiunto");

					}else {
						System.out.println("Cliente gi� registrato");
					}

				}
			}

			doGet(request,response);

			//utente (dipendente)

		}else if(id.equals(ut)){

			String nomeU = request.getParameter("nome");
			String cognomeU =  request.getParameter("cognome");
			String emailU =  request.getParameter("mail");
			String passwordU =  request.getParameter("password");
			String dataDiNascitaU = request.getParameter("dataDiNascita"); 
			String codiceFiscaleU = request.getParameter("codiceFiscale");


			if((nomeU != null)&&(cognomeU != null)&&(emailU != null)&&(passwordU != null) && (dataDiNascitaU != null)&&(codiceFiscaleU != null)){

				List<Utente> lista = Database.getInstance().getListaUtenti();

				for(Utente elementoUtenteSingolo : lista) {

					if(!(elementoUtenteSingolo.getEmail()).equals(emailU)){ 

						Utente u = new Utente();

						u.setNome(nomeU);
						u.setCognome(cognomeU);
						u.setEmail(emailU);
						u.setPassword(passwordU);
						u.setDataDiNascita(dataDiNascitaU);
						u.setCodiceFiscale(codiceFiscaleU);

						request.setAttribute("utente", u);
						request.getServletContext().getNamedDispatcher("aggiungiutenti").include(request, response);
						System.out.println("ok utente aggiunto");

					}
					else {
						System.out.println("Cliente gi� registrato");
					}
				}
			}else {
				System.out.println("Completare i campi richiesti");
			}
		}
		
		doGet(request,response);

	}
}


