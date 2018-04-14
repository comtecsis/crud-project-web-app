package pe.com.comtecsis.crud.service.impl;

import java.net.MalformedURLException;
import java.text.MessageFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.comtecsis.crud.domain.Translate;
import pe.com.comtecsis.crud.persistence.TranslateMapper;
import pe.com.comtecsis.crud.service.LoginService;
import pe.com.comtecsis.crud.service.bean.User;
import pe.com.comtecsis.crud.service.enums.ConstantsEnum;
import pe.com.comtecsis.crud.service.exception.WsException;
import pe.com.comtecsis.crud.service.factory.ClientWs;
import pe.com.comtecsis.crud.service.factory.ExceptionWsFactory;
import pe.com.comtecsis.crud.service.factory.ResponseWsFactory;
import pe.com.comtecsis.crud.service.request.LoginRequest;
import pe.com.comtecsis.crud.service.response.InitResult;
import pe.com.comtecsis.crud.service.response.LoginResult;
import pe.com.comtecsis.crud.service.response.LogoutResult;
import pe.com.comtecsis.crud.service.response.ValidateResult;
import pe.com.comtecsis.crud.service.utils.ProcessWsProvider;
import pe.com.comtecsis.crud.service.utils.SessionWsManager;
import pe.com.comtecsis.webservices.loginservices.ServiceClientServicesPortType;
import pe.com.comtecsis.webservices.loginservices.WsException_Exception;

public class LoginServiceImpl implements LoginService {

  private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

  @Resource
  private TranslateMapper translateMapper;
  
  @Autowired
  private ResponseWsFactory responseWsFactory;

  @Autowired
  private ExceptionWsFactory exceptionWsFactory;

  @Autowired
  private ProcessWsProvider processWsProvider;
  
  @Autowired
  private SessionWsManager sessionWsManager;
  
  @Autowired
  private ClientWs clientWs;

  @Override
  public LoginResult login(LoginRequest request, WebServiceContext webServiceContext) throws WsException {
    Translate translate = translateMapper.getTranslateByCodAndLocale("es", "home-ubigeo-link");
    logger.info(MessageFormat.format("translate: {0}", translate.getLiteral()));

    LoginResult response = new LoginResult();

    try {
      ServiceClientServicesPortType loginWs = clientWs.loginWs();
      pe.com.comtecsis.webservices.loginservices.LoginRequest requestWs =
          new pe.com.comtecsis.webservices.loginservices.LoginRequest();
      BeanUtils.copyProperties(request, requestWs);
      pe.com.comtecsis.webservices.loginservices.InitResult resultWs = loginWs.init(requestWs);

      if (responseWsFactory.isValidResponse(resultWs.getCode())) {
        BindingProvider bp = (BindingProvider) loginWs;
        String cookie = processWsProvider.getCookie(bp);
        response.setSessionToken(cookie);
      } else {
        throw exceptionWsFactory.errorResponse(resultWs.getCode(), resultWs.getMessage());
      }
    } catch (MalformedURLException | WsException_Exception e) {
      throw exceptionWsFactory.errorWs(e);
    }
    responseWsFactory.success(response);
    return response;
  }

  @Override
  public InitResult init(LoginRequest request, WebServiceContext webServiceContext) {
    HttpSession session = sessionWsManager.createSession(webServiceContext);
    User user = new User();
    user.setUsername(request.getUsername());
    ConstantsEnum.USER.setAttribute(session, user);
    InitResult response = new InitResult();
    responseWsFactory.success(response);

    return response;
  }

  @Override
  public LogoutResult logout(WebServiceContext webServiceContext) throws WsException {
    HttpSession session = sessionWsManager.getSession(webServiceContext);
    LogoutResult response = new LogoutResult();
    if(session != null) {
      session.invalidate();
      responseWsFactory.success(response);
    }else {
      throw exceptionWsFactory.errorAccessWs();
    }
    return response;
  }

  @Override
  public ValidateResult validate(WebServiceContext webServiceContext) throws WsException {
    HttpSession session = sessionWsManager.getSession(webServiceContext);
    ValidateResult response = new ValidateResult();
    if(session != null) {
      User userSession = ConstantsEnum.USER.getAttribute(session, User.class);
      User userWs = new User();
      BeanUtils.copyProperties(userSession, userWs);
      response.setUser(userWs);
      responseWsFactory.success(response);
    }else {
      throw exceptionWsFactory.errorAccessWs();
    }
    return response;
  }
  
}
