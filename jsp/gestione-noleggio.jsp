<%@page import="model.Noleggio"%>
<%
	request.getAttribute("Noleggi_lista");
%>

<%@page import="java.util.List"%>


<div id="accordion" class="pagineDiv">
	<div class="card">
		<div class="card-header">
			<h5 class=" testo mb-1"">Noleggi in corso</h5>
		</div>
		<div class="card-body">
			<table class="table table-unruled tableGestione">
				<thead class="text-center">
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
						List<Noleggio> listaNoleggi = (List<Noleggio>) request.getAttribute("Noleggi_lista");
						if (listaNoleggi != null) {
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
							type="button" class="bottone">Interrompi</a></td>

						<td><a href="jsp/gestione"></a></td>
					</tr>
					<%
						}
						}
					%>




				</tbody>
			</table>
		</div>
		<div class="card">
			<div class="card-header">
				<h5 class="testo mb-1">Storico noleggi</h5>
			</div>
			<div class="card-body">
				<!--////////////////////////////////////////// storico cliente  -->
				<table class="table table-unruled tableGestione">
					<thead class="text-center">
						<tr>
							<th scope="col"></th>
							<th scope="col">Cliente</th>
							<th scope="col">Veicolo</th>
							<th scope="col">Inizio noleggio</th>
							<th scope="col">Fine noleggio</th>

						</tr>
					</thead>
					<tbody class="text-center">
						<%
							List<Noleggio> storicoNoleggi = (List<Noleggio>) request.getAttribute("storico_noleggi");
							if (storicoNoleggi != null) {
								for (Noleggio n : storicoNoleggi) {
						%>

						<tr>
							<td><%=(storicoNoleggi.indexOf(n) + 1)%></td>
							<td><%=n.getCliente().getNome() + " " + n.getCliente().getCognome()%></td>
							<td><%=n.getAuto().getModello() + " " + n.getAuto().getMarca()%></td>
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
	</div>
</div>
