
<%@page import="model.Noleggio"%>
<%
	request.getAttribute("Noleggi_lista");
%>

<%@page import="java.util.List"%>
<div class="madre">
	<div class="table-noleggio">
		<table class="table">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">Utente</th>
					<th scope="col">Veicolo</th>
					<th scope="col">Inizio noleggio</th>
					<th scope="col">Fine noleggio</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Noleggio> listaNoleggi = (List<Noleggio>) request.getAttribute("Noleggi_lista");
					if (listaNoleggi != null) {
						for (Noleggio n : listaNoleggi) {
				%>

				<tr>
					<th scope="row">1</th>
					<td><%=n.getCliente()%></td>
					<td><%=n.getAuto().getModello()%> <%=n.getAuto().getMarca()%></td>
					<td><%=n.getDataInizio()%></td>
					<td><%=n.getDataFine()%></td>
					<td><a href="rimuoviauto?remove=<%=n.getAuto().getIdAuto()%>" 
					 type="button" class="bottone">Interrompi</a>
				    </td>
					<%
						}
						}
					%>
				</tr>

				</div>
				</div>
