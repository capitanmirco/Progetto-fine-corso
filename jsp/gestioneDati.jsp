<%@page import="model.Cliente"%>
<%@page import="model.Utente"%>
<%
Utente u=(Utente)session.getAttribute("Utente"); 
Cliente c=(Cliente)session.getAttribute("Cliente");
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
					<th scope="col">Patente</th>					
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
					<td><%=c.getEmail()%></td>
					<td><%=c.getEmail()%></td>
					<td><%=c.getEmail()%></td>
					
								
				<%
			}	else if(u != null){
				
				%>	
				<tr>
					<th scope="row"></th>
					<td><%=u.getNome()+" "+u.getCognome()%></td>
					<td><%=u.getDataDiNascita()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getPassword()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getEmail()%></td>
		
		<%
				
				
			}
			
			
			%>			
				</table>
					<div>
					<a href="registrazione"
						type="button" class="bottone">Modifica</a>

				</div>
				<div>
					<a href="home"
						type="button" class="bottone">Elimina</a>

				</div>
				
				</div>
				</div>
				
				
