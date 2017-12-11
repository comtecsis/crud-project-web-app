package pe.com.comtecsis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import pe.com.comtecsis.crud.bean.request.UbigeoDelete;

@Controller
@RequestMapping(value = "/ubigeo")
public class UbigeoController {

    @RequestMapping(value = "/list")
    public ModelAndView list(){
	return new ModelAndView("ubigeo/list :: list");
    }
    
    @RequestMapping(value = "/create")
    public ModelAndView create(){
	return new ModelAndView("ubigeo/create :: create");
    }
    
    @RequestMapping(value = "/edit")
    public ModelAndView edit(){
	return new ModelAndView("ubigeo/edit :: edit");
    }
    
    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestBody UbigeoDelete request){
	ModelAndView model = new ModelAndView();
	model.setView(new MappingJackson2JsonView());
	return model;
    }
    
}
