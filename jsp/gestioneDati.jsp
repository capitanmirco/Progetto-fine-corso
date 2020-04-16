<%@page import="model.Utente"%>
<%@page import="model.Cliente"%>

<% 	Cliente c=(Cliente)request.getAttribute("cliente");  
	Utente u=(Utente)request.getAttribute("utente");
%>

<div id="accordion" class="pagineDiv">
<div class="container">

		
		<div align="center">
		<table class="table table-unruled" style="width: 75%; float: right" >
		
				<% if(c!=null){ %>
					<tr><td colspan="2"> <h2> I miei dati </h2></td></tr>
					<tr><td>Nome Cognome</td><td><%=c.getNome()+" "+c.getCognome()%></td></tr>
					<tr><td>Data di nascita</td><td><%=c.getDataDiNascita()%></td></tr>
					<tr><td>Email</td><td><%=c.getEmail()%></td></tr>
					<tr><td>Codice Fiscale</td><td><%=c.getCodiceFiscale()%></td></tr>
					<tr><td>Patente</td><td><%=c.getNumeroPatente()%></td></tr>
					<tr><td><a href="modificadati" type="button" class="bottone">Modifica</a></td>
					<td><a type="button" class="bottone" href="rimuovicliente?remove=<%=c.getIdCliente()%>">Elimina</a></td></tr>
					
				<%} %>
				
				<% if(u!=null){ %>
					<tr><td>Nome Cognome</td><td><%=u.getNome()+" "+u.getCognome()%></td></tr>
					<tr><td>Data di nascita</td><td><%=u.getDataDiNascita()%></td></tr>
					<tr><td>Email</td><td><%=u.getEmail()%></td></tr>
					<tr><td>Codice Fiscale</td><td><%=u.getCodiceFiscale()%></td></tr>
					<tr><td><a href="modificadati" type="button" class="bottone">Modifica</a></td>
					<td><a type="button" class="bottone" href="rimuoviutenti?remove=<%=u.getIdUtente()%>">Elimina</a></td></tr>
				<%} %>
		</table>

</div>
</div>
</div>
	</div>
	

