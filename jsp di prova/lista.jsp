<%@page import="model.Utente"%>
<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<div class="container">
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Data</th>
      <th scope="col">ToDo</th>
      <th scope="col">Utente</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  
  <%!Cliente c = new Cliente();%>
  <%c.setCodiceFiscale("efsfase");
  c.setDataDiNascita("11-11-1111");
  c.setEmail("fse@sefse.ef");
  c.setNome("io");
  c.setPassword("sefasef");
  c.setValidato((byte)0);
  c.setIdCliente(1);
  
  request.setAttribute("cliente", c);%>  
  
<%
	  out.print("<tr>"
      	+ "<th scope=\"row\">" + c.getNome() + "</th>"
      	+ "<td>" + c.getDataDiNascita() + "</td>"
      	+ "<td>" + c.getEmail() + "</td>"
     	+ "<td>" + c.getCognome() + " " + c.getCodiceFiscale() + "</td>"
      	+ "<td><a href=\"?valida=1&id=" + c.getIdCliente() + "\" type=\"button\" class=\"btn btn-danger\">Valida</a></td>"
    	+ "</tr>"
    	+ "<tr>");
  

  %>
  
  </tbody>
</table>
</div>