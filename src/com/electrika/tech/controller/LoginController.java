package com.electrika.tech.controller;

//Para que los botones tengan eventos
import com.electrika.tech.dao.DaoVendedor;
import com.electrika.tech.dao.impl.DaoVendedorImpl;
import com.electrika.tech.entidades.Vendedor;
import com.electrika.tech.view.HomeView;
import com.electrika.tech.view.LoginView;
import com.electrika.tech.view.SignInView;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener {

    private LoginView view;
    DaoVendedor dao = new DaoVendedorImpl();

    public LoginController(LoginView view) {
        this.view = view;
        view.setLocationRelativeTo(null);
        view.setResizable(false);
        //view.setIconImage(getIconImage());
        view.setVisible(true);
        agregarEventos();

    }

    public void agregarEventos() {
        view.btnAceptar.addActionListener(this);
        view.btnCancelar.addActionListener(this);
        view.btnRegistrar.addActionListener(this);
    }

    public void loginAceptar() {
        if (view.txtUsuario.getText().isEmpty() || view.txtContra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debes ingresar tus datos completos");
        } else {
            String user = view.txtUsuario.getText();
            String pass = String.valueOf(view.txtContra.getPassword());
            Vendedor empl = dao.login(user, pass);
            dao.iniciar(empl);
            if (empl != null){
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
