
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField korisnickoImeField;
    private JPasswordField lozinkaField;

    public LoginFrame() {
        setTitle("Login - Admin");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        add(new JLabel("Korisničko ime:"));
        korisnickoImeField = new JTextField();
        add(korisnickoImeField);
        add(new JLabel("Lozinka:"));
        lozinkaField = new JPasswordField();
        add(lozinkaField);
        JButton loginButton = new JButton("Prijava");
        loginButton.addActionListener(this::handleLogin);
        add(loginButton);
    }

    private void handleLogin(ActionEvent e) {
        String username = korisnickoImeField.getText();
        String password = new String(lozinkaField.getPassword());
        if (AdminAuthenticator.provjeriLogin(username, password)) {
            JOptionPane.showMessageDialog(this, "Uspješna prijava.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Neispravno korisničko ime ili lozinka.", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }
}
