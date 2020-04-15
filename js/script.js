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

function finestraLog(param)
{
	if(param=="accedi")
	{
		$('#divLogin').css("display","flex");
		$('body>*:not("#divLogin")').css('filter', 'blur(3px)');
	}
}
//grayscale(80%)
function esci()
{
	$('#divLogin').css("display","none");
	$('body>*').css('filter', 'none');
}
