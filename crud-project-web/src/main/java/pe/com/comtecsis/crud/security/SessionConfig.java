
package pe.com.comtecsis.crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class SessionConfig
{
    @Bean
    public CookieSerializer cookieSerializer()
    {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSION");
        serializer.setCookiePath("/");
        // DESA
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        // PROD
        /*serializer.setDomainName(domainName);
        serializer.setUseSecureCookie(true);*/
        serializer.setUseHttpOnlyCookie(true);
        return serializer;
    }
}
