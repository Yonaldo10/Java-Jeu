package views;

import javax.swing.*;
import java.awt.*;
import model.BatailleNavaleModel;

public class BatailleNavaleView extends JFrame {
    private BatailleNavaleModel model;
    private JButton[][] boutons;
    private JLabel lblMessage;

    public BatailleNavaleView() {
        model = new BatailleNavaleModel();
        boutons = new JButton[5][5];

        setTitle("Bataille Navale");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelGrille = new JPanel(new GridLayout(5, 5));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JButton btn = new JButton("~");
                btn.setFont(new Font("Arial", Font.BOLD, 14));
                final int l = i;
                final int c = j;
                btn.addActionListener(e -> tirer(l, c));
                boutons[i][j] = btn;
                panelGrille.add(btn);
            }
        }

        add(panelGrille, BorderLayout.CENTER);

        JPanel panelBas = new JPanel();
        lblMessage = new JLabel("Trouvez le bateau (case cachée)");
        JButton btnNouveau = new JButton("Nouvelle partie");
        JButton btnMenu = new JButton("Changer de jeu"); // ✅
        btnNouveau.addActionListener(e -> nouveauJeu());
        btnMenu.addActionListener(e -> { new MainMenuView().setVisible(true); dispose(); }); // ✅

        panelBas.add(lblMessage);
        panelBas.add(btnNouveau);
        panelBas.add(btnMenu);
        add(panelBas, BorderLayout.SOUTH);
    }

    private void tirer(int ligne, int colonne) {
        String resultat = model.tirer(ligne, colonne);
        lblMessage.setText(resultat);

        int etat = model.getGrille(ligne, colonne);
        if (etat == 1) {
            boutons[ligne][colonne].setText("X");
            boutons[ligne][colonne].setBackground(Color.RED);
        } else if (etat == 2) {
            boutons[ligne][colonne].setText("B");
            boutons[ligne][colonne].setBackground(Color.GREEN);
        }
    }

    private void nouveauJeu() {
        model.nouveauJeu();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boutons[i][j].setText("~");
                boutons[i][j].setBackground(null);
            }
        }
        lblMessage.setText("Trouvez le bateau (case cachée)");
    }
}