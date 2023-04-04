import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class SavingsCalculator extends JFrame{
    private JPanel pnlSavingsCalculator;
    private JLabel lblPls;
    private JTextField tfAmountSave;
    private JLabel lblSave;
    private JTextField tfMonths;
    private JLabel lblYou;
    private JTextField tfSaving;
    private JButton btnCalculate;
    public User user;

    public SavingsCalculator(){

    }

    public SavingsCalculator(ActionListener parent){
        setTitle("Savings Calculator");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlSavingsCalculator);
        setMinimumSize(new Dimension(600, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecimalFormat df = new DecimalFormat("#.##");
                double amt = Double.parseDouble(tfAmountSave.getText());
                int months = Integer.parseInt(tfMonths.getText());
                double saveAmt = amt/months;
                String formattedNum = df.format(saveAmt);
                tfSaving.setText(formattedNum);
            }
        });
    }

    public void clrMode(int response) {
        if (response == 1){
            pnlSavingsCalculator.setBackground(Color.BLACK);
        }
        else{
            pnlSavingsCalculator.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        SavingsCalculator savingsCalculator = new SavingsCalculator(null);
        User user = savingsCalculator.user;
    }
}
