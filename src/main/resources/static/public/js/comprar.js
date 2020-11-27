function comprar(id){
	$(location).attr('href',"/cart/buy/"+id+"?cantidad="+$('#quantity').val());
}