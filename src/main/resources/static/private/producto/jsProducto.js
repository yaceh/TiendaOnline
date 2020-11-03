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
		$('#modalProducto').attr("data-id",dataResponse.idproducto)
		$('#modalProducto').modal("show");
		
		
	});
	
}
$('#btnGuardar').click(function(e){
	let action=$('#modalProducto').attr("data-action");
	let objeto={
			nombre:$('#nombre').val(),
			precio:$('#precio').val(),
			cantidad:$('#cantidad').val(),
			descripcion:$('#descripcion').val(),
			categoria:{
				idcategoria:$('#categoria').val(),
			},
			marca:{
				idmarca:$('#marca').val(),
			}
	};
});