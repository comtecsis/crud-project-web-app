define(['require','libs/ajaxUtils'],function(require, ajaxUtils){
	
	var events = [
		{
			action: "click",
			selector: "a.req_inj",
			evt: injectRequire
		}
	]
	
	function on(){
		off();
		events.forEach(function(event){
			$("body").on(event.action, event.selector, event.evt)
		})
	}
	
	function off(){
		events.forEach(function(event){
			$("body").off(event.action, event.selector, event.evt)
		})
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
			moduleJs: href, 	
			urlContent: href, 	
			onSuccess: function(module){
				objMemory.clear(); // Se limpia las variables que hayan sido traidas en el anterior modelo.
				var methods_support = ["activate","events","complete"]
				for(var key in methods_support){
					var method = methods_support[key];
					if(module[method] !== undefined){
						module[method]();
					}
				}
			}
		})
	}
	
	return {
		on: on,
		off: off,
		getSelector: getSelector
	}
	
})