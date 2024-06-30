package com.electrika.tech.test;

import com.electrika.tech.controller.LoginController;
import com.electrika.tech.view.LoginView;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class Main {

    public static void main(String[] args) {
        //        FlatCarbonIJTheme.setup();
        FlatMacLightLaf.setup();
        LoginView frame = new LoginView();
        LoginController controller = new LoginController(frame);
    }
}
