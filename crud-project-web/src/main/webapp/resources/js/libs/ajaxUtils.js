define(['require','jquery','libs/constants'],function(require, $, constants){
	
	/**
	 * Inicializar configuracion ajax
	 */
	function initialize(){
		
		$( document ).ajaxError(function( event, request, settings ) {
			console.log(event);
		});
		
		$.extend({
		    postJSON: function(config) {
		        return $.ajax({
		            type: 'POST',
		            url: config.url,
		            data: JSON.stringify(config.data),
		            contentType: "application/json",
		            dataType: 'json'
		        });
		    }
		});
	}

	/**
	 * Recarga html y carga modulo require.
	 * 
	 * @param config
	 * @returns
	 */
	function loadModule(config){
		
		function onSuccessModule(module){
			var methods_support = ["activate","events","complete"]
			for(var key in methods_support){
				var method = methods_support[key];
				if(module[method] !== undefined){
					module[method]();
				}
			}
		}
		
		var params = {
			selector: constants.AJAX_CONTAINER, 		// Selector jQuery donde se injectara el html.
			moduleJs: null, 	// Modulo require con el que se trabajará en onSuccess.
			urlContent: null, 	// Direccion del html a injectar
			method: 'POST', 	// Metodo de llamado a urlContent
			data: {},			// Data del request
			onSuccess: onSuccessModule,	// Luego de la injeccion del html trabajar sobre los metodos del modulo require
			onError: function(err){},			// Llamar en caso de error en require o injeccion de modulo require.
			onRequireFail: function(err){console.error(err);},	// Llamar cuando require falla.
			beforeSend: function(){},		// Ejecutar antes de llamar el ajax
			validateResponse: function(){return true;},	// Validar que la respuesta es válida en caso de ser diferente a 200 y no se reconocida como error (400, 500, etc).
			clearMemory: objMemory.clear // Limpiar variable tmp de almacenamiento de valores.
		}
		$.extend(params, config);
		if(params.urlContent == null){
			params.urlContent = params.moduleJs;
		}
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
					params.clearMemory();
					params.onSuccess(module);
				}
			})
			.fail(params.onError)
		}, params.onRequireFail)
	}
	
	return {
		loadModule: loadModule,
		initialize: initialize
	}
})