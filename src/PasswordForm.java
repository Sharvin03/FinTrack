import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordForm extends JDialog{

    public User user;

    private String email;

    private String password;
    private JPanel pnlPassword;
    private JLabel lblPassword;
    private JButton btnYes;

    public PasswordForm(JFrame parent){
        super(parent, "Password", true);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlPassword);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);

        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,"Confirmation for changing your Password?", "Password",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.YES_OPTION){
                    email = JOptionPane.showInputDialog("Enter Email: ");
                    password = JOptionPane.showInputDialog("Enter new Password: ");
                    updatePassword(email,password);
                    System.out.println("New Password: "+password);
                }else{
                    JOptionPane.showMessageDialog(null, "Password not changed", "Password", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    public void updatePassword(String email, String newPassword) {
        final String DB_URL = "jdbc:mysql://localhost:3306/fintrackDB";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "UPDATE users SET user_password = ? WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, email);
            statement.executeUpdate();
            statement.close();
            conn.close();
            System.out.println("Password updated successfully for email: " + email);
        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
    }


    public void clrMode(int response) {
        if (response == 1){
            pnlPassword.setBackground(Color.BLACK);
        }
        else{
            pnlPassword.setBackground(Color.BLUE);
        }
    }

    /*public static void main(String[] args) {
        PasswordForm passwordForm = new PasswordForm(null);
        User user = passwordForm.user;

    }*/
}
