package pe.com.comtecsis.crud.service.utils;

import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProcessWsProvider {

  @SuppressWarnings("unchecked")
  public String getCookie(BindingProvider bp) {
    Map<String, Object> ctx = bp.getResponseContext();
    Map<String, List<String>> map =
        (Map<String, List<String>>) ctx.get(MessageContext.HTTP_RESPONSE_HEADERS);
    String cookie = evalValueHeader(map.get("Set-Cookie"));
    return parseCookie(cookie);
  }

  public String evalValueHeader(List<String> value) {
    StringBuffer strBuf = new StringBuffer();
    if (value != null) {
      for (String type : value) {
        strBuf.append(type);
      }
    }
    return strBuf.toString();
  }

  private String parseCookie(String cookie) {
    if (StringUtils.isNotBlank(cookie)) {
      int begin = cookie.indexOf('=') + 1;
      int end = cookie.indexOf(';');
      return cookie.substring(begin, end);
    }
    return cookie;
  }

}
