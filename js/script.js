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
