
//RegistrationForm
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;


public class RegistrationForm extends JDialog {
    Name nameClass;
    //Address addressClass = new Address();
    Email emailClass;
    Address addressClass;
    Phone phoneClass;
    Password passwordClass;

    private JPanel registerPanel;
    private JLabel lblRegister;
    private JTextField tfFName;
    private JLabel lblName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JLabel lblPhone;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JLabel lblCfrmPass;
    private JLabel lblPassword;
    private JLabel lblEmail;
    private JButton btnRegister;
    private JButton btnCancel;
    private JTextField tfStreet;
    private JTextField tfMname;
    private JTextField tfLname;
    private JTextField tfDistrict;
    private JTextField tfPostcode;
    private JTextField tfState;

    public RegistrationForm(JFrame parent) {
       super(parent);
        setTitle("Create a new account");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(490, 677));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    private void registerUser() {
        nameClass = new Name(tfFName.getText(),tfMname.getText(),tfLname.getText());
        emailClass = new Email(tfEmail.getText());
        addressClass = new Address(tfStreet.getText(),tfDistrict.getText(),tfPostcode.getText(),tfState.getText());
        passwordClass = new Password(String.valueOf(pfPassword.getPassword()),String.valueOf(pfConfirmPassword.getPassword()));
        phoneClass = new Phone(tfPhone.getText());

        int total = passwordClass.getPassword().length();
        int  upChars=0, lowChars=0;
        int special=0, digits=0;
        char ch;

        if (nameClass.getFname().isEmpty() ||nameClass.getMname().isEmpty()||nameClass.getLname().isEmpty()|| emailClass.getEmail().isEmpty() || phoneClass.getPhone().isEmpty() || addressClass.getStreet().isEmpty() || addressClass.getDistrict().isEmpty()||addressClass.getPostcode().isEmpty()||addressClass.getState().isEmpty()||passwordClass.getPassword().isEmpty()||passwordClass.getConfirmPassword().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (total < 8){
            JOptionPane.showMessageDialog(this,
                    "Password should be at least 8 characters",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for(int i=0; i<total; i++)
        {
            ch = passwordClass.getPassword().charAt(i);
            if(Character.isUpperCase(ch))
                upChars = 1;
            else if(Character.isLowerCase(ch))
                lowChars = 1;
            else if(Character.isDigit(ch))
                digits = 1;
            else
                special = 1;
        }

        if(upChars != 1){
            JOptionPane.showMessageDialog(this,
                    "Password Should include at least 1 Upper-case letter",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(lowChars != 1){
            JOptionPane.showMessageDialog(this,
                    "Password Should include at least 1 Lower-case letter",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(digits != 1){
            JOptionPane.showMessageDialog(this,
                    "Password Should include at least 1 Digit",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(special != 1){
            JOptionPane.showMessageDialog(this,
                    "Password Should include at least 1 Special/Symbol",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!passwordClass.getPassword().equals(passwordClass.getConfirmPassword())) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        user = addUserToDatabase(nameClass.getFname()+" "+nameClass.getMname()+" "+nameClass.getLname(),emailClass.getEmail(), phoneClass.getPhone(), addressClass.getStreet()+" "+addressClass.getDistrict()+" "+addressClass.getPostcode()+" "+addressClass.getState(), passwordClass.getPassword());
        if (user != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;
    private User addUserToDatabase(String finalName, String finalEmail, String finalPhone, String finalAddress, String finalPassword) {
        System.out.println("Name: "+finalName);
        System.out.println("E-mail: "+finalEmail);
        System.out.println("Phone: "+finalPhone);
        System.out.println("Address: "+finalAddress);
        System.out.println("Password: "+finalPassword);
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/fintrackDB";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (user_name, email, user_num, user_Address, user_password) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, finalName);
            preparedStatement.setString(2, finalEmail);
            preparedStatement.setString(3, finalPhone);
            preparedStatement.setString(4, finalAddress);
            preparedStatement.setString(5, finalPassword);

            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.setName(finalName);
                user.setEmail(finalEmail);
                user.setPhone(finalPhone);
                user.setAddress(finalAddress);
                user.setPassword(finalPassword);
            }
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
        User user = myForm.user;
        if (user != null) {
            System.out.println("Successful registration of: " + user.getName());
        }
        else {
            System.out.println("Registration canceled");
        }
    }
}
