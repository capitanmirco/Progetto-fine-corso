<%@page import="model.Auto"%>
<%@page import="java.util.List"%>
	
	
<div id="accordion" class="pagineDiv">




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
						
					List<Auto> listaAutoRimosse = (List<Auto>) request.getAttribute("rimosse");
				
			  		for(Auto a : listaAutoRimosse){
			  		 %>
						<tr>

						 	<td><%=a.getMarca()%></td>
						 	<td><%=a.getModello()%></td>
						 	<td><%=a.getTarga()%></td>
						 	<td><%=a.getCilindrata()%></td>
						 	<td><%=a.getColore()%></td>
						 	<td><%=a.getCategoria().getNome()%></td>
							<td> 
									<a type="button" href="ripristinaauto?ripristinaauto=<%=a.getIdAuto()%>">Ripristina</a>
									<% 
										} 
									%>
						 	</td>
						</tr>
			  		
	
					</tbody>
				</table>

			</div>
		</div>

	
