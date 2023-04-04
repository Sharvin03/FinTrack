import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeForm extends JFrame {
    private JPanel pnlTheme;
    private JLabel lblTheme;
    private JRadioButton rbDark;
    private JRadioButton rbLight;

    public ThemeForm(ActionListener parent){

        setTitle("Theme");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlTheme);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        rbDark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddExpenseForm form = (AddExpenseForm) parent;
                form.changeTheme(Color.BLACK);
            }
        });

        rbLight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddExpenseForm form = (AddExpenseForm) parent;
                form.changeTheme(Color.BLUE);
            }
        });

    }
}

