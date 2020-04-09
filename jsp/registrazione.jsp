
	<div class="container registra">
			<form method="post">
				<div>
					<label id="registratilbl"> Registrati come: </label> <br> 
					Utente <input type="radio" onclick="mostraPatente('utente')" name="options" id="option">  
					Cliente <input type="radio" onclick="mostraPatente('cliente')" name="options" id="option">
				</div> <br>
			
				<div class="form-group">
					<label for="exampleInputNome"> Nome </label> 
					<input type="text" class="form-control" name="nome" id="exampleInputNome">
				</div>
			
				<div class="form-group">
					<label for=" exampleInputCognome"> Cognome </label> 
					<input type="text" class="form-control" name="cognome" id="exampleInputCognome">
				</div>
			
				<div class="form-group">
					<label for="exampleInputEmail"> Email </label> 
					<input type="email" class="form-control" name="email" id="exampleInputEmail"> 
				</div>
			
				<div class="form-group">
					<label for="exampleInputDataDiNascita"> Data di nascita </label> 
					<input type="date" class="form-control" name="datadinascita" id="exampleInputDataDiNascita">
				</div>
				
				<div class="form-group">
					<label for="exampleInputCodiceFiscale"> Codice Fiscale </label> 
					<input type="text" class="form-control" name="codicefiscale" id="exampleInputCodiceFiscale">
				</div>
			
				<div class="form-group">
					<label for="exampleInputPassword"> Password </label> 
					<input type="password" class="form-control" name="password" id="esempioInputPassword">
				</div>
			
				<div class="form-group" id="patente">
					<label for="exampleInputNumeroPatente"> Numero di patente </label> 
					<input type="text" class="form-control" name="numeropatente" id="exampleInputNumeroPatente">
				</div>
				
					<button type="submit" class="btn btn-primary"> Submit </button>
		</form>
	</div>
      
	

