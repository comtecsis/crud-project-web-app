var requireCrud = requirejs.config({
    baseUrl: 'resources/js/',
    waitSeconds: 200,
    paths: {
        'bootstrap': 'deps/bootstrap.min',
        'jquery': 'deps/jquery-3.2.1.min',
        'popper': 'deps/popper.min',
        'home': 'home/home',
        'shell': 'config/shell'
    },
    shim:{
		'bootstrap' : {
			deps : [ 'jquery', 'popper' ]
		}
	},
	urlArgs : 'v=1.0.0'
})