define(['require','jquery', 'libs/ajaxUtils'],function(require, $, ajaxUtils){
	
	function events(){
		console.debug("Events de list");
		$('.btn-edit').on("click",function(e){
			e.preventDefault();
			var href = 'ubigeo/edit';
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
		});
	}
	
	function activate(){
		console.debug("Activate de list");
	}
	
	return {
		activate: activate,
		events: events
	}
	
});