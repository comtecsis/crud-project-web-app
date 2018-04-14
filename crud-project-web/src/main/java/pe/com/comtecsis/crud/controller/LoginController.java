package pe.com.comtecsis.crud.controller;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.comtecsis.crud.security.bean.CrudUserToken;
import pe.com.comtecsis.crud.util.UtilWebConstants;

@Controller
public class LoginController {
	
	@Resource
	private MessageSource messageSource;
	
	@Autowired
	private UtilWebConstants utilWebConstants; 
	
	@GetMapping("/loginPage")
    public ModelAndView buildLoginPage(@AuthenticationPrincipal CrudUserToken userNameToken,
            HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if (userNameToken != null)
        {
            response.sendRedirect(utilWebConstants.getContext());
        }
        ModelAndView model = new ModelAndView();
        String auth = request.getParameter("auth");
        HttpSession session = request.getSession(false);

        if (session != null)
        {
            session.setMaxInactiveInterval(-1);
            if ("failure".equals(auth))
            {
                Object exObject = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
                if (exObject != null)
                {
                    AuthenticationException authEx = (AuthenticationException) exObject;
                    Locale locale = LocaleContextHolder.getLocale();
                    model.addObject("errorMessage", messageSource.getMessage(authEx.getMessage(), null, locale));
                }
            }
        }
        
        model.addObject("loginUrl", utilWebConstants.getUrlLogin());
        
        model.setViewName("base/login");
        return model;
    }
}
