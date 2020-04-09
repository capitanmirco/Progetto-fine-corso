<div class="blue" id="header" align="center" style="">NOME
	SITO/LOGO</div>
<%
%>

<nav class="navbar navbar-inverse">
	<ul class="nav blue navbar-nav">
		<li><a href="home">Home</a></li>
		<li><a href="catalogo">Catalogo</a></li>

		<%
			if (request.getSession().getAttribute("cliente") != null || 
				request.getSession().getAttribute("email_admin") != null
					|| request.getSession().getAttribute("utente") != null) {
		%>
		<li>
			<div class="dropdown">
				<button class="btn btn-secondary blue dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					<a>Area Personale</a>
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<%
						if (request.getSession().getAttribute("cliente") != null || 
								request.getSession().getAttribute("utente") != null) {
					%>
					<a class="dropdown-item" href="visualizzadati">I miei dati</a>
					<%
						}
						if (request.getSession().getAttribute("cliente") != null)
						{
					%>
					<a class="dropdown-item" href="listanoleggi">I miei noleggi</a>
					<%
						}
						if (request.getSession().getAttribute("utente") != null)
						{
					%>
					<a class="dropdown-item" href="gestione">Gestione clienti</a>
					<%
						}
						if (request.getSession().getAttribute("email_admin") != null
								|| request.getSession().getAttribute("utente") != null) {
					%>

					<a class="dropdown-item" href="listanoleggi">Noleggi clienti</a> 
					
				
					<%
						}
						if (request.getSession().getAttribute("email_admin") != null) {
					%>
					
					<a class="dropdown-item" href="gestionepersona">Gestione Clienti e Utenti</a> 
					
					<% } %>
					
					<a class="dropdown-item" href="logout">Logout</a>
				</div>
			</div>
		</li>

		<!--   <li><a href="areapersonale">Area Personale</a></li> -->


		<%
			} else {
		%>
		<li id="login">
			<form method=POST action="login">
				<div id="loginForm">
					<div style="margin-right: 10px;">
						E-mail <input type="email" name="email" class="loginInput"
							id="email">
					</div>
					<div>
						Password <input type="password" name="password" class="loginInput"
							id="password">
					</div>
				</div>
				<div style="float: right">
					<a href="registrazione">Registrati.</a> 
					<input
						class="bottoni bottone" id="loginButton" type="submit"
						value="Login">
				</div>
			</form>
		</li>

		<%
			}
		%>
	</ul>

</nav>

