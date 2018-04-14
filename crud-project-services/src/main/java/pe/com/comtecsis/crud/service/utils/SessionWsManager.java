package pe.com.comtecsis.crud.service.utils;

import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.springframework.stereotype.Service;

@Service
public class SessionWsManager {
  
  public HttpSession createSession(WebServiceContext webServiceContext) {
    return getSession(webServiceContext, true);
  }
  
  public HttpSession getSession(WebServiceContext webServiceContext) {
    return getSession(webServiceContext, false);
  }
  
  private HttpSession getSession(WebServiceContext webServiceContext, boolean create) {
    MessageContext mc;
    mc = webServiceContext.getMessageContext();
    HttpSession session =
        ((javax.servlet.http.HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST))
            .getSession(create);
    return session;
  }
  
}
