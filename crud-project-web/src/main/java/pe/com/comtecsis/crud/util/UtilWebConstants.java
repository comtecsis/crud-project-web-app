package pe.com.comtecsis.crud.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UtilWebConstants
{
    // MvcConfig
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final String ENCODING_CP1252 = "Cp1252";
    public static final String LOCALE_ES_PE = "es-PE";
    public static final String COOKIE_TB_LOCALE = "cookie_tb_locale";
    public static final String PARAMETER_LOCALE = "lang";
    public static final String RESOURCES_LOCATION = "/resources/";
    
    @Value("${context}/loginPage")
    private String urlLoginPage;
    
    @Value("${context}")
    private String context;
    
    @Value("${urlLogin}")
    private String urlLogin;
    
    private UtilWebConstants()
    {
    }
    
    public String getContext() {
		return context;
	}
    
    public String getUrlLoginPage() {
		return urlLoginPage;
	}
    
    public String getUrlLogin() {
    	return urlLogin;
    }
}