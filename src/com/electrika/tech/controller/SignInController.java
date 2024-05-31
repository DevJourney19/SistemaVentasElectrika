package com.electrika.tech.controller;

import com.electrika.tech.dao.DaoVendedor;
import com.electrika.tech.dao.impl.DaoVendedorImpl;
import com.electrika.tech.entidades.Vendedor;
import com.electrika.tech.view.HomeView;
import com.electrika.tech.view.SignInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class SignInController implements ActionListener {

    DaoVendedor dao;
    private List<Vendedor> lista;
    private SignInView view;

    public SignInController(SignInView view) {
        this.view = view;
        dao = new DaoVendedorImpl();
        lista = dao.select();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        agregarEventos();
        for (Vendedor ven : lista) {
            dao.iniciar(ven);
        }
    }

    private void agregarEventos() {
        view.btnini.addActionListener(this);

        view.txtNewNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo letras y espacio

                boolean numeros = (key >= 65 && key <= 90) || (key >= 97 && key <= 122) && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtNewApellido.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo letras y espacio

                boolean numeros = (key >= 65 && key <= 90) || (key >= 97 && key <= 122) && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtNewNombre.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                view.txtNewNombre.setText("");
            }
        });

        view.txtNewApellido.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                view.txtNewApellido.setText("");
            }
        });

        view.txtNewUsuario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                view.txtNewUsuario.setText("");
            }
        });

        view.txtNewContra.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                view.txtNewContra.setText("");
            }
        });
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Devolver el mismo texto si es nulo o vacío
        }

        // Convertir la primera letra a mayúscula y concatenar el resto del texto
        return String.format("%s%s", input.substring(0, 1).toUpperCase(), input.substring(1));

    }

    private void iniciar() {
        boolean bool1 = view.txtNewUsuario.getText().isEmpty() || view.txtNewContra.getPassword().length == 0 && view.txtNewNombre.getText().isEmpty();
        boolean bool2 = view.txtNewUsuario.getText().equals("Ingrese nombre de usuario") || view.txtNewContra.getPassword().length == 0 || view.txtNewNombre.getText().equals("Ingrese su nombre y apellido");
        if (bool1) {
            JOptionPane.showMessageDialog(null, "Ingresa los datos requeridos para acceder");
        } else if (bool2) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los datos");

        } else {
            Vendedor empl = new Vendedor(null, capitalizeFirstLetter(view.txtNewApellido.getText()), capitalizeFirstLetter(view.txtNewNombre.getText()), view.txtNewUsuario.getText(), view.txtNewContra.getText(), "", "2020-03-25", "2020-03-25");
            String mensaje = dao.insert(empl);
            dao.iniciar(empl);
            
           if (mensaje.equals("El nombre de usuario o contraseña ya existe")) {
                JOptionPane.showMessageDialog(null, mensaje);

            } else {
                //Bienvenido               
                JOptionPane.showMessageDialog(null, mensaje);
                HomeView prin = new HomeView();
                HomeViewController homc = new HomeViewController(prin);
                view.dispose();
            }
//           if (dao.insert(empl).getCodUsuario() > empl.getCodUsuario()) {
//                //Bienvenido               
////                JOptionPane.showMessageDialog(null, mensaje);
//                HomeView prin = new HomeView();
//                HomeViewController homc = new HomeViewController(prin);
//                view.dispose();
//            } else {
//                //El nombre de usuario o contraseña ya existe
//                System.out.println("El nombre de usuario o contraseña ya existe");
//            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnini) {
            iniciar();
        }
    }
}
