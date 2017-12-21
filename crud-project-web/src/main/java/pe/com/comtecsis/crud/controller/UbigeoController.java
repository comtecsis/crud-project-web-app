package pe.com.comtecsis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import pe.com.comtecsis.crud.bean.request.ReqUbigeo;

@Controller
@RequestMapping(value = "/ubigeo")
public class UbigeoController {

    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public ModelAndView list(){
	return new ModelAndView("ubigeo/list :: list");
    }
    
    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public ModelAndView create(){
	return new ModelAndView("ubigeo/create :: create");
    }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.POST})
    public ModelAndView edit(){
	return new ModelAndView("ubigeo/edit :: edit");
    }
    
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public ModelAndView detail(){
	return new ModelAndView("ubigeo/detail :: detail");
    }
    
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public ModelAndView delete(@RequestBody ReqUbigeo request){
	ModelAndView model = new ModelAndView();
	model.setView(new MappingJackson2JsonView());
	return model;
    }
    
}
