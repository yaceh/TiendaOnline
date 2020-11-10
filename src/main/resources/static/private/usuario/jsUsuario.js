/**
 * 
 */
$('#btnGuardar').click(function(e){
	let objeto={
			nombre:$('#nombre').val(),
			usuario:$('#usuario').val(),
			password:$('#password').val(),
			perfil:{
				idperfil: $('#perfil').val()
			},
			activo: true
	}
	let url="/admin/usuario/agregar";
	let type="POST";
	doAjax(url,type,objeto,function (dataResponse){
		$('#modalUsuario').modal("hide");
		Swal.fire(
				 'Correcto',
				 'Se ha agregado correctamente',
				 'success'
				).then((result) => {
					location.reload();
				});
	});
});

$('#btnAgregar').click(function (e){
	$('#formUsuario').trigger("reset");
	$('#modalUsuario').modal("show");
});

function actionCambiarActivo(id,elem,e){
	e.preventDefault();
	let url="/admin/usuario/cambiarActivo?id="+id;
	let type="POST";
	doAjax(url,type,null,function (dataResponse){
		Swal.fire(
				  'Correcto',
				  'Se ha cambiado el estado Activo del Usuario',
				  'success'
				).then((result) => {
					location.reload();
				});
	});
}

function actionEliminar(id,elem,e){
	e.preventDefault();
	let url="/admin/usuario/eliminar?id="+id;
	let type="POST";
	doAjax(url,type,null,function (dataResponse){
		Swal.fire(
				  'Correcto',
				  'Se ha eliminado correctamente el Usuario',
				  'success'
				).then((result) => {
					location.reload();
				});
	});
}