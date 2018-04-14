
package pe.com.comtecsis.crud.security;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import pe.com.comtecsis.crud.util.UtilWebConstants;

@Component
public class LogoutHandlerCustom implements LogoutHandler
{
    private static final Logger logger = LoggerFactory.getLogger(LogoutHandlerCustom.class);

    @Autowired
    UtilWebConstants utilWebConstants;
    
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        try
        {
            response.sendRedirect(utilWebConstants.getUrlLoginPage());
        }
        catch (IOException e)
        {
            logger.error("Error al redireccionar a login.",e);
        }
    }

}
