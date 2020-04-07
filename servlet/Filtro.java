package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import model.Auto;
import model.Categoria;
import model.Noleggio;

/**
 * Servlet implementation class Filtro
 */
@WebServlet(name="filtro", urlPatterns = {"/filtro"})
public class Filtro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Auto> listaAuto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filtro() {
        super();
    }

    /*filtro per categoria e filtro per data*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* ***************************************filtro categoria **************************************************** */
		if(request.getParameter("filtro_categoria")!=null) {
			boolean isNumericId = isNumericId(request.getParameter("filtro_categoria"));
			
			if(isNumericId) {
				int categoria = Integer.parseInt(request.getParameter("filtro_categoria"));
				listaAuto = Database.getInstance().getAutoDisponibili();
				Categoria c = Database.getInstance().getCategoriaById(categoria);

				for(int i=0;i<listaAuto.size();i++) {
					if(!isEqual(listaAuto.get(i).getCategoria(), c)) {
						listaAuto.remove(i);
					}
				}
				/*passa alla requst la lista auto già filtrata per categoria*/
				request.setAttribute("listaAuto", listaAuto);
				
			}else {
				request.setAttribute("errore", true);
			}
		}/*if filtro categoria*/
		
		
		/* ***************************************filtro data **************************************************** */
		if(request.getParameter("data_inizio")!=null && request.getParameter("data_fine")!=null &&
				isNumericId(request.getParameter("data_inizio")) && isNumericId(request.getParameter("data_fine"))) {
			
			/*filtro veicoli per data*/
			if(request.getAttribute("listaAuto")==null) {
				listaAuto = Database.getInstance().getListaAuto();
			}else {
				listaAuto = (List<Auto>) request.getAttribute("listaAuto");
			}
			
			try {
				isAutoLibera(listaAuto, request.getParameter("data_inizio"), request.getParameter("data_fine"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("filtro_data", listaAuto);

		}
		
	}/*doGet*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	/*restituisce true se i nomi delle categorie sono uguali*/
	private boolean isEqual(Categoria c1, Categoria c2) {
		boolean equal = false;
		if(c1.getNome().equals(c2.getNome())) {
			equal=true;
		}
		return equal;
	}
	
	/*restituisce true se il parametro passato e' numerico*/
	private boolean isNumericId(String s) {
		boolean isNumericId=false;
		String[] ggmmaaaaa = s.trim().split("-");
		for(String s1 : ggmmaaaaa) {
			for(int i=0;i<s1.length();i++) {				
				if(s.charAt(i) >= 48 && s.charAt(i)<= 57) {
					isNumericId=true;
				}else {
					isNumericId=false;
					break;
				}
			}
		}
		return isNumericId;
	}
	
	/*restituisce tutte le auto che non sono già noleggiate -- 0 = prenotata -- 1 = prenotabile*/
	private List<Auto> isAutoLibera(List<Auto> listaAuto, String data_inizio, String data_fine) throws ParseException {
		Date startData = stringToData(data_inizio);
		Date endData = stringToData(data_fine);
		List<Auto> listaFiltrata = new ArrayList<Auto>();
		for(Auto a : listaAuto) {
			if(a.getDisponibilita() == 1){
				listaFiltrata.add(a);
			}else if(a.getDisponibilita() == 0) {
				List<Noleggio> listaNoleggio = Database.getInstance().getListaNoleggi();
				for(Noleggio n : listaNoleggio) {
					if(n.getAuto().getIdAuto() == a.getIdAuto() && n.getStato()==0) {
						/*>0 data 1 dopo data2 -- <0 data 1 prima di data2 -- = data 1 e data 2 uguali*/
						if(endData.compareTo(stringToData(n.getDataInizio()))<0 || startData.compareTo(stringToData(n.getDataFine()))>0) {
							listaFiltrata.add(a);
						}
					}
				}
			}
		}
		return listaFiltrata;
	}
	
	/*converte una stringa in data*/
	private Date stringToData(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = formatter.parse(data);
		return date;
	}
	
	

}
