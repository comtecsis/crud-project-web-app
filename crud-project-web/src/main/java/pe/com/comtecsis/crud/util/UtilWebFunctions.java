package pe.com.comtecsis.crud.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UtilWebFunctions {
	
	private static final Logger logger = LoggerFactory.getLogger(UtilWebFunctions.class);
	
	public boolean responseAjaxError(HttpServletRequest request, HttpServletResponse response, int codeError) throws IOException
    {
        String header = request.getHeader("X-Requested-With");
        boolean isAjaxPetition = "XMLHttpRequest".equals(header);
        if (isAjaxPetition)
        {
            logger.info("Es llamada ajax");
            response.sendError(codeError);
        }
        return isAjaxPetition;
    }
	
}
