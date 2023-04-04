import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel loginPanel;
    private JButton btnRegisterLogin;
    private JLabel lblFrgtPass;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        lblFrgtPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                user = getAuthenticatedUser(email, password);

                if (user != null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                    "Email or Password Invalid",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

         btnRegisterLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registrationForm = new RegistrationForm(null);
                User user = registrationForm.user;
                if (user != null) {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "New user: " + user.getName(),
                            "Successful Registration",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        lblFrgtPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open the password reset dialog
                PasswordForm passwordForm = new PasswordForm(null);
                passwordForm.setLocationRelativeTo(null);
                passwordForm.setVisible(true);
            }
        });
        setVisible(true);
    }

    public User user; //Using this can access methods and variables in User class
    private User getAuthenticatedUser(String email, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/fintrackDB";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND user_password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("user_num"));
                user.setAddress(resultSet.getString("user_Address"));
                user.setPassword(resultSet.getString("user_password"));
            }
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;
        if (user != null) {
            System.out.println("Successful Authentication of: " + user.getName());
            System.out.println("          Email: " + user.getEmail());
            System.out.println("          Phone: " + user.getPhone());
            System.out.println("          Address: " + user.getAddress());
        }
        else {
            System.out.println("Authentication canceled");
        }
    }
}
