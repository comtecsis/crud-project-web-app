
package pe.com.comtecsis.crud.service.handlers;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionHandler implements SOAPHandler<SOAPMessageContext> {

  private static final Logger logger = LoggerFactory.getLogger(SessionHandler.class);

  private static final String SESSION_TOKEN_HEADER_ELEMENT = "X-AUTH-TOKEN";
  private static final String USER_CONTEXT_PARAM = "USER";

  @Override
  public boolean handleMessage(SOAPMessageContext context) {
    Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if ((outbound != null) && (!outbound.booleanValue())) {
      return handleInboundHTTPMessage(context);
    }
    return true;
  }

  @Override
  public boolean handleFault(SOAPMessageContext context) {

    return false;
  }

  @Override
  public void close(MessageContext context) {


  }

  @Override
  public Set<QName> getHeaders() {

    return null;
  }

  @SuppressWarnings("unchecked")
  private boolean handleInboundHTTPMessage(SOAPMessageContext context) {
    try {
      Map<String, List<String>> map =
          (Map<String, List<String>>) context.get(MessageContext.HTTP_REQUEST_HEADERS);

      String token = getElement(getHTTPHeader(map, SESSION_TOKEN_HEADER_ELEMENT));

      /*
       * LoginServiceClient client = new LoginServiceClient(); User user =
       * client.validateSession(usercode, contract, token);
       */

      context.put(USER_CONTEXT_PARAM, null);
      context.setScope(USER_CONTEXT_PARAM, Scope.APPLICATION);

      context.put(SESSION_TOKEN_HEADER_ELEMENT, token);
      context.setScope(SESSION_TOKEN_HEADER_ELEMENT, Scope.APPLICATION);

    } catch (Exception e) {
      logger.error(MessageFormat.format("HANDLER ERROR: {0}", e.getMessage()), e);
      return false;
    }
    return true;
  }

  private String getElement(List<String> elements) {
    StringBuffer strBuf = new StringBuffer();
    if (elements != null) {
      for (String type : elements) {
        strBuf.append(type);
      }
    }
    return strBuf.toString();
  }

  private List<String> getHTTPHeader(Map<String, List<String>> headers, String header) {
    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
      String name = entry.getKey();
      if (name.equalsIgnoreCase(header))
        return entry.getValue();
    }
    return null;
  }
}
