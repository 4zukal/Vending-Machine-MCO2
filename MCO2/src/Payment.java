public class Payment {
    private double payment;
    private double moneyBox;
    private double change;

    public Payment() {
        this.payment = 0.0;
        this.moneyBox = 0.0;
        this.change = 0.0;
    }

    public double addPayment(double amount) {
            this.payment += amount;

        return amount;
    }

    public double addMoneyBox(double amount) {
        this.payment += amount;

        return amount;
    }



    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double initializeMoneyBox(double moneyBox){
        return this.moneyBox = 1000.0;
    }

    public double getMoneyBox() {
        return moneyBox;
    }

    public void setMoneyBox(double moneyBox) {
        this.moneyBox = moneyBox;
    }

    public void dispenseChange(double amount) {
            this.change = payment;

        }


    public double getChange() {
        return change;
    }

    public void reset() {
        this.payment = 0.0;
        this.change = 0.0;
    }
}
