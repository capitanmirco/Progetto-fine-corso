<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>


<%
	/* 1 = citycar // 2 = suv // 3 = auto di lusso */
	String data1 = null;
	String data2 = null;
	String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	boolean flag = false;
	if (request.getParameter("inizioNolo") != null) {
		data1 = (String)request.getAttribute("inizioNolo");
	} else {
		data1 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	if (request.getParameter("fineNolo") != null) {
		data2 = (String)request.getAttribute("fineNolo");
	} else if (flag) {
		data2 = data1;
	} else {
		data2 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
%>

<%@page import="model.Auto"%>
<%@page import="java.util.List"%>
<%
	List<Auto> listaAuto = (List<Auto>) request.getAttribute("catalogo");
%>
<br><br><br><br><br><br><br><br>
<div class="container" id="catalogo">

	

	<div class="row">
		<div class="col-12">
			<form class="form-inline col-sm-10" action="filtro" method="post">
				<div class="form-group mb-2  col-sm-3 box">
					<%
					int categoria;
						if (request.getAttribute("categoria")!= null)
						{
							categoria = (Integer)request.getAttribute("categoria");
						}
						else
						{
							categoria = 1;
						}
					%>
					<select name="auto" class="coloreTre">
						<%
							if (categoria == 1) {
						%>

						<option selected value="1">City car</option>
						<option value="2">Suv</option>
						<option value="3">Lusso</option>
						<%
							} else if (categoria == 2) {
						%>
						<option value="1">City car</option>
						<option selected value="2">Suv</option>
						<option value="3">Lusso</option>
						<%
							} else {
						%>
						<option value="1">City car</option>
						<option value="2">Suv</option>
						<option selected value="3">Lusso</option>
						<%
							}
						%>

					</select>

					<%
						
					%>
				</div>



				<div class="form-group mx-sm-3 mb-2">
					<input type="date" class="input coloreTre" name="inizioNolo"
						value="<%=data1%>" min="<%=today%>" max="2021-04-08">
				</div>

				<div class="form-group mx-sm-3 mb-2">
					<input type="date" class="input  coloreTre" name="fineNolo"
						value="<%=data2%>" min="<%=today%>" max="2021-04-08">
				</div>
				<div class="col-sm-2 calendario">

					<button type="submit" class="bottone">Cerca</button>
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
			<%} %>
			<%
			if(request.getAttribute("dataerrata")!=null && (boolean)request.getAttribute("dataerrata"))
			{%>
				<p>Data di fine errata</p>
			<%}%>

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
			<a href="noleggiaauto?noleggia=<%=auto.getIdAuto()%>&inizioNolo=<%=data1 %>&fineNolo=<%=data2 %>"
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
				class="bottone"  role="button"
				aria-pressed="true">elimina</a> <a
				href="modificaauto?modifica=<%=auto.getIdAuto()%>"
				class=" bottone" role="button"
				aria-pressed="true">modifica</a>

			<%
				}
			%>
		</div>
	</div>
	<%
		}
	%>

</div>
