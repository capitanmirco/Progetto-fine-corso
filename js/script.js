function mostraPatente(ruolo)
	{
		if(ruolo=="utente")
		{
			$('#patente').hide();
		}
		else if (ruolo=="cliente")
		{
			$('#patente').show();
		}
	}


//grayscale(80%)
function esci()
{
	$('#divLogin').css("display","none");
	$('body>*,  #div-car, .bgselect.cal-position').css('filter', 'none');
}
