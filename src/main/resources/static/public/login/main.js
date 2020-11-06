const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});


$('#btnRegistro').click(function(e){
	e.preventDefault();
	let url="/registro";
	let type="POST";
	let objeto={
		usuario:$('#usuarioRegistro').val(),
		password:$('#passwordRegistro').val(),
		nombre:$('#nombreRegistro').val()
	};
	doAjax(url,type,objeto,function (dataResponse){
		if(dataResponse){
			$('#registroForm').trigger("reset");
			Swal.fire(
					  'Se ha registrado correctamente',
					  'Ya puede iniciar sesión',
					  'success'
					);
		}else{
			Swal.fire(
					  'Ha ocurrido un problema',
					  'Ingrese otro usuario',
					  'error'
					);
		}
		
	});
});