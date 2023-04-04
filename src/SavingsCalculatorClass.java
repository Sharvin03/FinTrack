import java.awt.event.ActionListener;

public class SavingsCalculatorClass{
    double amount;
    int months;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double calcSaveAmt(){
        double saveAmt = 0;
        saveAmt = this.amount/this.months;
        return saveAmt;
    }
}
