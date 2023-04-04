import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationForm extends JFrame{

    public User user;
    private JPanel pnlNotification;
    private JLabel lblNoti;
    private JRadioButton rbNotiOn;
    private JRadioButton rbOff;
    private JRadioButton rbOn;

    public NotificationForm(){

    }
    public NotificationForm(ActionListener parent) {

        setTitle("Notification");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlNotification);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        rbOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,"Do you want to turn it back On?", "Notification",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "You have turned On Notification", "Notification On", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "You have kept Notification Off", "Notification Off", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        rbOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,"Sure? You want to turn off Notification?", "Notification",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "You have turned Off Notification", "Notification Off", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "You have kept Notification On", "Notification On", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void clrMode(int response) {
        if (response == 1){
            pnlNotification.setBackground(Color.BLACK);
        }
        else{
            pnlNotification.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        NotificationForm notificationForm = new NotificationForm(null);
        User user = notificationForm.user;

    }
}
