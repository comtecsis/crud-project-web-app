package pe.com.comtecsis.crud.service.impl;

import java.text.MessageFormat;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Service;

import pe.com.comtecsis.crud.domain.Translate;
import pe.com.comtecsis.crud.persistence.TranslateMapper;

@Service
public class DatabaseMessageSource extends AbstractMessageSource {

    @Resource
    TranslateMapper translateMapper;

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
	Translate translate = translateMapper.getTranslateByCodAndLocale(
		locale.getLanguage(), code);
	return new MessageFormat(translate.getLiteral());
    }

}