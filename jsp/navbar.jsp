<div class="blue" id="header" align="center" style="">
  NOME SITO/LOGO
</div>
  <% //session.setAttribute("cliente", "ciao"); %>

<nav class="navbar navbar-inverse">
  <ul class="nav blue navbar-nav">
    <li><a href="home">Home</a></li>
    <li><a href="catalogo">Catalogo</a></li>
    
    <% if(session.getAttribute("cliente") != null || 
   			session.getAttribute("email_admin") != null ||
   			session.getAttribute("utente") != null
   			) { %>
    <li><a href="areapersonale">Area Personale</a></li>
    
    <% } else { %>
      <li id="login">
      <form method=POST action="login">
      <div id="loginForm">
        <div style="margin-right:10px;">
          E-mail <input type="email" name="email" class="loginInput" id="email"> 
        </div>
        <div>
        Password <input type="password" name="password" class="loginInput"  id="password">
        </div>
        </div>
        <div style="float:right">
        <a href="registrazione">Registrati.</a> <input class="bottoni bottone" id="loginButton" type="submit" value="Login"> 
     	</div>
      </form>
    </li>
    
    <% } %>
  </ul>

</nav>

