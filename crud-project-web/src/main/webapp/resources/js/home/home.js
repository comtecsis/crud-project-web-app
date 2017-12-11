define(['require','bootstrap','config/bodyEvt'],function(require,bootstrap,bodyEvt){
	
	function activate(){
		objMemory.startClear();
		console.log("Activate home")
	}
	
	return {
		activate: activate
	}
})