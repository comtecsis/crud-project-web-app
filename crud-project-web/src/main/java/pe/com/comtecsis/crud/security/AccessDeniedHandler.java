
package pe.com.comtecsis.crud.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import pe.com.comtecsis.crud.util.UtilWebConstants;
import pe.com.comtecsis.crud.util.UtilWebFunctions;

@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler
{
    private static final Logger logger = LoggerFactory.getLogger(AccessDeniedHandler.class);

    @Autowired
    UtilWebFunctions utilWebFunctions;


    @Autowired
    UtilWebConstants utilWebConstants;
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException
    {
        logger.error("Acceso denegado: ", accessDeniedException);
        if (!utilWebFunctions.responseAjaxError(request, response, HttpServletResponse.SC_FORBIDDEN ))
        {
            response.setHeader("X-ERROR-TYPE", "INVALID_SESSION_ERROR");
            response.sendRedirect(utilWebConstants.getUrlLoginPage());
        }
    }
}
