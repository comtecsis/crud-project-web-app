define(['require','jquery'],function(require, $){
	
	/**
	 * Recarga html y carga modulo require.
	 * 
	 * @param config
	 * @returns
	 */
	function loadModule(config){
		var params = {
			selector: null, 		// Selector jQuery donde se injectara el html.
			moduleJs: null, 	// Modulo require con el que se trabajará en onSuccess.
			urlContent: null, 	// Direccion del html a injectar
			method: 'POST', 	// Metodo de llamado a urlContent
			data: {},			// Data del request
			onSuccess: function(module){},	// Luego de la injeccion del html trabajar sobre los metodos del modulo require
			onError: function(err){},			// Llamar en caso de error en require o injeccion de modulo require.
			onRequireFail: function(err){console.error(err);},	// Llamar cuando require falla.
			beforeSend: function(){},		// Ejecutar antes de llamar el ajax
			validateResponse: function(){return true;}	// Validar que la respuesta es válida en caso de ser diferente a 200 y no se reconocida como error (400, 500, etc).
		}
		$.extend(params, config);
		require([params.moduleJs], function(module){
			$.ajax({
				url: params.urlContent,
				method: params.method,
				beforeSend: params.beforeSend,
				data: params.data
			})
			.done(function(response){
				if(params.validateResponse()){
					$(params.selector).html(response);
					params.onSuccess(module);
				}
			})
			.fail(params.onError)
		}, params.onRequireFail)
	}
	
	return {
		loadModule: loadModule,
	}
})