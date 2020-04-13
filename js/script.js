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
		$('#login').css("display","block");
		$('body>*:not("#login")').css('filter', 'blur(3px)');
	}
}
//grayscale(80%)
function esci()
{
	$('#login').css("display","none");
	$('body>*').css('filter', 'none');
}
