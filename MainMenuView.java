package views;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {

    public MainMenuView() {
        setTitle("Jeux - BTS SIO");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnDevine = new JButton("Devine le nombre");
        JButton btnShiFumi = new JButton("ShiFumi");
        JButton btnNavale = new JButton("Bataille Navale");
        JButton btnCalc = new JButton("Calculatrice");

        btnDevine.addActionListener(e -> new DevineNombreView().setVisible(true));
        btnShiFumi.addActionListener(e -> new ShiFumiView().setVisible(true));
        btnNavale.addActionListener(e -> new BatailleNavaleView().setVisible(true));
        btnCalc.addActionListener(e -> new CalculatriceView().setVisible(true));

        add(new JLabel("Choisissez un jeu :", SwingConstants.CENTER));
        add(btnDevine);
        add(btnShiFumi);
        add(btnNavale);
        add(btnCalc);
    }
}