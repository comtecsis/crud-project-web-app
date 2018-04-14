
package pe.com.comtecsis.crud.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class AccessDeniedEntryPoint extends LoginUrlAuthenticationEntryPoint
{

    private static final Logger logger = LoggerFactory.getLogger(AccessDeniedEntryPoint.class);

    public AccessDeniedEntryPoint(String loginFormUrl)
    {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException
    {
        logger.debug("Acceso denegado: ", authException);
        String header = request.getHeader("X-Requested-With");
        // XMLHttpRequest
        if ("XMLHttpRequest".equals(header))
        {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
        else
        {
            super.commence(request, response, authException);
        }

    }

}
