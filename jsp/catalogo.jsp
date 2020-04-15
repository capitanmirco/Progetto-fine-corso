<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>


<%
	//request.getSession().setAttribute("email_admin", "ert");
	/* 1 = citycar // 2 = suv // 3 = auto di lusso */

	String data1 = null;
	String data2 = null;
	String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	boolean flag = false;
	if (request.getParameter("inizioNolo") != null) {
		data1 = (String) request.getAttribute("inizioNolo");

	} else {
		data1 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	if (request.getParameter("fineNolo") != null) {
		data2 = (String) request.getAttribute("fineNolo");
	} else if (flag) {
		data2 = data1;
	} else {
		data2 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
%>

<%@page import="model.Auto"%>
<%@page import="java.util.List"%>
<%
	List<Auto> listaAuto = (List<Auto>) request.getAttribute("listaAuto");
%>

<br><br><br><br><br><br><br><br>
<div class="container" id="catalogo">

	

	<div class="row">
		<div class="col-12">
			<form class="form-inline col-sm-10" action="filtro" method="post">
				<div class="form-group  col-sm-3 box">
					<%
						int categoria = 0;
						if (request.getAttribute("categoria") != null) {
							categoria = (Integer) request.getAttribute("categoria");
						} 
					%>
					<select name="auto" class="coloreTre">
						<%
							if (categoria == 1) {
						%>
						<option value="0">Tutte le categorie</option>
						<option selected value="1">City car</option>
						<option value="2">Suv</option>
						<option value="3">Lusso</option>
						<%
							} else if (categoria == 2) {
						%>
						<option value="0">Tutte le categorie</option>
						<option value="1">City car</option>
						<option selected value="2">Suv</option>
						<option value="3">Lusso</option>
						<%
							} else if (categoria == 3){
						%>
						<option value="0">Tutte le categorie</option>
						<option value="1">City car</option>
						<option value="2">Suv</option>
						<option selected value="3">Lusso</option>
						<%
							} else { %>
								<option selected value="0">Tutte le categorie</option>
								<option value="1">City car</option>
								<option value="2">Suv</option>
								<option value="3">Lusso</option>
							<% }
						%>

					</select>

					<%
						
					%>
				</div>



				<div class="form-group mx-sm-3">
					<input type="date" class="input coloreTre" name="inizioNolo" id="inizioNolo"
						value="<%=data1%>" min="<%=today%>" max="2021-04-08" onclick="verifica('inizioNolo')"  onchange="verifica('inizioNolo')" oninput="verifica('inizioNolo')">
				</div>

				<div class="form-group mx-sm-3">
					<input type="date" class="input  coloreTre" name="fineNolo" id="fineNolo"
						value="<%=data2%>" min="<%=today%>" max="2021-04-08" onclick="verifica('fineNolo')"  onchange="verifica('fineNolo')" oninput="verifica('fineNolo')">
				</div>
				<div class="col-sm-2 calendario">

					<button type="submit" class="btn bottone btn-primary">Cerca</button>
				</div>
			</form>
			<%
				if ((request.getSession().getAttribute("email_admin") != null)
						|| (request.getSession().getAttribute("utente") != null)) {
			%>
			<div class="col-sm-2">

				<div class="calendario  divBottone" id="div-prenota">
					<a class="bottone-catalogo bottone" type="button"
						href="aggiungiauto" style="min-width: max-content;">Aggiungi
						Auto</a>
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("dataerrata") != null && (boolean) request.getAttribute("dataerrata")) {
			%>
			<p>Data di fine errata</p>
			<%
				}
			%>

		</div>
	</div>
</div>
<div class="container">
	<%
		for (Auto auto : listaAuto) {
	%>
	<div class="row">

		<div class="col-3">

			<%
				if (auto.getCategoria().getIdCategoria() == 1) {
			%>
			<img src="https://iili.io/JoB637.jpg"
				class=" imgcat rounded float-left" width=170 height=100>

			<%
				} else if (auto.getCategoria().getIdCategoria() == 2) {
			%>

			<img src="https://iili.io/Jof93X.jpg"
				class=" imgcat rounded float-left" width=170 height=100>
			<%
				} else if (auto.getCategoria().getIdCategoria() == 3) {
			%>

			<img src="https://iili.io/JoBr4S.jpg"
				class=" imgcat rounded float-left" width=170 height=100>
			<%
				}
			%>

		</div>

		<div class="col-6 descrizione">
			<%
				out.print(auto.getMarca() + " " + auto.getModello() + " " + auto.getCilindrata() + " "
							+ auto.getColore() + " " + auto.getCategoria().getPrezzo() + " euro/giorno");
			%>
		</div>

		<div class="col-3 descrizione">
			<%
				if (request.getSession().getAttribute("cliente") != null) {
			%>
			<a
				href="noleggiaauto?noleggia=<%=auto.getIdAuto()%>&inizioNolo=<%=data1%>&fineNolo=<%=data2%>"
				class="btn btn-primary btn-lg active bottone" role="button"
				aria-pressed="true">noleggia</a>
			<%
				}
			%>

			<%
				if ((request.getSession().getAttribute("email_admin") != null)
							|| (request.getSession().getAttribute("utente") != null)) {
			%>
			<a href="rimuoviauto?remove=<%=auto.getIdAuto()%>"
				class="btn btn-primary btn-lg active bottone" role="button"
				aria-pressed="true">elimina</a> <a
				href="modificaauto?modifica=<%=auto.getIdAuto()%>"
				class="btn btn-primary btn-lg active bottone" role="button"
				aria-pressed="true">modifica</a>

			<%
				}
			%>
		</div>
	</div>
	<%
		}
	%>

</div> <script type="text/javascript">
<!--

//-->
function verifica(nome) {
	
	if(document.getElementById(nome).value == ""){
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		
		today = yyyy + '-' + mm + '-' + dd; //yyyy-MM-dd
		document.getElementById(nome).value = today;
	}
	
}


</script>
