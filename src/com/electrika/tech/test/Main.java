package com.electrika.tech.test;

import com.electrika.tech.controller.LoginController;
import com.electrika.tech.view.LoginView;

public class Main {

    public static void main(String[] args) {

        LoginView frame = new LoginView();
        LoginController controller = new LoginController(frame);
        
    }
}
