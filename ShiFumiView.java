package views;

import javax.swing.*;
import java.awt.*;
import model.ShiFumiModel;

public class ShiFumiView extends JFrame {
    private ShiFumiModel model;
    private JLabel lblResultat;

    public ShiFumiView() {
        model = new ShiFumiModel();

        setTitle("Shifumi");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelNord = new JPanel();
        JButton btnReset = new JButton("Reset scores");
        JButton btnMenu = new JButton("Changer de jeu"); // ✅
        btnReset.addActionListener(e -> reset());
        btnMenu.addActionListener(e -> { new MainMenuView().setVisible(true); dispose(); }); // ✅
        panelNord.add(btnReset);
        panelNord.add(btnMenu);
        add(panelNord, BorderLayout.NORTH);

        JPanel panelBoutons = new JPanel();
        JButton btnPierre = new JButton("Pierre");
        JButton btnFeuille = new JButton("Feuille");
        JButton btnCiseaux = new JButton("Ciseaux");

        btnPierre.addActionListener(e -> jouer("Pierre"));
        btnFeuille.addActionListener(e -> jouer("Feuille"));
        btnCiseaux.addActionListener(e -> jouer("Ciseaux"));

        panelBoutons.add(btnPierre);
        panelBoutons.add(btnFeuille);
        panelBoutons.add(btnCiseaux);
        add(panelBoutons, BorderLayout.CENTER);

        lblResultat = new JLabel("Cliquez sur un bouton pour jouer", SwingConstants.CENTER);
        add(lblResultat, BorderLayout.SOUTH);
    }

    private void jouer(String choix) {
        lblResultat.setText(model.jouer(choix));
    }

    private void reset() {
        model.resetScores();
        lblResultat.setText("Scores remis à zéro");
    }
}