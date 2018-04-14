package pe.com.comtecsis.crud.service.impl;

import java.text.MessageFormat;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Service;

import pe.com.comtecsis.crud.domain.Translate;
import pe.com.comtecsis.crud.persistence.TranslateMapper;

@Service
public class DatabaseMessageSource extends AbstractMessageSource {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseMessageSource.class);
	
    @Resource
    TranslateMapper translateMapper;

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
		Translate translate = translateMapper.getTranslateByCodAndLocale(
			locale.getLanguage(), code);
		if(translate == null) {
			logger.error(MessageFormat.format("El código <{0}> no se encuentra registrado o no se puede traducir.", code));
			return new MessageFormat("");
		}
		return new MessageFormat(translate.getLiteral());
    }

}