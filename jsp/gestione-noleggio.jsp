<%@page import="model.Noleggio"%>
<%
	List<Noleggio> listaNoleggi = (List<Noleggio>) request.getAttribute("Noleggi_lista");
	List<Noleggio> storicoNoleggi = (List<Noleggio>) request.getAttribute("storico_noleggi");
%>

<%@page import="java.util.List"%>

<div class="min-h">
<div id="accordion" class="pagineDiv">
	<div class="card">
		<div class="card-header">
			<h5 class=" testo mb-1">Noleggi in corso</h5>
		</div>
		<div class="card-body">
		<% if(!listaNoleggi.isEmpty()) { %>
			<table class="table table-unruled tableGestione">
				<thead >
					<tr>
						<th scope="col"></th>
						<th scope="col">Cliente</th>
						<th scope="col">Veicolo</th>
						<th scope="col">Inizio noleggio</th>
						<th scope="col">Fine noleggio</th>
						<th scope="col">Interrompi noleggio</th>

					</tr>
				</thead>
				<tbody class="text-center">

					<%
							for (Noleggio n : listaNoleggi) {
					%>
					<tr>
						<th class="mezzo"><%=(listaNoleggi.indexOf(n) + 1)%></th>
						<td><%=n.getCliente().getNome() + " " + n.getCliente().getCognome()%></td>
						<td><%=n.getAuto().getModello() + " " + n.getAuto().getMarca()%></td>
						<td><%=n.getDataInizio()%></td>
						<td><%=n.getDataFine()%></td>
						<td><a
							href="interrompinoleggiate?stato=2&idNoleggio=<%=n.getIdNoleggio()%>"
							type="button" >Interrompi</a></td>

						<td style="padding: 0px"><a href="jsp/gestione"></a></td>
					</tr>
		<%
					}
						}
		else if(listaNoleggi.isEmpty()){
				%>

					<tr id="inCorso">
						<div class="alert alert-warning" role="alert" style="text-align: center"> Nessun noleggio in corso </div>
					</tr>
					<script>
				    	$('#inCorso').css("display", "none");
				    	</script>
		<%} %>
			</tbody>
			</table>
		</div>
		<div class="card">
			<div class="card-header">
				<h5 class="testo mb-1">Storico noleggi</h5>
			</div>
			<div class="card-body">
			<% if(!storicoNoleggi.isEmpty()) { %>
				<!--////////////////////////////////////////// storico cliente  -->
				<table class="table table-unruled tableGestione">
					<thead class="text-center">
						<tr>
							<th scope="col"></th>
							<th scope="col">Cliente</th>
							<th scope="col">Veicolo</th>
							<th scope="col">Inizio noleggio</th>
							<th scope="col">Fine noleggio</th>
							<th scope="col"></th>

						</tr>
					</thead>
					<tbody class="text-center">

						<%
								for (Noleggio n : storicoNoleggi) {
						%>
					
						<tr>
							<td><%=(storicoNoleggi.indexOf(n) + 1)%></td>
							<td><%=n.getCliente().getNome() + " " + n.getCliente().getCognome()%></td>
							<td><%=n.getAuto().getModello() + " " + n.getAuto().getMarca()%></td>
							<td><%=n.getDataInizio()%></td>
							<td><%=n.getDataFine()%></td>
							<td><%=n.getStato()==2 ? "Interrotto" : ""%></td>

						</tr>
					<%
					}
						}
		else if(storicoNoleggi.isEmpty()){
				%>

					<tr id="storico">
						<div class="alert alert-warning" role="alert" style="text-align: center"> Nessun noleggio</div>
					</tr>
					<script>
				    	$('#storico').css("display", "none");
				    	</script>
				<%
					}

				%>
				</tbody>	
				</table>
			</div>
		</div>
	</div>
</div>
	</div>


					

