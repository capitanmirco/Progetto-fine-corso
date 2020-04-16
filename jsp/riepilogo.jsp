<%@page import="model.Noleggio"%>
<%
	Noleggio n = (Noleggio) request.getAttribute("noleggio");
%>
<!--RIEPILOGO NOLEGGIO-->
<div class="min-h">
<div class="size-riepilogo">
	<div class="form">
	<h2>Dati auto</h2>
	
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Marca e modello</th>
				</tr>
			</thead>
	
	
		
			<tbody>
				<tr>

					<td><%=n.getAuto().getModello()+" "+n.getAuto().getMarca()%></td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Inizio noleggio</th>
					<th scope="col">Fine noleggio</th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<td><%=n.getDataInizio()%></td>
					<td><%=n.getDataFine()%></td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<thead>
				<tr>

					<th scope="col">Prezzo finale</th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<td><%=n.getAuto().getCategoria().getPrezzo()%></td>
				</tr>
			</tbody>
		</table>
		<form>
			<div class="form-group">
				<label for="exampleInputEmail1">Numero Carta</label> <input
					type="number" id="input-carta" min="1000000000000000"
					max="9000000000000000" id="ccard" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"> <small
					id="emailHelp" class="form-text text-muted"></small>
			</div>
			<a type="button"
				href="pagamento?paga=p&dataInizio=<%=n.getDataInizio()%>&dataFine=<%=n.getDataFine()%>&idAuto=<%=n.getAuto().getIdAuto()%>&idCliente=<%=n.getCliente().getIdCliente()%>"
				class="btn btn-primary" id="colore-bottone">Conferma</a>
		</form>
	</div>
	

	<div class="car-riepilogo">
		<div id="carouselExampleFade" class="carousel slide carousel-fade"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">

				<%
				if (n.getAuto().getCategoria().getIdCategoria() == 1) {
			%>
			<img src="https://iili.io/JoB637.jpg"
				class="d-block w-100">

			<%
				} else if (n.getAuto().getCategoria().getIdCategoria() == 2) {
			%>

			<img src="https://iili.io/Jof93X.jpg"
				class="d-block w-100">
			<%
				} else if (n.getAuto().getCategoria().getIdCategoria() == 3) {
			%>

			<img src="https://iili.io/JoBr4S.jpg"
				class="d-block w-100">
			<%
				}
			%>
				</div>
			</div>		
		</div>
	</div>
	</div>
	</div>
