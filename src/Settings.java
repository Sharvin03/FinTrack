import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends JFrame{

    private String name;
    private String email;
    private String phone;

    public User user;
    private JButton btnProfile;
    private JButton btnPassword;
    private JButton btnTheme;
    private JButton btnNotification;
    private JPanel pnlSettings;

    public Settings(){

    }

    public Settings(ActionListener parent,String name, String email, String phone){
        setTitle("Settings");
        this.name = name;
        this.email = email;
        this.phone = phone;
        System.out.println("Name from settings: "+this.name);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlSettings);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile profile = new Profile(this,name, email, phone);
                profile.setLocationRelativeTo(null);
                profile.setVisible(true);
            }
        });
        btnPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordForm passwordForm = new PasswordForm(null);
                User user = passwordForm.user;
                passwordForm.setLocationRelativeTo(null);
                passwordForm.setVisible(true);
            }
        });
        btnTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemeForm themeForm = new ThemeForm(this);
                //User user = themeForm.user;
                themeForm.setLocationRelativeTo(null);
                themeForm.setVisible(true);
            }
        });
        btnNotification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotificationForm notificationForm = new NotificationForm(this);
                notificationForm.setLocationRelativeTo(null);
                notificationForm.setVisible(true);
            }
        });
    }

    public void clrMode(int response) {
        if (response == 1){
            pnlSettings.setBackground(Color.BLACK);
        }
        else{
            pnlSettings.setBackground(Color.BLUE);
        }
    }

    /*public static void main(String[] args) {
        Settings settings = new Settings(null);
        //User user = settings.user;
    }*/
}
