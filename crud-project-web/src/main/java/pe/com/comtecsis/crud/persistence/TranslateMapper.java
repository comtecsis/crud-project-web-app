package pe.com.comtecsis.crud.persistence;

import org.apache.ibatis.annotations.Param;

import pe.com.comtecsis.crud.domain.Translate;

public interface TranslateMapper {
    public Translate getTranslateByCodAndLocale(@Param("locale") String locale, @Param("code") String code);
}
