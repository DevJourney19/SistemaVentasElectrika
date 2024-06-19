package com.electrika.tech.controller;

//Para que los botones tengan eventos
import com.electrika.tech.dao.DaoVendedor;
import com.electrika.tech.dao.impl.DaoVendedorImpl;
import com.electrika.tech.entidades.Vendedor;
import com.electrika.tech.util.ResourceBundleManager;
import com.electrika.tech.view.HomeView;

import com.electrika.tech.view.LoginView;
import com.electrika.tech.view.SignInView;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Stack;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener {

    //Cambiamos a static, para poder llamar al metodo lenguaje 19/06/24
    private LoginView view;
    DaoVendedor dao = new DaoVendedorImpl();
    private ResourceBundle bundle;

    public LoginController(LoginView view) {
        this.view = view;
        view.setLocationRelativeTo(null);
        view.setResizable(false);
        //view.setIconImage(getIconImage());
        view.setVisible(true);
        agregarEventos();
        lenguajeDefecto();
    }

    /**
     * Se creó el metodo para poder asignar el lenguaje ingles como por defecto.
     * (Es una buena comprobación cuando el usuario no seleccione algún idioma)
     */
    public void lenguajeDefecto() {
        Locale locale = new Locale("en", "EN");
        ResourceBundle bundle
                = ResourceBundle.getBundle("com.electrika.tech.properties/distribuidor", locale);
        ResourceBundleManager.setBundle(bundle);
    }

    //Método escoger lenguaje
    public void agregarEventos() {
        view.btnAceptar.addActionListener(this);
        view.btnCancelar.addActionListener(this);
        view.btnRegistrar.addActionListener(this);
        view.cbLenguaje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectIndex = view.cbLenguaje.getSelectedIndex();
                Locale locale;
                ResourceBundle bundle;
            
                switch (selectIndex) {
                    case 0 -> {
                        locale = new Locale("en", "EN");   
                    }
                    case 1 -> {
                        locale = new Locale("es", "ES");                  
                    }
                    case 2 -> {
                        locale = new Locale("pt", "PT");
                    }
                    default -> {
                        System.out.println("Error");
                    }
                }
                bundle=ResourceBundle.getBundle("com.electrika.tech.properties/distribuidor", locale);
                ResourceBundleManager.setBundle(bundle);
            }
        }
        );
    }

    public void loginAceptar() {

        if (view.txtUsuario.getText().isEmpty() || view.txtContra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debes ingresar tus datos completos");
        } else {
            String user = view.txtUsuario.getText();
            String pass = String.valueOf(view.txtContra.getPassword());
            Vendedor empl = dao.login(user, pass);
            dao.iniciar(empl);
            if (empl != null) {
                HomeView home = new HomeView();
                HomeViewController homeC = new HomeViewController(home);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, dao.getMessage());
                view.txtUsuario.setText(null);
                view.txtContra.setText(null);
            }

        }
    }

    public void registrar() {
        SignInView signIn = new SignInView();
        SignInController signc = new SignInController(signIn);
        signIn.setLocationRelativeTo(null);
        view.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAceptar) {
            loginAceptar();
        } else if (e.getSource() == view.btnRegistrar) {
            registrar();
        } else if (e.getSource() == view.btnCancelar) {
            System.exit(0);
        }
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/electrika/tech/img/logo - Copy.png"));
        return retValue;
    }
}
