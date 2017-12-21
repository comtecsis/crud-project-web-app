define(['require','jquery', 'libs/ajaxUtils', 'request/url', 'request/bean/ReqUbigeo'],function(require, $, ajaxUtils, url, reqUbigeo){
	
	/**
	 * Componentes de logica
	 */
	
	var comp = {
		btnEdit : '.btn-edit',
		btnDetail: '.btn-detail',
		btnDelete: '.btn-delete',
		mdlDelete: {
			layer: '#modal-delete',
			btnSend: '#modal-delete .btn-save'
		}
	}
	
	/**
	 * Converters de vista a valores.
	 * @param comp
	 * @returns {___anonymous228_250}
	 */
	function opeList(comp){
		var $this = $(comp).closest('tr.item');
		
		function toCode(){
			return $this.data('code');
		}
		
		return {
			toCode: toCode
		}
	}
	
	/**
	 * Configuración de request para peticiones ajax
	 * @param comp
	 */
	
	function reqEdit(comp){
		var ope = opeList(comp);
		reqUbigeo.merge({
			idUbigeo: ope.toCode().toString(),
		});
		return reqUbigeo.getData();
	}
	
	function reqDetail(comp){
		return reqEdit(comp);
	}
	
	function reqDelete(comp){
		return reqEdit(comp);
	}
	
	/**
	 * Procesos de responses
	 */
	function onSuccessModalSave(data){
		console.log(data);
	}
	
	/**
	 * Eventos asociados a pantalla
	 */
	function editEvt(e){
		e.preventDefault();
		var href = url.ubigeo.edit;
		var data = reqEdit(e.target);
		ajaxUtils.loadModule({
			moduleJs: href, 	
			urlContent: href,
			data: data
		})
	}
	
	function detailEvt(e){
		e.preventDefault();
		var href = url.ubigeo.detail;
		var data = reqDetail(e.target);
		ajaxUtils.loadModule({ 		
			moduleJs: href, 	
			urlContent: href,
			data: data
		})
	}
	
	function deleteEvt(e){
		e.preventDefault();
		var $mdlDelete = $(comp.mdlDelete.layer);
		$mdlDelete.data('target-evt',e.target);
		$mdlDelete.modal('show');
	}
	
	function modalSaveEvt(e){
		e.preventDefault();
		var target = $(comp.mdlDelete.layer).data('target-evt');
		var data = reqDelete(target);
		$.postJSON({
			url: url.ubigeo.delete, 
			data: data
		})
		.done(onSuccessModalSave);
	}
	
	/**
	 * Funciones a cargar luego de renderizar
	 */
	function events(){
		$(comp.btnEdit).on("click", editEvt);
		$(comp.btnDetail).on("click", detailEvt);
		$(comp.btnDelete).on("click", deleteEvt);
		$(comp.mdlDelete.btnSend).on("click", modalSaveEvt);
	}
	
	function activate(){
		console.debug("Activate de list");
	}
	
	return {
		activate: activate,
		events: events
	}
	
});