<%@page import="model.Cliente"%>
<%@page import="model.Utente"%>
<br>
<br>
<br>
<br>
<%
Utente u=(Utente)request.getAttribute("utente"); 
Cliente c=(Cliente)request.getAttribute("cliente");
%>

<%@page import="java.util.List"%>
<div class="madre">
	<div class="table-noleggio">
		<table class="table">
			<thead class="table">
				<tr>
					<th scope="col" ></th>
					<th scope="col">Nome Cognome</th>
					<th scope="col">Data di Nascita</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Codice Fiscale</th>
				<%if(c!= null){%> <th scope="col">Numero Patente</th>			<%} %>
				</tr>
			</thead>
			<tbody class="table">
			<%
			if(c !=null){
				
			%>
				<tr>
					<th scope="row"></th>
					<td><%=c.getNome()+" "+c.getCognome()%></td>
					<td><%=c.getDataDiNascita()%></td>
					<td><%=c.getEmail()%></td>
					<td><%=c.getPassword()%></td>
					<td><%=c.getCodiceFiscale()%></td>
					<td><%=c.getNumeroPatente()%></td>
					
								
				<%
			}	else if(u != null){
				
				%>	
				<tr>
					<th scope="row"></th>
					<td><%=u.getNome()+" "+u.getCognome()%></td>
					<td><%=u.getDataDiNascita()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getPassword()%></td>
					<td><%=u.getCodiceFiscale()%></td>
		
		<%
				
				
			}
			
			
			%>
			
			
			
			
			
			
			
			
				</table>
					<div>
					<a href="/modificaDati"
						type="button" class="bottone">Modifica</a>

				</div>
				<div>
				<%if (u != null){ %>	<a href="rimuoviUtenti" <% }else if(c != null){ %>
				<a href="rimuoviClienti"></a>
				<%} %>
						type="button" class="bottone">Elimina</a>

				</div>
				
				</div>
				</div>
				
				
				
				
				
				
				
				
				
				
