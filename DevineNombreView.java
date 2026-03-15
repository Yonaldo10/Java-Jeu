package views;

import javax.swing.*;
import java.awt.*;
import model.DevineNombreModel;

public class DevineNombreView extends JFrame {
    private DevineNombreModel model;
    private JTextField txtProposition;
    private JLabel lblMessage;
    private JButton btnVerifier;
    private JButton btnNouveau;

    public DevineNombreView() {
        model = new DevineNombreModel();

        setTitle("Devine le nombre");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JLabel lblInstruction = new JLabel("J'ai choisi un nombre entre 1 et 100", SwingConstants.CENTER);
        add(lblInstruction);

        JPanel panelSaisie = new JPanel();
        panelSaisie.add(new JLabel("Votre proposition :"));
        txtProposition = new JTextField(10);
        txtProposition.addActionListener(e -> verifier());
        panelSaisie.add(txtProposition);
        add(panelSaisie);

        lblMessage = new JLabel("", SwingConstants.CENTER);
        add(lblMessage);

        JPanel panelBoutons = new JPanel();
        btnVerifier = new JButton("Vérifier");
        btnNouveau = new JButton("Nouveau jeu");
        JButton btnMenu = new JButton("Changer de jeu"); // ✅
        panelBoutons.add(btnVerifier);
        panelBoutons.add(btnNouveau);
        panelBoutons.add(btnMenu);
        add(panelBoutons);

        btnVerifier.addActionListener(e -> verifier());
        btnNouveau.addActionListener(e -> nouveauJeu());
        btnMenu.addActionListener(e -> { new MainMenuView().setVisible(true); dispose(); }); // ✅
    }

    private void verifier() {
        try {
            int proposition = Integer.parseInt(txtProposition.getText());
            String message = model.verifierProposition(proposition);
            lblMessage.setText(message);
            txtProposition.setText("");

            if (message.startsWith("Bravo")) {
                txtProposition.setEnabled(false);
                btnVerifier.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            lblMessage.setText("Veuillez entrer un nombre valide");
        }
    }

    private void nouveauJeu() {
        model.nouveauJeu();
        lblMessage.setText("");
        txtProposition.setText("");
        txtProposition.setEnabled(true);
        btnVerifier.setEnabled(true);
    }
}