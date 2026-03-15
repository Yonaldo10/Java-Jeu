package views;

import javax.swing.*;
import java.awt.*;

public class CalculatriceView extends JFrame {
    private JTextField ecran = new JTextField();
    private String n1 = "", n2 = "", op = "";

    public CalculatriceView() {
        setTitle("Calculatrice");
        setSize(300, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        ecran.setEditable(false);
        ecran.setHorizontalAlignment(JTextField.RIGHT);
        ecran.setFont(new Font("Arial", Font.BOLD, 20));
        add(ecran, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        for (String t : new String[]{"7","8","9","/","4","5","6","*","1","2","3","-","C","0","=","+"}) {
            JButton btn = new JButton(t);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(e -> clicBouton(t));
            panel.add(btn);
        }
        add(panel, BorderLayout.CENTER);

        JButton btnMenu = new JButton("Changer de jeu"); // ✅
        btnMenu.addActionListener(e -> { new MainMenuView().setVisible(true); dispose(); });
        add(btnMenu, BorderLayout.SOUTH);
    }

    private void clicBouton(String t) {
        if (t.equals("C")) { n1 = n2 = op = ""; ecran.setText(""); }
        else if (t.matches("[+\\-*/]")) { if (!n1.isEmpty()) { op = t; ecran.setText(n1 + " " + op); } }
        else if (t.equals("=")) {
            if (!n1.isEmpty() && !n2.isEmpty() && !op.isEmpty()) {
                double a = Double.parseDouble(n1), b = Double.parseDouble(n2), r = 0;
                if (op.equals("+")) r = a + b;
                else if (op.equals("-")) r = a - b;
                else if (op.equals("*")) r = a * b;
                else if (op.equals("/")) { if (b == 0) { ecran.setText("Erreur"); return; } r = a / b; }
                ecran.setText("" + r); n1 = "" + r; n2 = op = "";
            }
        } else {
            if (op.isEmpty()) { n1 += t; ecran.setText(n1); }
            else { n2 += t; ecran.setText(n1 + " " + op + " " + n2); }
        }
    }
}