package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Auto;
import model.Categoria;
import model.Cliente;
import model.Noleggio;


@WebServlet("/pagamento")
public class Pagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Pagamento() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idAuto=Integer.parseInt(request.getParameter("idAuto"));
		Auto a=Database.getInstance().getAutoById(idAuto);
		int idCliente=Integer.parseInt(request.getParameter("idCliente"));
		Cliente c=Database.getInstance().getClienteById(idCliente);
		
		if (request.getParameter("paga").equals("p")) {
			
			
			
			String dataInizio=request.getParameter("dataInizio");
			String dataFine=request.getParameter("dataFine");
			byte disp=0;
			a.setDisponibilita(disp);
			byte stato=1;
			int id=Integer.parseInt(request.getParameter("id"));
			Noleggio n=new Noleggio();
			n.setStato(stato);
			n.setCliente(c);
			n.setAuto(a);
			n.setDataInizio(dataInizio);
			n.setDataFine(dataFine);
			n.setIdNoleggio(id);
			Database.getInstance().addNoleggio(n);
			request.setAttribute("conferma", n);
			//dall'attribute create un alert con solo data inizio e fine
			request.getServletContext().getNamedDispatcher("home").forward(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
