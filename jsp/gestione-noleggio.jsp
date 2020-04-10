
<%@page import="model.Noleggio"%>
<%
	request.getAttribute("Noleggi_lista");
%>
<%
	Noleggio n = (Noleggio) request.getAttribute("noleggio");
%>
<%@page import="java.util.List"%>
<div class="madre">
    <div class="table-noleggio">
    <table class="table">
        <thead>
          <tr>
            <th scope="col"></th>
            <th scope="col">Utente</th>
            <th scope="col">Veicolo</th>
            <th scope="col">Inizio noleggio </th>
            <th scope="col">Fine noleggio</th>
          </tr>
        </thead>
        <tbody>
        <%List<Noleggio> listaNoleggi  = (List <Noleggio>) request.getAttribute("Noleggi_lista"); 
        for (Noleggio noleggio : listaNoleggi){ %>
        	
          <tr>
            <th scope="row">1</th>
            <td><%= n.getCliente()%></td>
            <td><%= n.getAuto().getModello()%> <%= n.getAuto().getMarca() %></td>
            <td><%= n.getDataInizio() %></td>
            <td><%= n.getDataFine() %></td>
            <% } %>
          </tr>
          
      </div>
      </div>
