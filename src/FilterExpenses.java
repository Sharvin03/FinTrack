import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterExpenses extends JFrame implements ActionListener{
    public User user;
    private JPanel pnlFilterExpenses;
    private JPanel pnlFilExp;
    private JLabel lblFilterText;
    private JComboBox cbFilterCategory;
    private JPanel pnlFiltered;
    private JTextArea taFiltered;
    private JLabel lblAverageTitle;
    private JLabel lblAvg;
    private JButton btnFilter;
    private ExpenseData expenseData;

    public FilterExpenses(){

    }

    public FilterExpenses(ExpenseData expenseData){
        setTitle("Filter Expenses");
        this.expenseData = expenseData;
        btnFilter.addActionListener(this);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlFilterExpenses);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String category = (String) cbFilterCategory.getSelectedItem();
        taFiltered.setText(expenseData.getFilteredExpenses(category));
        double average = expenseData.getAverageExpense(category);
        lblAvg.setText(String.format("RM%.2f", average));
    }

    public void clrMode(int response) {
        if (response == 1){
            pnlFilterExpenses.setBackground(Color.BLACK);
        }
        else{
            pnlFilterExpenses.setBackground(Color.BLUE);
        }
    }
    public static void main(String[] args){
        FilterExpenses filterExpenses = new FilterExpenses(null);
        User user = filterExpenses.user;
    }

}
