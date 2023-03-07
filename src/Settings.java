import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame{
    public User user;
    private JButton btnProfile;
    private JButton btnPassword;
    private JButton btnTheme;
    private JButton btnNotification;
    private JPanel pnlSettings;

    public Settings(ActionListener parent){
        setTitle("Settings");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlSettings);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNotification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        Settings settings = new Settings(null);
        User user = settings.user;

    }
}
