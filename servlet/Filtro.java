package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet("/filtro")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/* ***************************************filtro categoria **************************************************** */
		/* 1 = citycar // 2 = suv // 3 = auto di lusso */
		if(request.getParameter("auto")!=null) {
			boolean isNumericId = isNumericId(request.getParameter("auto"));
			
			if(isNumericId) {
				int categoria = Integer.parseInt(request.getParameter("auto"));
				request.setAttribute("categoria", categoria);
				listaAuto = Database.getInstance().getAutoDisponibili();
				Categoria c = Database.getInstance().getCategoriaById(categoria);

				for(int i=0;i<listaAuto.size();i++) {
					if(!isEqual(listaAuto.get(i).getCategoria(), c)) {
						listaAuto.remove(i);
						if(i!=0) {
							i=0;
						}else {
							i--;
						}
					}
				}
				/*passa alla requst la lista auto giÃ  filtrata per categoria*/
				request.setAttribute("listaAuto", listaAuto);
				
				
				//da cancellare
				for(Auto a : listaAuto ) {
					System.out.println("filtro categoria " + a.getMarca());
				}
				
			}else {
				request.setAttribute("errore", true);
			}
		}/*if filtro categoria*/
		
		
		/* ***************************************filtro data **************************************************** */
		if(request.getParameter("inizioNolo")!=null && request.getParameter("fineNolo")!=null &&
				isNumericId(request.getParameter("inizioNolo")) && isNumericId(request.getParameter("fineNolo"))) {
			
			/*filtro veicoli per data*/
			if(request.getAttribute("listaAuto")==null) {
				listaAuto = Database.getInstance().getListaAuto();
			}else {
				listaAuto = (List<Auto>) request.getAttribute("listaAuto");
			}
			
			try {
				isAutoLibera(listaAuto, request.getParameter("inizioNolo"), request.getParameter("fineNolo"), Integer.parseInt(request.getParameter("auto")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//da cancellare
			for(Auto a : listaAuto ) {
				System.out.println("filtro data " + a.getMarca());
			}
			
			request.setAttribute("listaAuto", listaAuto);

		}
		
		/*controllo validitÃ  date*/
		try {
			if(request.getParameter("inizioNolo")!=null && request.getParameter("fineNolo")!=null &&
					compareDate(request.getParameter("inizioNolo"), request.getParameter("fineNolo"))) {
				System.out.println("date sbagliate");
				response.sendRedirect("home");
			}else {
				request.getServletContext().getNamedDispatcher("catalogo").forward(request, response);
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
	}/*doPost*/

	
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
	
	/*restituisce tutte le auto che non sono giÃ  noleggiate -- 0 = prenotata -- 1 = prenotabile*/
	private void isAutoLibera(List<Auto> listaAuto, String data_inizio, String data_fine, int categoria) throws ParseException {
		Date startData = stringToData(data_inizio);
		Date endData = stringToData(data_fine);
		List<Auto> listaFiltrata = Database.getInstance().getListaAuto();
		for(int i=0;i<listaFiltrata.size();i++) {
			if(listaFiltrata.get(i).getDisponibilita() == 0) {
				List<Noleggio> listaNoleggio = Database.getInstance().getListaNoleggi();
				for(Noleggio n : listaNoleggio) {
					/*noleggio :  0 = terminato / 1 = in corso / 2 = interrotto*/
					if(n.getAuto().getIdAuto() == listaFiltrata.get(i).getIdAuto() && n.getStato()==1 && listaFiltrata.get(i).getCategoria().getIdCategoria() == categoria) {
						/*>0 data 1 dopo data2 -- <0 data 1 prima di data2 -- = data 1 e data 2 uguali*/
						if((startData.compareTo(stringToData(n.getDataInizio()))<0 && endData.compareTo(stringToData(n.getDataInizio()))<0) 
								|| (startData.compareTo(stringToData(n.getDataFine()))>0 && endData.compareTo(stringToData(n.getDataFine()))>0)) {
							if(!listaAuto.contains(listaFiltrata.get(i))) {
								//System.out.println("aggiungi "+listaFiltrata.get(i).getMarca());
								listaAuto.add(listaFiltrata.get(i));
							}
						}else {
								//System.out.println("rimuovi "+listaFiltrata.get(i).getMarca());
								listaAuto.remove(listaFiltrata.get(i));
								listaFiltrata.remove(i);
								if(i == 0) {
									i=0;
								}else {
									i--;
								}
						}
					}

				}
			}
		}
	}
	
	/*converte una stringa in data*/
	private Date stringToData(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(data);
		return date;
	}
	
	private boolean compareDate(String dataInizio, String dataFine) throws ParseException {
		boolean check = false;
		Date data1 = stringToData(dataInizio);
		Date data2 = stringToData(dataFine);
		/*>0 data 1 dopo data2 -- <0 data 1 prima di data2 -- = data 1 e data 2 uguali*/
		if(data1.compareTo(data2)>0) {
			check  = true;
		}
		return check;
	}

}
