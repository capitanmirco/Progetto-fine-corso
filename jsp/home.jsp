<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>


<%String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
%>
<div class="div-car">
	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="https://iili.io/JnPsVV.jpg" class="d-block w-100"
					alt="immagine non trovata">
			</div>
			<div class="carousel-item">
				<img src="https://iili.io/JnLnn4.jpg" class="d-block w-100"
					alt="immagine non trovata">
			</div>
			<div class="carousel-item">
				<img src="https://iili.io/JCyqVs.jpg" class="d-block w-100"
					alt="immagine non trovata">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleFade"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Precedente</span>
		</a> <a class="carousel-control-next" href="#carouselExampleFade"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Prossima</span>
		</a>
	</div>


</div>
<div >
	<div class="bgselect cal-position">
		<form method="post" action="filtro">

			<div class="box">
				<select name="auto" id="text">
					<option value="citycar">City car</option>
					<option value="lusso">Lusso</option>
					<option value="suv">Suv</option>

				</select>
			</div>
			<div class="calendario">
				<label for="start" id="text"></label> <input  type="date" class="input"
					id="start" name="inizioNolo" value="<%=today%>" min="<%=today%>"
					max="2021-04-08">
			</div>
			<div class="calendario">
		
				<label for="start" id="text"></label><input type="date" class="input"
					id="start" name="fineNolo" value="<%=today%>" min="<%=today%>"
					max="2021-04-08"> <br>
				<br>
				<button class="bottone-calendario" type="submit" id="text">Prenota</button>
			</div>


		</form>

	</div>
</div>
