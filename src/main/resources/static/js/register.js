// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function registerUser() {
let data = {};
data.name = document.getElementById('txtName').value;
data.surname = document.getElementById('txtSurname').value;
data.email = document.getElementById('txtEmail').value;
data.password = document.getElementById('txtPassword').value;

let repeatPassword = document.getElementById('txtRepeatPassword').value;

if (repeatPassword != data.password){
	alert('Las contraseñas no coinciden');
	return;
}

	const request = await fetch('api/users/', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		    body: JSON.stringify(data)
	});
	alert("la cuenta fue creada con exito");
	window.location.href = 'login.html'


}