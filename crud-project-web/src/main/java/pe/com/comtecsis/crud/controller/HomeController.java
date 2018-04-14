package pe.com.comtecsis.crud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    @Value("${delay.ajax}")
    private String delayAjax;
    
    public HomeController() {
    }
    
    private ModelAndView modelHome(){
	ModelAndView model = new ModelAndView();
	return model;
    }

    @RequestMapping(value = "/")
    public ModelAndView welcome() {
	ModelAndView model = modelHome();
	
	model.addObject("delayAjax", delayAjax);
	
	model.setViewName("base/index");
	return model;
    }

    @RequestMapping(value = "/home")
    public ModelAndView home() {
	ModelAndView model = modelHome();
	model.setViewName("home/home");
	return model;
    }

}
