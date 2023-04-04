import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class dashboardForm extends JFrame {

    private JPanel dashboardPanel;

    private String name;
    private String email;
    private String phone;
    private JLabel lblAdmin;
    private JButton addExpensesButton;
    private JButton filterExpensesButton;
    private JButton tipsButton;
    private JButton settingsButton;
    private JPanel dashboardBtnPnl;
    private JButton savingsCalculatorButton;
    private JButton logoutButton;

    public dashboardForm() {
        setTitle("Dashboard");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(dashboardPanel);
        setMinimumSize(new Dimension(600, 529));
        setSize(700, 574);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        boolean hasRegisterdUsers = connectToDatabase();
        if (hasRegisterdUsers) {
            //show Login form
            LoginForm loginForm = new LoginForm(this);
            User user = loginForm.user;

            if (user != null) {
                lblAdmin.setText("User: " + user.getName());
                name = user.getName();
                email = user.getEmail();
                phone = user.getPhone();
                setLocationRelativeTo(null);
                setVisible(true);
            }
            else {
                dispose();
            }
        }
        else {
            //show Registration form
            RegistrationForm registrationForm = new RegistrationForm(this);
            User user = registrationForm.user;

            if (user != null) {
                lblAdmin.setText("User: " + user.getName());
                setLocationRelativeTo(null);
                setVisible(true);
            }
            else {
                dispose();
            }
        }

        tipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
                TipsForm tipsForm = new TipsForm(this);
                User user = tipsForm.user;
                tipsForm.setLocationRelativeTo(null);
                tipsForm.setVisible(true);
            }
        });

        addExpensesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddExpenseForm addExpenseForm = new AddExpenseForm(this);
                User user = addExpenseForm.user;
                addExpenseForm.setLocationRelativeTo(null);
                addExpenseForm.setVisible(true);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings settings = new Settings(this,name, email, phone);
                //User user = settings.user;
                settings.setLocationRelativeTo(null);
                settings.setVisible(true);
            }
        });
        savingsCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SavingsCalculator savingsCalculator = new SavingsCalculator(this);
                User user = savingsCalculator.user;
                savingsCalculator.setLocationRelativeTo(null);
                savingsCalculator.setVisible(true);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,"Sure? You want to exit?", "Logout",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "You have Logged Out", "Thank You", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Not Logged Out", "Thank You", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void clrMode(int response) {
        if (response == 1){
            dashboardPanel.setBackground(Color.BLACK);
        }
        else{
            dashboardPanel.setBackground(Color.BLUE);
        }
    }

    private boolean connectToDatabase() {
        boolean hasRegistredUsers = false;

        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost:3306/fintrackDB";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            //First, connect to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS fintrackDB");
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if not created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(200) NOT NULL,"
                    + "email VARCHAR(200) NOT NULL UNIQUE,"
                    + "phone VARCHAR(200),"
                    + "address VARCHAR(200),"
                    + "password VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);

            //check if we have users in the table users
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }
            }

            statement.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return hasRegistredUsers;
    }

    public static void main(String[] args) {
        dashboardForm myform = new dashboardForm();
    }


}


