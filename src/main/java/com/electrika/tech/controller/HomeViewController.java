package com.electrika.tech.controller;

import com.electrika.tech.dao.DaoVendedor;
import com.electrika.tech.dao.impl.DaoVendedorImpl;
import com.electrika.tech.entidades.Vendedor;
import com.electrika.tech.util.LocaleManager;
import com.electrika.tech.view.*;
//import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class HomeViewController {

    HomeView vista;
    DaoVendedor dao;
    public static Vendedor vendedor;
    Locale locale = LocaleManager.getLocale();
    ResourceBundle bundle = ResourceBundle.getBundle("com.electrika.tech.properties/home", locale);

    public HomeViewController(HomeView vista) {
        this.vista = vista;
        vista.setLocationRelativeTo(vista);
        vista.setResizable(false);
//        vista.setIconImage(getIconImage());
        vista.setVisible(true);
        dao = new DaoVendedorImpl();
        vendedor = dao.getEmpleado();
        vista.jMenuName.setText(String.format("%s %s", bundle.getString("welcome"), vendedor.getNombreUsuario()));
        asignarLenguaje();
        agregarEvento();
    }

    public void asignarLenguaje() {
        vista.jMenuUsuario.setText(bundle.getString("user"));
        vista.jMenuCat.setText(bundle.getString("category"));
        vista.jMenuCliente.setText(bundle.getString("client"));
        vista.jMenuProd.setText(bundle.getString("product"));
        vista.jMenuProv.setText(bundle.getString("supplier"));
        vista.jMenuSignOut.setText(bundle.getString("exit"));
        vista.jMenuVentas.setText(bundle.getString("sales"));
    }

    public void agregarEvento() {
        vista.jMenuName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Icon icono = new ImageIcon(getClass().getResource("/felicidad.png"));
                //Hacer un vector random que te diga cosas al azar, que interesante la verdad!! :) 
                JOptionPane.showMessageDialog(null, String.format("¡¡Bienvenid@ %s a Electrika!!", vendedor.getNombreUsuario()), "Mensaje", JOptionPane.PLAIN_MESSAGE);

                //Creemos un vector
                String aleatorios[] = new String[10];

                //Creemos un random
                aleatorios[0] = "La vida es como una bicicleta, para mantener el equilibrio, debes seguir adelante.";
                aleatorios[1] = "Cada día es una página en blanco, ¿qué historia escribirás hoy?";
                aleatorios[2] = "La imaginación es el único límite para lo que podemos lograr.";
                aleatorios[3] = "A veces, la mejor respuesta es una sonrisa.";
                aleatorios[4] = "La vida es 10% lo que nos sucede y 90% cómo reaccionamos ante ello.";
                aleatorios[5] = "La vida es un lienzo; tú eres el artista.";
                aleatorios[6] = "Nunca subestimes el poder de una buena taza de café.";
                aleatorios[7] = "Sé la razón por la que alguien sonríe hoy.";
                aleatorios[8] = "La felicidad no se encuentra al final del camino, sino en el camino mismo.";
                aleatorios[9] = "Cambia tus pensamientos y cambiarás tu mundo.";

                int n = (int) (Math.random() * 10);

                JOptionPane.showMessageDialog(null, String.format("La Frase del día es: \n%s", aleatorios[n]), "Frase del día", JOptionPane.PLAIN_MESSAGE, icono);

            }
        });

        vista.jMenuUsuario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuUsuario();
            }
        });
        vista.jMenuCliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuCliente();
            }
        });
        vista.jMenuCat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuCat();
            }
        });
        vista.jMenuProd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuProducto();
            }
        });
        vista.jMenuVentas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuVentas();
            }
        });
        vista.jMenuProv.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuDistribuidor();
            }
        });
        vista.jMenuSignOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                loginSalida();
            }
        });
    }

    public void menuUsuario() {
        InterManageUser manage = new InterManageUser();
        VendedorController ven = new VendedorController(manage);
        manage.setSize(vista.desktopPane.getSize());
        manage.setLocation(0, 0);
        manage.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
//                manage.setLocation(0, 00); //posicion fija
                manage.setBounds(0, 0, manage.getWidth(), manage.getHeight());
            }
        });
//        manage.setSize(vista.desktopPane.getSize());
        vista.desktopPane.add(manage);
        manage.setVisible(true);
    }

    public void loginSalida() {
        vista.dispose();
        LoginView frame = new LoginView();
        LoginController controller = new LoginController(frame);
    }

    public void menuCat() {
        InterCategoria manage = new InterCategoria();
        CategoriaController cat = new CategoriaController(manage);
        manage.setSize(vista.desktopPane.getSize());
        manage.setLocation(0, 0);
        manage.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
//                manage.setLocation(0, 00); //posicion fija
                manage.setBounds(0, 0, manage.getWidth(), manage.getHeight());
            }
        });
//        manage.setSize(vista.desktopPane.getSize());
        vista.desktopPane.add(manage);
        manage.setVisible(true);
    }

    public void menuDistribuidor() {
        InterManageDistribuidor manage = new InterManageDistribuidor();
        DistribuidorController dis = new DistribuidorController(manage);
        manage.setSize(vista.desktopPane.getSize());

        manage.setLocation(0, 0);
        manage.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
//                manage.setLocation(0, 00); //posicion fija
                manage.setBounds(0, 0, manage.getWidth(), manage.getHeight());
            }
        });
//        manage.setSize(vista.desktopPane.getSize());

        vista.desktopPane.add(manage);
        manage.setVisible(true);
    }

    public void menuCliente() {
        //Vista
        InterManageClient manage = new InterManageClient();
        //Controlador
        ClienteController cc = new ClienteController(manage);
        manage.setSize(vista.desktopPane.getSize());
        manage.setLocation(0, 0);
        manage.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
//                manage.setLocation(0, 00); //posicion fija
                manage.setBounds(0, 0, manage.getWidth(), manage.getHeight());
            }
        });
//        manage.setSize(vista.desktopPane.getSize());
        vista.desktopPane.add(manage);
        manage.setVisible(true);
    }

    public void menuProducto() {
        //Vista
        InterManageProduct manage = new InterManageProduct();
        //Controlador
        ProductoController pc = new ProductoController(manage);
        manage.setSize(vista.desktopPane.getSize());
        manage.setLocation(0, 0);
        manage.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
//                manage.setLocation(0, 00); //posicion fija
                manage.setBounds(0, 0, manage.getWidth(), manage.getHeight());
            }
        });
//        manage.setSize(vista.desktopPane.getSize());

        vista.desktopPane.add(manage);
        manage.setVisible(true);
    }

    public void menuVentas() {
        //Vista
        InterPedido manage = new InterPedido();
        //Controlador
        PedidoController cc = new PedidoController(manage);
        manage.setSize(vista.desktopPane.getSize());
        manage.setLocation(0, 0);
        manage.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
//                manage.setLocation(0, 00); //posicion fija
                manage.setBounds(0, 0, manage.getWidth(), manage.getHeight());
            }
        });
//        manage.setSize(vista.desktopPane.getSize());
        vista.desktopPane.add(manage);
        manage.setVisible(true);
    }

//    public Image getIconImage() {
//        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/logo.png"));
//        return retValue;
//    }
}
