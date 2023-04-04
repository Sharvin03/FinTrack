import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Profile extends JFrame{


    private User user;

    private String name;
    private String email;
    private String phone;
    private JPanel pnlProfile;
    public JLabel lblNameTitle;
    private JLabel lblPhoneTitle;
    private JLabel lblEmailTitle;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPhone;

    public Profile(){

    }

    public Profile(ActionListener parent, String name, String email, String phone){
        setTitle("Profile");
        this.name = name;
        this.email = email;
        this.phone = phone;
        lblName.setText(this.name);
        lblEmail.setText(this.email);
        lblPhone.setText(this.phone);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlProfile);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void clrMode(int response) {
        if (response == 1){
            pnlProfile.setBackground(Color.BLACK);
        }
        else{
            pnlProfile.setBackground(Color.BLUE);
        }
    }




    /*public static void main(String[] args) {
        Profile profile= new Profile(null);

    }*/
}
