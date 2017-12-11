define(['require','bootstrap','config/bodyEvt', 'home'],function(require,bootstrap,bodyEvt, home){
	
	function activate(){
		bodyEvt.on();
		home.activate();
		console.log("Activate shell")
	}
	
	return {
		activate: activate
	}
})