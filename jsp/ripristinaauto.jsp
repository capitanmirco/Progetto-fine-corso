
<%@page import="java.util.List"%>
<%@page import="model.Auto"%>
    <%if(request.getAttribute("listavuota")==null){
    %>
<div class="min-h">
<div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        	Lista Auto Rimosse
			 </button>
      </h2>
    </div>
		 <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
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
 	</div>
    </div>
    <%}else{%>
    	<div class="alert alert-warning" role="alert">
    	 	Non Ci sono Auto Rimosse
    	</div>
    <%}%>  
    
  </div>
  </div>
<div>
	
