<div class="blue" id="header" align="center" style=""> AutomotivElis </div>
<%
%>

<nav class="navbar navbar-inverse">
	<ul class="nav blue navbar-nav">
		<li><a href="home" class="aMenu">Home</a></li>
		<li><a href="catalogo" class="aMenu">Catalogo</a></li>
		
		<% 
			if (request.getSession().getAttribute("cliente") != null || 
				request.getSession().getAttribute("email_admin") != null
					|| request.getSession().getAttribute("utente") != null) {
		%>
		<li>
			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					<a class="aMenu">Area Personale</a>
				</button>
				<div class="dropdown-menu blue" aria-labelledby="dropdownMenuButton">
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
					<a class="dropdown-item" href="gestionepersona">Gestione clienti</a>
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
					
					<a class="dropdown-item" href="gestionepersona">Gestione clienti e utenti</a> 
					
					<% } %>
					
					<a class="dropdown-item" href="logout">Logout</a>
				</div>
			</div>
		</li>

		<!--   <li><a href="areapersonale">Area Personale</a></li> -->


		<%
			} else {
		%>
		<li id="loginLi">
		
				<a class="aMenu" style="float:right;margin-right:20px" href="registrazione">Registrati</a>
				<a class="aMenu" style="float:right" href="javascript:finestraLog()">Accedi</a>
		</li>

		<%
			}
		%>
	</ul>

</nav>


 
<div id="divLogin" class="">
	<div id="login" class="">
		<a href="javascript:esci()" id="esci">x</a> 
		<h2 style="margin-bottom: 30px"> Accedi </h2>
		<form method="POST" action="login">
			<label>E-mail</label> <input type="email" name="email" id="email">
			<label>Password</label> <input type="password" name="password" id="password">
			<% if(request.getSession().getAttribute("errore") != null){%>
			<p class="errore">Credenziali sbagliate.</p>
			
			<%} else if(request.getSession().getAttribute("errore_null") != null){%>
			
			<p class="errore">Inserisci tutti i campi.</p>
			
			<%} %>
			
				<input type="hidden" name="pagina" value="<%=request.getRequestURI()%>">
				<input class="bottoni bottone" id="loginButton" type="submit" value="Login">	
		</form>
	</div>
	
	
	<script>

function finestraLog()
{
	$('#divLogin').css("display","flex");
	$('body>*:not("#divLogin"), #div-car, .bgselect.cal-position').css('filter', 'blur(3px)');
}

<%
if(request.getSession().getAttribute("errore_null") != null || request.getSession().getAttribute("errore") != null) {
	 %>
	 finestraLog();
<%} %>

 </script>

</div>




