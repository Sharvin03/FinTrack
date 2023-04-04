import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TipsForm extends JFrame{


    public User user;
    private JPanel tipsPanel;
    private JLabel lblTips;
    private JPanel pnlTips1;
    private JTextArea taTips;

    public TipsForm(){

    }

    public TipsForm(ActionListener parent){
        //super(parent);
        setTitle("Tips");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(tipsPanel);
        setMinimumSize(new Dimension(450, 474));
        //setModal(true);
        //setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    public static void main(String[] args) {
        TipsForm tipsForm = new TipsForm(null);
        User user = tipsForm.user;

    }
}
