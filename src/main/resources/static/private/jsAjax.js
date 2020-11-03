function doAjax(url,type,objeto,fn){
    if(objeto!=null){
     $.ajax({
            url : url,
            type : type,
            dataType : 'json',
            data: JSON.stringify(objeto),
            contentType : 'application/json',
            success  : function(dataResponse) {
                fn(dataResponse);
            },
            beforeSend: function () {
                desactivarBotones();
            },
            complete: function () {
                activarBotones();
            }
        });
      }
      else{
         $.ajax({
            url : url,
            type : type,
            contentType : 'application/json',
            success  : function(dataResponse) {
                fn(dataResponse);
            },
            beforeSend: function () {
                desactivarBotones();
            },
            complete: function () {
                activarBotones();
            }
        });
      }
}