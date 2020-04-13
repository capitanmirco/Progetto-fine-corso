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


function checkPassword(){
	alert ('funziona');
	var password = document.getElementById('exampleInputPassword');
	var cPassword = document.getElementById('exampleInputConfermaPassword');
	
	if(password.value != cPassword.value){
		alert('Le password non coincidono');
		password.focus();
		password.select();
	} else {
		alert(password.value);
		alert(cPassword.value);
		document.getQuerySelector(".registra>form").submit();

	}
}