public class Items {
    private String item;
    private int qty;
    private double price;
    private double calorieCount;

    public Items(String item, int qty, double price){
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.calorieCount = calorieCount;
    }

    public String getItem(){
        return this.item;
    }
    public int getQty(){return this.qty;}
    public double getPrice(){
        return this.price;
    }
    public double getCalorieCount(){
        return this.calorieCount;
    }
    public void setItem(String item){
        this.item = item;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCalorieCount(double calorieCount){
        this.calorieCount = calorieCount;
    }
}
