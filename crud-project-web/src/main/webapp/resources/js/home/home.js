define(['require','bootstrap','config/logicAjax'],function(require,bootstrap,logicAjax){
	
	function activate(){
		logicAjax.on();
		console.log("Activate")
	}
	
	return {
		activate: activate
	}
})