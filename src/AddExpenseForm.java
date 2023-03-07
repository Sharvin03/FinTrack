import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExpenseForm extends JFrame{
    private ExpenseData expenseData;
    private double budget;
    private double remainingBudget;
    public User user;
    private JPanel pnlAddExpense;
    private JPanel pnlAddExp;
    private JLabel lblEntExp;
    private JTextField tfEnterExpense;
    private JLabel lblCategoryTitle;
    private JComboBox cbCategory;
    private JButton btnAdd;
    private JTextArea taExpenseList;
    private JLabel lblBudget;
    private JLabel lblRemainingBudget;
    private JLabel lblStatus;
    private JPanel pnlExpenseDetails;
    private JButton btnFilterAdd;

    public AddExpenseForm(ActionListener parent){
        budget = Double.parseDouble(JOptionPane.showInputDialog("Please enter your budget:"));
        lblBudget.setText("RM "+budget);
        remainingBudget = budget;
        //btnAdd.addActionListener(this);
        //btnFilterAdd.addActionListener(this);
        expenseData = new ExpenseData();
        lblRemainingBudget.setText("RM "+remainingBudget);
        setTitle("Add Expense");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\money.png");
        setIconImage(icon);
        setContentPane(pnlAddExpense);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category = (String) cbCategory.getSelectedItem();
                double expense = Double.parseDouble(tfEnterExpense.getText());
                if (expense <= remainingBudget) {
                    remainingBudget -= expense;
                    lblRemainingBudget.setText("RM" + remainingBudget);
                    expenseData.addExpense(category, expense);
                    taExpenseList.setText(expenseData.getExpenseList());
                    //taExpenseList.append(String.format("%s: $%.2f%n", category, expense));
                    cbCategory.setSelectedIndex(0);
                    tfEnterExpense.setText("");
                    //expenseData.addExpense(category, expense);
                } else {
                    lblStatus.setText("You have exceeded your budget!");
                }
            }
        });
        btnFilterAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilterExpenses filterExpenses = new FilterExpenses(expenseData);
                filterExpenses.setLocationRelativeTo(null);
                filterExpenses.setVisible(true);
                //new FilterExpenses(expenseData);
            }
        });
    }


    public static void main(String[] args) {
        AddExpenseForm addExpenseForm = new AddExpenseForm(null);
        User user = addExpenseForm.user;
    }
}
