<%@page import="model.Cliente"%>
<%@page import="model.Utente"%>
<%@page import="java.util.List"%>
<%

	String[] numeri = null;
	String[] titoli = null;
	int[] nRuoli = null;
	String[] nomiAttr = null;
	int[] nBottoni = null;
	
	
	if(request.getSession().getAttribute("email_admin") != null)
	{
		numeri = new String[]{"One", "Two", "Three", "Four", "Five"};
		titoli = new String[]{"Utenti e Clienti da validare", "Lista Clienti", "Lista Utenti", "Clienti Rimossi", "Utenti Rimossi"};
		nomiAttr = new String[]{"NonValidati", "Validati", "Validati", "Cancellati", "Cancellati"};
		nRuoli = new int[]{3, 1, 2, 1, 2}; // 3 entrambi, 2 utenti, 1 clienti
		//nomiBottoni = new String[]{"Elimina Approva", "Elimina Storico", "Elimina", "Ripristina Storico", "Ripristina"};
									
		nBottoni = new int[] {3, 4, 1, 5, 2};
		// 1 Elimina 2 Ripristina  3 Elimina e Approva 4 Elimina e Storico 5 Ripristina e Storico
	} 
	else if (request.getSession().getAttribute("utente") != null)
	{
		numeri = new String[]{"One"};
		titoli = new String[]{"Lista Clienti"};
		nRuoli = new int[]{1};
		nomiAttr = new String[]{"Validati"};
		nBottoni = new int[]{4};
	}
	%>
	
	
<div id="accordion" class="pagineDiv">


	<% for(int i=0; i<numeri.length; i++){ %>
	<div class="card">
		<div class="card-header" id="heading<%=numeri[i]%>">
			<h5 class="mb-0">
				<button class="btn btn-link" data-toggle="collapse"
					data-target="#collapse<%=numeri[i]%>" aria-expanded="true"
					aria-controls="collapse<%=numeri[i]%>"><%=titoli[i]%>
				</button>
			</h5>
		</div>

		<div id="collapse<%=numeri[i]%>" class="collapse <%=i==0 ? "show" : ""%>" aria-labelledby="heading<%=numeri[i]%>" data-parent="#accordionExample">
			<div class="card-body">

				<table class="table mt-3" border=1>
					<thead class="thead-dark text-center">
						<tr>
							<th scope="col">Ruolo</th>
							<th scope="col">Nome</th>
							<th scope="col">Cognome</th>
							<th scope="col">Email</th>
							<th scope="col">Password</th>
							<th scope="col">Data di nascita</th>
							<th scope="col">Codice fiscale</th>
							<th scope="col">Numero Patente</th>
							<th scope="col"></th>
						</tr>
					</thead>
					
					<tbody class="text-center">
			
			
			
					<%
					if (nRuoli[i]==2 || nRuoli[i]==3)
					{
						
					String nomeAttr = "listaUtenti"+nomiAttr[i];
					List<Utente> listaUtenti = (List<Utente>) request.getAttribute(nomeAttr);
				
			  		for(Utente u : listaUtenti){
			  		 %>
						<tr>
							<th scope="row">Utente</th>
							<td><%=u.getNome()%></td>
							<td><%=u.getCognome()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getPassword()%></td>
							<td><%=u.getDataDiNascita()%></td>
						 	<td><%=u.getCodiceFiscale()%></td>
							<td> - </td>
							<td> <% // 1 Elimina 2 Ripristina  3 Elimina e Approva 4 Elimina e Storico 5 Ripristina e Storico
								switch(nBottoni[i]) 
								{
								case 1: %>
									<a type="button" href="rimuoviutenti?remove=<%=u.getIdUtente()%>">Elimina</a>
									<% break; 
								case 2: %>
									<a type="button" href="ripristinapersona?ripristinautente=<%=u.getIdUtente()%>">Ripristina</a>
									<% break;
								case 3: %>
									<a type="button" href="validautenti?valida=1&id=<%=u.getIdUtente()%>">Approva</a>
									<a type="button" href="rimuoviutenti?remove=<%=u.getIdUtente()%>">Elimina</a>
									<% break; 
								case 4: %>
									<a type="button" href="rimuoviutenti?remove=<%=u.getIdUtente()%>">Elimina</a>
									<% break; 
								case 5: %>
									<a type="button" href="ripristinapersona?ripristinautente=<%=u.getIdUtente()%>">Ripristina</a>
									<% break;
								 } %>
						 	</td>
						</tr>
					<% } 
					}
			  		
			  		
					if(nRuoli[i]==1 || nRuoli[i]==3){
						String nomeAttr2 = "listaClienti"+nomiAttr[i];
						List<Cliente> listaClienti = (List<Cliente>) request.getAttribute(nomeAttr2);
					
						for(Cliente c :  listaClienti){  %>
						<tr>
							<th scope="row">
								Cliente
							</th>
							<td><%=c.getNome()%></td>
							<td><%=c.getCognome()%></td>
							<td><%=c.getEmail()%></td>
							<td><%=c.getPassword()%></td>
							<td><%=c.getDataDiNascita()%></td>
							<td><%=c.getCodiceFiscale()%></td>
							<td><%=c.getNumeroPatente()%></td>
							<td>
								<% 	// 1 Elimina 2 Ripristina  3 Elimina e Approva 4 Elimina e Storico 5 Ripristina e Storico
								switch(nBottoni[i]) 
								{
								case 1: %>
									<a type="button" href="rimuovicliente?remove=<%=c.getIdCliente()%>">Elimina</a>
									<% break; 
								case 2: %>
									<a type="button" href="ripristinapersona?ripristinacliente=<%=c.getIdCliente()%>">Ripristina</a>
									<% break;
								case 3: %>
									<a type="button" href="validacliente?valida=1&id=<%=c.getIdCliente()%>">Approva</a>
									<a type="button" href="rimuovicliente?remove=<%=c.getIdCliente()%>">Elimina</a>
									<% break; 
								case 4: %>
									<a type="button" href="rimuovicliente?remove=<%=c.getIdCliente()%>">Elimina</a>
									<a type="button" href="listanoleggi?idstorico=<%=c.getIdCliente()%>">Storico</a>
									<% break; 
								case 5: %>
									<a type="button" href="ripristinapersona?ripristinacliente=<%=c.getIdCliente()%>">Ripristina</a>
									<a type="button" href="listanoleggi?idstorico=<%=c.getIdCliente()%>">Storico</a>
									<% break;
								 } %>
						 	</td>
	
						</tr>
						<% } }%>
	
					</tbody>
				</table>

			</div>
		</div>
	</div>
	
	<% } %>
</div>

	
