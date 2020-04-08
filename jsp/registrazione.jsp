
	<form action="registrazione" method="POST">

		<div class="container registra">
			<div>
				<label id="registratilbl"> Registrati come:</label> <br> <input type="radio"
					onclick="mostraPatente('utente')" name="options" id="option1">
				Utente <input type="radio" onclick="mostraPatente('cliente')"
					name="options" id="option2"> Cliente
			</div>
			<br>
			<div class="form-group">
				<label for="exampleInputNome">Nome</label> <input type="text"
					class="form-control" name=nome id="exampleInputNome">
			</div>
			<div class="form-group">
				<label for="exampleInputCognome">Cognome</label> <input type="text"
					class="form-control" name=cognome id="exampleInputCognome">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail">Email</label> <input type="email"
					class="form-control" neme=email id="exampleInputEmail1"
					aria-describedby="emailHelp"> <small id="emailHelp"
					class="form-text text-muted"></small>
			</div>
			<div class="form-group">
				<label for="exampleInputDataDiNascita">Data di nascita</label> <input
					type="dates" class="form-control" name=datadinascita
					id="exampleInputDataDiNascita">
			</div>
			<div class="form-group">
				<label for="exampleInputCodiceFiscale">Codice Fiscale</label> <input
					type="text" class="form-control" name=codicefiscale
					id="exampleInputCodiceFiscale">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword">Password</label> <input
					type="password" class="form-control" name=password
					id="exampleInputPassword">
			</div>
			<div class="form-group" id="patente">
				<label for="exampleInputNumeroPatente">Numero patente</label> <input
					type="text" class="form-control" name=numeropatente
					id="exampleInputNumeroPatente">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
      
	

