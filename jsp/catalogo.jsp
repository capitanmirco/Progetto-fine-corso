<div>

	<div class="container">
		<%@page import="java.time.LocalDate"%>
		<%@page import="java.time.format.DateTimeFormatter"%>


		<%
			String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		%>
		<div class="row">
			<%@page import="model.Auto"%>
			<%@page import="java.util.List"%>
			<%
				List<Auto> listaAuto = (List<Auto>) request.getAttribute("listaAuto");
			%>
			<div class="col-sm">
				<div class="box align-self-center">
					<select name="auto" id="text">
						<option value="citycar">City car</option>
						<option value="lusso">Lusso</option>
						<option value="suv">Suv</option>

					</select>
					<%
						
					%>
				</div>
			</div>
			<div class="col-sm ">
				<div class="calendario align-self-center">
					<label for="start" id="text"></label> <input type="date"
						class="input" id="start" name="inizioNolo" value="<%=today%>"
						min="<%=today%>" max="2021-04-08">
				</div>
			</div>
			<div class="col-sm">
				<div class="calendario align-self-center">

					<label for="start" id="text"></label><input type="date"
						class="input" id="start" name="fineNolo" value="<%=today%>"
						min="<%=today%>" max="2021-04-08">
				</div>
			</div>

			<div class="col-sm">
				<div class="calendario" id="div-prenota">
					<button class="bottone-catalogo align-item-center" type="submit">Prenota</button>
				</div>
				<%
					if ((request.getSession().getAttribute("email_admin") != null)
							|| (request.getSession().getAttribute("utente") != null)) {
				%>
				<div class="calendario" id="div-prenota">
					<button class="bottone-catalogo align-item-center" type="submit">Aggiungi</button>
				</div>
				<%
					}
				%>
			</div>
		</div>

		
		<%
			for (Auto auto : listaAuto) {
				
		%>
		<div class="row">

			<div class="col-3">

				<%if(auto.getCategoria().getIdCategoria() == 1){ %>
				<img src="https://iili.io/JoB637.jpg"
					class=" imgcat rounded float-left">

				<%} else if(auto.getCategoria().getIdCategoria() == 2){%>

				<img src="https://iili.io/Jof93X.jpg"
					class=" imgcat rounded float-left">
				<% } 	else if(auto.getCategoria().getIdCategoria() == 3){%>

				<img src="https://iili.io/JoBr4S.jpg"
					class=" imgcat rounded float-left">
				<%}%>"

			</div>

			<div class="col-6 descrizione">
				<%
					out.print(auto.getMarca() + " " + auto.getModello() + " " + auto.getCilindrata() + " "
								+ auto.getColore() + " " + auto.getCategoria().getPrezzo() + " euro/giorno"  );
				%>
			</div>

			<div class="col-3 descrizione">
				<a href="" class="btn btn-primary btn-lg active" role="button"
					aria-pressed="true">noleggia</a> &nbsp&nbsp&nbsp<a href="#"
					class="btn btn-primary btn-lg active" role="button"
					aria-pressed="true">elimina</a> &nbsp&nbsp&nbsp<a href="#"
					class="btn btn-primary btn-lg active" role="button"
					aria-pressed="true">modifica</a>
			</div>
		</div>
		<%
			}
		%>


	</div>