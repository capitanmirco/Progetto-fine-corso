
<%@page import="model.Noleggio"%>
<%
	request.getAttribute("Noleggi_lista");
%>

<%@page import="java.util.List"%>
<div class="madre">
	<div class="table-noleggio">
		<table class="table">
			<thead class="table">
				<tr>
					<th scope="col" ></th>
					<th scope="col">Cliente</th>
					<th scope="col">Veicolo</th>
					<th scope="col">Inizio noleggio</th>
					<th scope="col">Fine noleggio</th>
					<th scope="col">Interrompi noleggio</th>
					
				</tr>
			</thead>
			<tbody class="table">
			
				<%
					List<Noleggio> listaNoleggi = (List<Noleggio>) request.getAttribute("Noleggi_lista");
					if (listaNoleggi != null) {
						for (Noleggio n : listaNoleggi) {
				%>

				<tr>
					<th scope="row"><%=(listaNoleggi.indexOf(n)+1) %></th>
					<td><%=n.getCliente().getNome()+" "+n.getCliente().getCognome()%></td>
					<td><%=n.getAuto().getModello()+" "+n.getAuto().getMarca()%></td>
					<td><%=n.getDataInizio()%></td>
					<td><%=n.getDataFine()%></td>
					<td><a href="interrompinoleggiate?stato=2&idNoleggio=<%=n.getIdNoleggio()%>"
						type="button" class="bottone">Interrompi</a></td>

					<td><a href="jsp/gestione"></a></td>

					<%
						}
						}
					%>
				</tr>
			</tbody>
			</table>
			<!--////////////////////////////////////////// storico cliente  -->
			<table class="table">
				<thead>
					<tr>
						<th scope="col"></th>
						<th scope="col">Cilente</th>
						<th scope="col">Veicolo</th>
						<th scope="col">Inizio noleggio</th>
						<th scope="col">Fine noleggio</th>
						
					</tr>
				</thead>
				<tbody>
					<%
					
				     
				    List<Noleggio> storicoNoleggi = (List<Noleggio>) request.getAttribute("storico_noleggi");
					if (storicoNoleggi != null) {
						for (Noleggio n : storicoNoleggi) {
				%>

					<tr>
						<th scope="row"><%=(storicoNoleggi.indexOf(n)+1) %></th>
						<td>><%=n.getCliente().getNome()+" "+n.getCliente().getCognome()%></td>
						<td><%=n.getAuto().getModello()+" "+n.getAuto().getMarca()%></td>
						<td><%=n.getDataInizio()%></td>
						<td><%=n.getDataFine()%></td>
						
                          


						<%
						}
						}
				        
					%>
					</tr>
				</tbody>
				</table>
				</div>
				</div>
