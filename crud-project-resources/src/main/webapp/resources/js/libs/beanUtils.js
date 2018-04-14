define(['require'],function(require){
	
	var instance = {};
	
	function set(attr,value){
		if(instance[attr] !== undefined){
			instance[attr] = value;
		}
		return instance;
	}
	
	function get(attr){
		return instance[attr];
	}

	function merge(input){
		for(var prop in input){
			if(instance[prop] !== undefined){
				instance[prop] = input[prop];
			}
		}
		return instance;
	}
	
	function getData(){
		return instance;
	}
	
	function initialize(obj){
		instance = obj;
		return {
			set: set,
			get: get,
			merge: merge,
			getData: getData
		}
	}
	
	return {
		initialize: initialize
	}
});