/**
 * Lógica para pasar variables globales desde el controller.
 */

function memory() {

	var tmp = {};
	var activate = true;

	function clear() {
		if(activate){
			console.log("Limpieza de memoria");
			tmp = {};
		}
	}

	function putVar(key, value) {
		tmp[key] = value;
	}

	function getVar(key) {
		return tmp[key];
	}
	
	function startClear(){
		activate = true;
	}
	
	function stopClear(){
		activate = false;
	}
	
	return {
		putVar: putVar,
		getVar: getVar,
		clear: clear,
		startClear: startClear,
		stopClear: stopClear
	}

}

var objMemory = memory();