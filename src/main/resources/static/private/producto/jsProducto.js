function actionEditarProducto(id,element,e){
	e.preventDefault();
	let url="/admin/producto/"+id;
	let type="GET";
	doAjax(url,type,null,function (dataResponse){
		$('#nombre').val(dataResponse.nombre);
		$('#precio').val(dataResponse.precio);
		$('#cantidad').val(dataResponse.cantidad);
		$('#descripcion').val(dataResponse.descripcion);
		$('#categoria').val(dataResponse.categoria.idcategoria);
		$('#marca').val(dataResponse.marca.idmarca);
		
		$('#modalProducto').attr("data-action","editar");
		$('#modalProducto').attr("data-id",dataResponse.idproducto);
		$('#modalProducto').modal("show");
	});
}
$('#btnGuardar').click(function(e){
	let action=$('#modalProducto').attr("data-action");
	let objeto={
			idproducto:$('#modalProducto').attr("data-id"),
			nombre:$('#nombre').val(),
			precio:$('#precio').val(),
			cantidad:$('#cantidad').val(),
			descripcion:$('#descripcion').val(),
			categoria:{
				idcategoria:$('#categoria').val(),
			},
			marca:{
				idmarca:$('#marca').val(),
			},
			partner:{
				idpartner:$('#partner').val()
			}
	}
	let url="/admin/producto/";
	url+=action=="editar"? "editar":"agregar";
	let type="POST";
	doAjax(url,type,objeto,function (dataResponse){
		$('#modalProducto').modal("hide");
		Swal.fire(
				  'Correcto',
				  action=="editar"?'Se ha modificado correctamente':'Se ha agregado correctamente',
				  'success'
				).then((result) => {
					location.reload();
				});
	});
});

$('#btnAgregar').click(function (e){
	$('#formProducto').trigger("reset");
	$('#modalProducto').attr("data-action","agregar");
	$('#modalProducto').attr("data-id","null");
	$('#modalProducto').modal("show");
});

function actionCambiarActivo(id,elem,e){
	e.preventDefault();
	let url="/admin/producto/cambiarActivo?id="+id;
	let type="POST";
	doAjax(url,type,null,function (dataResponse){
		Swal.fire(
				  'Correcto',
				  'Se ha cambiado el estado Activo del producto',
				  'success'
				).then((result) => {
					location.reload();
				});
	});
}