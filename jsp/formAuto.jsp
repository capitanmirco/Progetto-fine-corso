
<%@page import="model.Auto"%>

<%
	Auto a = (Auto) request.getAttribute("auto");
%>	

 <div class="container registra">
    <form method="post">
        <input type="hidden" name="id" value="<%=a != null ? a.getIdAuto() : "" %>">
       	      
        <div class="form-group">
            <label for="inputMarca">Marca</label>
            <input type="text" class="form-control" name="marca" id="inputMarca" value="<%=a != null ? a.getMarca() : "" %>">
        </div>
        
        <div class="form-group">
          <label for="inputModello">Modello</label>
          <input type="text" class="form-control" name="modello" id="inputModello" value="<%=a != null ? a.getModello() : "" %>">
        </div>
        
      
     	  <div class="form-group">
            <label for="inputCilindrata">Cilindrata</label>
            <input type="text" class="form-control" name="cilindrata" id="inputCilindrata"<%=a != null ? a.getCilindrata() : "" %>>
          </div>
    
          <div class="form-group">
            <label for="inputTarga">Targa</label>
            <input type="text" class="form-control" name="targa" id="inputTarga" value="<%=a != null ? a.getTarga() : "" %>">
          </div>
        
          <div class="form-group">
            <label for="inputColore">Colore</label>
            <input type="text" class="form-control" name="colore" id="inputColore" value="<%=a != null ? a.getColore() : "" %>">
          </div>
        
        <div class="form-group">
       
       		<input type="radio" id="1" name="categoria" value="1">
       		<label for="1">City car</label> &nbsp &nbsp
       		
       		<input type="radio" id="2" name="categoria" value="2" >
       		<label for="2">Suv</label> &nbsp &nbsp
       		
       		<input type="radio" id="3" name="categoria" value="3">    
       		<label for="3">Auto di lusso</label><br>   		
         	</div>
        		 
     	<button type="submit" class="btn btn-primary"> Button </button> 		
 	</form>
</div>

