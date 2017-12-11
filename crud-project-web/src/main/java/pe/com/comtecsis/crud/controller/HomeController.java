package pe.com.comtecsis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    @RequestMapping(value = "/")
    public ModelAndView welcome(){
	return new ModelAndView("base/index");
    }
    
    @RequestMapping(value = "/home")
    public ModelAndView home(){
	return new ModelAndView("home/home");
    }
    
}
