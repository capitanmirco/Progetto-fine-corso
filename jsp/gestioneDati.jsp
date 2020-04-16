<%@page import="model.Utente"%>
<%@page import="model.Cliente"%>
<br><br><br><br><br>
<% 	Cliente c=(Cliente)request.getAttribute("cliente");  
	Utente u=(Utente)request.getAttribute("utente");
%>
<div class="min-h">
<div class="madre">
	<div class="table-noleggio">
		
		<h3 style="text-align:left"> I miei dati </h3>
		
		<table class="table">
				<% if(c!=null){ %>
					<tr><td>Nome Cognome</td><td><%=c.getNome()+" "+c.getCognome()%></td></tr>
					<tr><td>Data di nascita</td><td><%=c.getDataDiNascita()%></td></tr>
					<tr><td>Email</td><td><%=c.getEmail()%></td></tr>
					<tr><td>Codice Fiscale</td><td><%=c.getCodiceFiscale()%></td></tr>
					<tr><td>Patente</td><td><%=c.getNumeroPatente()%></td></tr>
					<td><a href="modificadati" type="button" class="bottone">Modifica</a></td>
					<td><a type="button" class="bottone" href="rimuovicliente?remove=<%=c.getIdCliente()%>">Elimina</a></td>
					
				<%} %>
				
				<% if(u!=null){ %>
					<tr><td>Nome Cognome</td><td><%=u.getNome()+" "+u.getCognome()%></td></tr>
					<tr><td>Data di nascita</td><td><%=u.getDataDiNascita()%></td></tr>
					<tr><td>Email</td><td><%=u.getEmail()%></td></tr>
					<tr><td>Codice Fiscale</td><td><%=u.getCodiceFiscale()%></td></tr>
					<td><a href="modificadati" type="button" class="bottone">Modifica</a></td>
					<td><a type="button" class="bottone" href="rimuoviutenti?remove=<%=u.getIdUtente()%>">Elimina</a></td>
				<%} %>
		</table>
	</div>
</div>
	</div>
