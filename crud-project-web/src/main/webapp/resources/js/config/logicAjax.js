define(['require','libs/ajaxUtils'],function(require, ajaxUtils){
	
	var selectors = {
		require_inject: "a.req_inj",
		require_component: "#ajax-container"
	}
	
	function on(){
		off();
		$(selectors.require_inject).on("click",function(e){
			injectRequire(e);
		})
	}
	
	function off(){
		$(selectors.require_inject).off("click");
	}
	
	function getSelector(attr){
		var val = null;
		for(var key in comps){
			if( attr === key ){
				val = comps[key];
				return val;
			}
		}
		return val;
	}
	
	function injectRequire(e){
		e.preventDefault();
		var comp = e.target;
		var href = $(comp).attr("href");
		ajaxUtils.loadModule({
			selector: selectors.require_component, 		
			moduleJs: href, 	
			urlContent: href, 	
			onSuccess: function(module){
				var methods_support = ["activate","render","complete"]
				for(var key in methods_support){
					var method = methods_support[key];
					if(module[method] !== undefined){
						module[method]();
					}
				}
			},	// Luego de la injeccion del html trabajar sobre los metodos del modulo require
			onError: function(){},			// Llamar en caso de error en require o injeccion de modulo require.
		})
	}
	
	return {
		on: on,
		off: off,
		getSelector: getSelector
	}
	
})