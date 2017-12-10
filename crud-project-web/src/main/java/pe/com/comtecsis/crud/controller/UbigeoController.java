package pe.com.comtecsis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/ubigeo")
public class UbigeoController {

    @RequestMapping(value = "/list")
    public ModelAndView list(){
	return new ModelAndView("ubigeo/list :: list");
    }
    
}
