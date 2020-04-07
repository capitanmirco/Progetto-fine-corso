package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Cliente;

@WebServlet(name="aggiungiclienti", urlPatterns= {"/aggiungiclienti"})
public class AggiungiClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AggiungiClienti() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente c = (Cliente) request.getAttribute("cliente");
		Database.getInstance().addCliente(c);
	}

}
