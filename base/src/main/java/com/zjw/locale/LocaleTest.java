package com.zjw.locale;

import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 *
 * Locale 测试
 *
 *
 * @author 朱俊伟
 * @since 2024/06/22 02:49
 */
public class LocaleTest {

    /**
     * getISOCountries 获取所有国家代码和名称
     */
    @Test
    public void ISOCountryTest(){
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
            Locale locale = new Locale.Builder().setRegion(countryCode).build();
            System.out.println(countryCode + " = " + locale.getDisplayCountry());
        }
    }

    /**
     * getISOLanguages 所有语言
     */
    @Test
    public void ISOLanguagesTest() {
        String[] languages = Locale.getISOLanguages();
        for (String language : languages) {
            Locale locale = new Locale.Builder().setLanguage(language).build();
            System.out.println(language + " = " + locale.getDisplayLanguage());
        }
    }

    /**
     * getAvailableLocales 获取所有可用语言
     */
    @Test
    public void availableLocalesTest() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            System.out.println(locale.getDisplayName());
        }
    }
}
