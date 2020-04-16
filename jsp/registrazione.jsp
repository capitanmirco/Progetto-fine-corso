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
		<div class="container registra">
			<form method="post" name="myForm" id="form" action="registrazione">
			
			
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
					<button type="submit" class="bottone" id="bottoner"> 
						<%if(c ==null && u ==null) {
    	    				out.print("Registra");
        				} else {
	        				out.print("Modifica");
        				} %> </button>
				</div>
		</form>
	</div>
	
	<script>
	
		document.getElementById('form').addEventListener('submit', function(e) {
		e.preventDefault();
		var password = document.getElementById('exampleInputPassword');
		var cPassword = document.getElementById('exampleInputConfermaPassword');
		
		if(password.value != cPassword.value){
			alert('Le password non coincidono');
			
		} else {
			return true;

		}
	});</script>
