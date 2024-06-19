package com.electrika.tech.util;

import java.util.ResourceBundle;

public class ResourceBundleManager {

    public static ResourceBundle bundle;

    public static ResourceBundle getBundle() {
        return bundle;
    }
    public static void setBundle(ResourceBundle newBundle) {
        bundle = newBundle;
    }
}
