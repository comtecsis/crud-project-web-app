
package pe.com.comtecsis.crud.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import pe.com.comtecsis.crud.security.bean.CrudUserToken;

@Component
public class AppAuthenticationProvider implements AuthenticationProvider
{
	
	private static final Logger logger = LoggerFactory.getLogger(AppAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
    	logger.debug("Intento de acceso.");
    	return new CrudUserToken(authentication.getPrincipal(), authentication.getCredentials());
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
