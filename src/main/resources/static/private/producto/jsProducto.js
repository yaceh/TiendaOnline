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
function actionEliminar(id,elem,e){
	e.preventDefault();
	let url="/admin/producto/eliminar?id="+id;
	let type="POST";
	doAjax(url,type,null,function (dataResponse){
		Swal.fire(
				  'Correcto',
				  'Se ha cambiado eliminado correctamente el producto',
				  'success'
				).then((result) => {
					location.reload();
				});
	});
}
function actionAddImagen(id,elem,e){
	e.preventDefault();
	let url="/admin/producto/"+id;
	let type="GET";
	doAjax(url,type,null,function (dataResponse){
		$('#imgProducto').prop('src','/public/images/'+dataResponse.urlimagen);
		$('#modalImagen').attr('data-idproducto',dataResponse.idproducto);
		$('#formImagenProducto').trigger("reset");
		$('#modalImagen').modal("show");
	});
}

function readURL(input,imgHTML) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
	    
    reader.onload = function(e) {
      $(imgHTML).attr('src', e.target.result);
    }
	    
    reader.readAsDataURL(input.files[0]); // convert to base64 string
  }
}
$("#imagen").change(function() {
	readURL(this,'#imgProducto');
});

$('#btnGuardarImagen').click(function(e){
	e.preventDefault();
	var form=$('#formImagenProducto');
	if($('#imagen').val()!="")form.submit();
});

$("#formImagenProducto").on("submit",function (e){
	e.preventDefault();
	var url='/admin/producto/addImagen';

	var idproducto=$('#modalImagen').attr('data-idproducto');
	url+='?idproducto='+idproducto;
    $.ajax({
        type: 'POST',
        url: url,
        data: new FormData(this),
        contentType: false,
        cache: false,
        processData:false,
        success:function(dataResponse){
        	if(dataResponse){
    			Swal.fire(
    					  'Se ha modificado correctamente',
    					  '---',
    					  'success'
    					);
    		}
    		else{
    			Swal.fire(
    					  'Ha ocurrido algo inesperado',
    					  'Vuelva a intentar',
    					  'error'
    					)		
    		}
    		$('#modalImagen').modal("hide");
        },
        beforeSend: function () {
            desactivarBotones();
        },
        complete: function () {
            activarBotones();
        }
    });
});
