package com.electrika.tech.util;

import java.util.Locale;

public class LocaleManager {

    public static Locale locale;

    public static Locale getLocale() {
        return locale;
    }
    public static void setLocale(Locale newLocale) {
        locale = newLocale;
    }
}
