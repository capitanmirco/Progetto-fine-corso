<div class="blue" id="header" align="center" style="">NOME
	SITO/LOGO</div>
<%
	//session.setAttribute("cliente", "ciao");
//	session.setAttribute("utente", "ciao");
%>

<nav class="navbar navbar-inverse">
	<ul class="nav blue navbar-nav">
		<li><a href="home">Home</a></li>
		<li><a href="catalogo">Catalogo</a></li>

		<%
			if (session.getAttribute("cliente") != null || session.getAttribute("email_admin") != null
					|| session.getAttribute("utente") != null) {
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
						if (session.getAttribute("cliente") != null || session.getAttribute("utente") != null) {
					%>
					<a class="dropdown-item" href="#">I miei dati</a>
					<%
						}
						if (session.getAttribute("cliente") != null)
						{
					%>
					<a class="dropdown-item" href="#">I miei noleggi</a>
					<%
						}
						if (session.getAttribute("email_admin") != null
								|| session.getAttribute("utente") != null) {
					%>

					<a class="dropdown-item" href="#">Noleggi clienti</a> 
					
					
					
					<a class="dropdown-item" href="#">Gestione clienti</a> 
					<% } %>
					<a class="dropdown-item" href="#">Logout</a>
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

