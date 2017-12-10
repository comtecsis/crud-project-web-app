define(function(require){
	
	require('bootstrap');
	
	function activate(){
		console.log("Activate")
	}
	
	return {
		activate: activate
	}
})