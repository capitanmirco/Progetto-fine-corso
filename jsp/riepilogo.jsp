


<%@page import="java.time.LocalDate"%>
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

					
					
					
					<% LocalDate inizio = LocalDate.parse(n.getDataInizio()); 
						LocalDate fine = LocalDate.parse(n.getDataFine()); 
						int differenzaDate = fine.compareTo(inizio);
						System.out.println(differenzaDate++);
						
					%>
					<td><%
					
					double prezzo = n.getAuto().getCategoria().getPrezzo()*differenzaDate;
					
					out.print(prezzo + " euro");
					%></td>
					
				</tr>
			</tbody>
		</table>
		<form>
			<div class="form-group">
				<label for="exampleInputEmail1">Numero Carta</label> <input required
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
		<%
				if (n.getAuto().getCategoria().getIdCategoria() == 1) {
			%>
			<img src="https://iili.io/JoB637.jpg" style="width: 100%;">

			<%
				} else if (n.getAuto().getCategoria().getIdCategoria() == 2) {
			%>

			<img src="https://iili.io/Jof93X.jpg" style="width: 100%;">
			<%
				} else if (n.getAuto().getCategoria().getIdCategoria() == 3) {
			%>

			<img src="https://iili.io/JoBr4S.jpg" style="width: 100%;">
			<%
				}
			%>
		</div>


	</div>
	</div>
