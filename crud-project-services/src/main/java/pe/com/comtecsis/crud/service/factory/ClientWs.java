package pe.com.comtecsis.crud.service.factory;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.com.comtecsis.webservices.loginservices.LoginWebService;
import pe.com.comtecsis.webservices.loginservices.ServiceClientServicesPortType;

@Service
public class ClientWs {
  
  @Value("${crud-path}/wsdl/loginservice_1.wsdl")
  private String pathWsdl;
  
  public ServiceClientServicesPortType loginWs() throws MalformedURLException {
    ServiceClientServicesPortType loginWs =
        new LoginWebService(new URL(pathWsdl)).getLoginWebServicePort();
    return loginWs;
  }
  
}
