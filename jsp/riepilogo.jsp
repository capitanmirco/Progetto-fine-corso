 <%@page import="model.Noleggio"%>
<% Noleggio n =(Noleggio)request.getAttribute("noleggio");%>

<div class="size-riepilogo">
    <div class="form">
    <table  class="table">
        <thead>
    <tr>
        
        <th scope="col">Dati auto</th>
       </tr>
    </thead>
    <tbody>
      <tr>
         
        <td><%=n.getAuto()%></td>
       </tr>
       </tbody>
    </table>
    <table  class="table">
        <thead>
    <tr>
        
        <th scope="col">Inizio noleggio</th>
        <th scope="col">Fine noleggio</th>
       </tr>
    </thead>
    <tbody>
      <tr>
         
        <td><%=n.getDataInizio()%> </td>
        <td><%=n.getDataFine()%></td>
       </tr>
       </tbody>
    </table>
    <table  class="table">
        <thead>
    <tr>
        
        <th scope="col">Prezzo finale</th>
       </tr>
    </thead>
    <tbody>
      <tr>
         
        <td> <%= n.getAuto().getCategoria().getPrezzo()%></td>
       </tr>
       </tbody>
    </table>
    <form>
        <div class="form-group">
          <label for="exampleInputEmail1">Numero Carta</label>
          <input type="number" id="input-carta" min="1000000000000000" max="9000000000000000" id="ccard"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
          <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
    <button type="submit" class="btn btn-primary" id="colore-bottone">Conferma</button>
  </form>
</div>
<div class="div-car">
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
    