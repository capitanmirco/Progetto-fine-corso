<%@page import="java.util.List"%>
<%@page import="model.Auto"%>
<div class="accordion" id="accordionExample">
	<div class="card">
		<div class="card-header" id="autorimosse">
			<h2 class="mb-0">
				<button class="btn btn-link" type="button" data-toggle="collapse"
					data-target="#collapseOne" aria-expanded="true"
					aria-controls="collapseOne">Lista auto rimosse</button>
			</h2>
		</div>

		<div id="autorimosse" class="collapse show"
			aria-labelledby="headingOne" data-parent="#accordionExample">
			<div class="card-body">
				<table class="table mt-3" border=1>
					<thead class="thead-dark text-center">
						<tr>
							<th scope="col">Marca</th>
							<th scope="col">Modello</th>
							<th scope="col">Targa</th>
							<th scope="col">Cilindrata</th>
							<th scope="col">Colore</th>
							<th scope="col">Categoria</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody class="text-center">



						<%
					
					if (session.getAttribute("cliente") != null)
					{
						
					
					List<Auto> listaauto = (List<Auto>) request.getAttribute("rimosse");
				
			  		for(Auto a : listaauto){
			  		 %>
						<tr>
							<th scope="row">Auto</th>
							<td><%=a.getMarca()%></td>
							<td><%=a.getModello()%></td>
							<td><%=a.getTarga()%></td>
							<td><%=a.getCilindrata()%></td>
							<td><%=a.getColore()%></td>
							<td><%=a.getCategoria().getNome()%></td>
							<td><a href=ripristinaauto?ripristinaauto=
								<%=a.getIdAuto()%>></a></td>
						</tr>
						<% } 
					}%>
			  	
					</tbody>
			</div>
		</div>
	</div>
</div>