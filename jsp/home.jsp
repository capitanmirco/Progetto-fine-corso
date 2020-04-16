<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>


<%String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
%>
<div class="div-car" style="width:101%">
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
				<select name="auto" id="text" class="coloreTre">
					<option value="0">Tutte le categorie</option>
					<option value="1">City car</option>
					<option value="3">Lusso</option>
					<option value="2">Suv</option>

				</select>
			</div>
			<div class="calendario">
				<label for="start" id="text"></label> <input  type="date" class="input coloreTre" onclick="verifica('inizioNolo')"  onchange="verifica('inizioNolo')" oninput="verifica('inizioNolo')"
					id="inizioNolo" name="inizioNolo" value="<%=today%>" min="<%=today%>"
					max="2021-04-08">
			</div>
			<div class="calendario">
		
				<label for="start" id="text"></label><input type="date" class="input  coloreTre"
					id="fineNolo" name="fineNolo" value="<%=today%>" min="<%=today%>" onclick="verifica('fineNolo')"  onchange="verifica('fineNolo')" oninput="verifica('fineNolo')"
					max="2021-04-08"> <br>
				<br>
				<button class="bottone-calendario bottone" type="submit" id="text">Prenota</button>
			</div>


		</form>

	</div>
</div>
<script type="text/javascript">
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
