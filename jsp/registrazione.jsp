<%@page import="model.Utente"%>
<%@page import="model.Cliente"%>

<%
	String nome, cognome, email, dataDiNascita, codiceFiscale, password, numeroDiPatente;
	Cliente c = null;
	Utente u = null;
	if(session.getAttribute("cliente") !=null){
		c = (Cliente) request.getSession().getAttribute("cliente");	
	}	
	else if(session.getAttribute("utente") != null ) {
    	u = (Utente) request.getSession().getAttribute("utente");
	}
%>
                 
<%@page import="model.Noleggio"%>
<%
	Noleggio n = (Noleggio) request.getAttribute("noleggio");
%>
<!--RIEPILOGO NOLEGGIO-->
<div class="min-h">
<div class="size-riepilogo">
	<div class="form">
		<table class="table">
			<thead>
				<tr>
              
					<th scope="col">Dati auto</th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<td><%=n.getAuto().getModello()+" "+n.getAuto().getMarca()%></td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<thead>
				<tr>

					<th scope="col">Inizio noleggio</th>
					<th scope="col">Fine noleggio</th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<td><%=n.getDataInizio()%></td>
					<td><%=n.getDataFine()%></td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<thead>
				<tr>

					<th scope="col">Prezzo finale</th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<td><%=n.getAuto().getCategoria().getPrezzo()%></td>
				</tr>
			</tbody>
		</table>
		<form>
			<div class="form-group">
				<label for="exampleInputEmail1">Numero Carta</label> <input
					type="number" id="input-carta" min="1000000000000000"
					max="9000000000000000" id="ccard" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"> <small
					id="emailHelp" class="form-text text-muted"></small>
			</div>
			<a type="button"
				href="pagamento?paga=p&dataInizio=<%=n.getDataInizio()%>&dataIFine=<%=n.getDataFine()%>&idAuto=<%=n.getAuto().getIdAuto()%>&idCliente=<%=n.getCliente().getIdCliente()%>"
				class="btn btn-primary" id="colore-bottone">Conferma</a>
		</form>
	</div>
	

	<div class="car-riepilogo">
		<div id="carouselExampleFade" class="carousel slide carousel-fade"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="https://iili.io/JnPsVV.jpg" class="d-block w-100"
						alt="immagine non trovata">
				</div>
				<div class="carousel-item">
					<img src="https://iili.io/JnLnn4.jpg" class="d-block w-100"
						alt="immagine non trovata">
				</div>
				<div class="carousel-item">
					<img src="https://iili.io/JCyqVs.jpg" class="d-block w-100"
						alt="immagine non trovata">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleFade"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Precedente</span>
			</a> <a class="carousel-control-next" href="#carouselExampleFade"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Prossima</span>
			</a>
		</div>


	</div>
	</div>
	
		<div class="container registra">
			<form method="post" name="myForm" action="registrazione"  id="form">
				<div class="form-group">
				
       			<% if(c == null && u == null){%>	
       				<label id="registratilbl"> Registrati come: </label> <br>
       				
       				<input type="radio" id="ut" name="ut_cl" value="ut" onclick="mostraPatente('utente')">
       				<label for="ut">Utente</label> &nbsp &nbsp
       		
		       		<input type="radio" id="cl" name="ut_cl" value="cl" onclick="mostraPatente('cliente')" checked="true">
       				<label for="cl">Cliente</label> &nbsp &nbsp
       			<%}%>
			</div> 
				<div class="form-group">
					<label for="exampleInputNome"> Nome </label> 
					<input type="text" class="form-control" name="nome" id="exampleInputNome" value="<%= nome= c!=null ? c.getNome(): u!=null? u.getNome():""%>">
				</div>
			
				<div class="form-group">
					<label for=" exampleInputCognome"> Cognome </label> 
					<input type="text" class="form-control" name="cognome" id="exampleInputCognome" value="<%= cognome= c!=null ? c.getCognome(): u!=null? u.getCognome():""%>">
				</div>
			
				<div class="form-group">
					<label for="exampleInputEmail"> Email </label> 
					<input type="email" class="form-control" name="email" id="exampleInputEmail" value="<%= email= c!=null ? c.getEmail(): u!=null? u.getEmail():""%>"> 
				</div>
			
				<div class="form-group">
					<label for="exampleInputDataDiNascita"> Data di nascita </label> 
					<input type="date" class="form-control" name="datadinascita" id="exampleInputDataDiNascita" value="<%= dataDiNascita= c!=null ? c.getDataDiNascita(): u!=null? u.getDataDiNascita():""%>">
				<% if ( request.getAttribute("erroredata")!=null)
				{  %>
					<p class="errore"> Devi essere maggiorenne per iscriverti. </p>
				<% }  %>
				
				</div>
				
				<div class="form-group">
					<label for="exampleInputCodiceFiscale"> Codice Fiscale </label> 
					<input type="text" class="form-control" name="codicefiscale" id="exampleInputCodiceFiscale" value="<%= codiceFiscale= c!=null ? c.getCodiceFiscale(): u!=null? u.getCodiceFiscale():""%>">
				</div>
			
				<div class="form-group">
					<label for="exampleInputPassword"> Password </label> 
					<input type="password" class="form-control" name="password" id="exampleInputPassword" value="<%= password= c!=null ? c.getPassword(): u!=null? u.getPassword():""%>">
				</div>
				
				<div class="form-group">
					<label for="exampleInputConfermaPassword"> Conferma password </label> 
					<input type="password" class="form-control" name="cPassword" id="exampleInputConfermaPassword">
				</div>
				
				
				<div class="form-group" id="patente">
				<% if(u == null || c != null) {%>
					<label for="exampleInputNumeroPatente"> Numero di patente </label> 
					<input type="text" class="form-control" name="numeropatente" id="exampleInputNumeroPatente" value="<%= numeroDiPatente= c!=null ? c.getNumeroPatente() :""%>">
				<%}%>	
				</div>
				
				<div id="btn-reg">
					<button type="submit" class="bottone" id="bottoner" onclick="controllo(event)"> 
						<%if(c ==null && u ==null) {
    	    				out.print("Registra");
        				} else {
	        				out.print("Modifica");
        				} %> </button>
				</div>
		</form>
	</div>
	</div>
	
	<script type="text/javascript">
	function controllo(event) {
		event.preventDefault();
		alert ('funziona');
		var password = document.getElementById('exampleInputPassword');
		var cPassword = document.getElementById('exampleInputConfermaPassword');
		
		if(password.value != cPassword.value){
			alert('Le password non coincidono');
			
		} else {
			alert('Le password coincidono');
			document.forms.myForm.submit();
		}
	}
</script>
