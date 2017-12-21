define(['require','bootstrap','config/bodyEvt', 'home', 'libs/ajaxUtils'],function(require,bootstrap,bodyEvt, home, ajaxUtils){
	
	function activate(){
		ajaxUtils.initialize();
		bodyEvt.on();
		home.activate();
		console.log("Activate shell")
	}
	
	return {
		activate: activate
	}
})