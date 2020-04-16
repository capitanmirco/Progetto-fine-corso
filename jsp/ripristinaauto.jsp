
<%@page import="java.util.List"%>
<%@page import="model.Auto"%>
    <%if(request.getAttribute("listavuota")==null){
    %>
<div id="accordion" class="pagineDiv">
	<div class="min-h">
	<div class="card">
		<div class="card-header">
			<h5 class=" testo mb-1">Automobili rimosse</h5>
		</div>
		<div class="card-body">
				<table class="table table-unruled tableGestione">
					<thead class="text-center">
						<tr>
							<th scope="col">#</th>
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
					
					if (session.getAttribute("cliente") == null)
					{
						
					
					List<Auto> listaauto = (List<Auto>) request.getAttribute("rimosse");
				
			  		for(Auto a : listaauto){
			  		 %>
						<tr>
							<td class="mezzo">Auto</td>
							<td><%=a.getMarca()%></td>
							<td><%=a.getModello()%></td>
							<td><%=a.getTarga()%></td>
							<td><%=a.getCilindrata()%></td>
							<td><%=a.getColore()%></td>
							<td><%=a.getCategoria().getNome()%></td>
							<td><a href=ripristinaauto?ripristinaauto=<%=a.getIdAuto()%>>Ripristina</a></td>
						</tr>
						<% } 
					}%>
			  	
					</tbody>
					</table>
				
    <%}else{%>
    	<div class="alert alert-warning" role="alert">
    	 	Non Ci sono Auto Rimosse
    	</div>
    <%}%>  
    </div>
					</div>
					</div>
	</div>
    
