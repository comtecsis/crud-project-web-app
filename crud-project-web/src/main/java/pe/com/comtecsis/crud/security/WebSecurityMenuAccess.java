package pe.com.comtecsis.crud.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import pe.com.comtecsis.crud.security.bean.CrudUserToken;

@Component("menuAccessCheck")
public class WebSecurityMenuAccess {
	
	public WebSecurityMenuAccess(){
	}
	
	public boolean hasAccess(Authentication authentication,String optionCode, HttpServletRequest request){
		
		boolean hasAccess = false;		
		if(authentication instanceof CrudUserToken)
		{		
			hasAccess = true;
		}
		return hasAccess;
	}

}
