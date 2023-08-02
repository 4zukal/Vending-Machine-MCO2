import java.util.ArrayList;

public class RegVendingMachine {
    private String name;
    private String Display;
    private Payment payment;

    private int numOfProds;

    private static String[] prodNames;
    private static double[] prodPrices;
    private static int[] prodQty;

    private static double[] prodCalorie;
    private int totalMoneyInside = 0;
    private static ArrayList<Integer>  itemList = new ArrayList<>();

    public RegVendingMachine(String name, String Display, Items items, Payment payment){
        this.name = name;
        this.Display = Display;
        this.payment = payment;
    }

    public RegVendingMachine(){
        this.name = name;
        this.Display = Display;
        this.payment = payment;
    }

    //create a constructor for the vending machine
    public RegVendingMachine(String name, String[] prodNames, double[] prodPrices, int[] prodQty, double[] prodCalorie){
        this.name = name;
        this.prodNames = prodNames;
        this.prodPrices = prodPrices;
        this.prodQty = prodQty;
        this.prodCalorie = prodCalorie;
    }

    public String getName(){
        return this.name = name;
    }
    public String setName(String name){
        return this.name = name;
    }
    public void displayItems(){
        System.out.println("=======================================");
        System.out.println("Vending Machine Name: " + this.name);
        System.out.println("=======================================");
        System.out.println("Items: ");
        for(int i = 0; i < prodNames.length; i++){
            System.out.println("Item " + (i + 1) + ": " + prodNames[i]);
            System.out.println("Price of " + prodNames[i] + ": " + prodPrices[i]);
            System.out.println("Calorie Count of " + prodNames[i] + ": " + prodCalorie[i]);
            System.out.println("Quantity of " + prodNames[i] + ": " + prodQty[i]);
            System.out.println();
            System.out.println("=======================================");
            System.out.println();
        }
        System.out.println("=======================================");
    }

    public int getNumOfProds(){
        return this.numOfProds = numOfProds;
    }
    public int setNumOfProds(int numOfProds){
        return this.numOfProds = numOfProds;
    }

    public String[] getProdNames(){
        return this.prodNames = prodNames;
    }
    public String[] setProdNames(String[] prodNames){
        return this.prodNames = prodNames;
    }
    public double[] getProdPrices(){
        return this.prodPrices = prodPrices;
    }

    public double[] setProdPrices(double[] prodPrices){
        return this.prodPrices = prodPrices;
    }
    public int[] getProdQty(){
        return this.prodQty = prodQty;
    }
    public int[] setProdQty(int[] prodQty){
        return this.prodQty = prodQty;
    }
    public double[] getProdCalorie(){
        return this.prodCalorie = prodCalorie;
    }
    public double[] setProdCalorie(double[] prodCalorie) {
        return this.prodCalorie = prodCalorie;
    }

     // return new int[]{this.prodQty[Integer.parseInt(ItemName)] = prodQty[Integer.parseInt(ItemName)] + add};
    public void addItemQty(String ItemName, int add){
      
        for (int i = 0; i < prodNames.length; i++) {
        if (prodNames[i].equals(ItemName)) {
            prodQty[i] += add;
            i=500;
            if(i==500){
                System.out.println("item FOUND");
            }
        }else{
            if( i==prodNames.length)
             System.out.println("==!!NO ITEM FOUND!!==");
        }
        
    }
    }

    public void buyItem(String ItemName, double pay){

        for (int i = 0; i < prodNames.length; i++) {
            if (prodNames[i].equals(ItemName)) {
                prodQty[i] -= 1;
                pay -= prodPrices[i];
                i=500;
                if(i==500){
                    System.out.println("item FOUND");

                }
            }else{
                if( i==prodNames.length)
                    System.out.println("==!!NO ITEM FOUND!!==");
            }

        }
    }

    public double getItemPrice(String ItemName){
        for (int i = 0; i < prodNames.length; i++) {
            if (prodNames[i].equals(ItemName)) {
                return prodPrices[i];
            }
        }
        return 0;
    }

    public int getItemQty(String ItemName){
        for (int i = 0; i < prodNames.length; i++) {
            if (prodNames[i].equals(ItemName)) {
                return prodQty[i];
            }
        }
        return 0;
    }

    public int changeItemQty(int change, int index){
        return this.prodQty[index] = prodQty[index] - change;
    }
    public double changeItemPrice(String ItemName, double newPrice){
        return this.prodPrices[Integer.parseInt(ItemName)] = prodPrices[Integer.parseInt(ItemName)] = newPrice;
    }
    ///DISPLAY LSIT
    public void displayList(int flag, int itemIndex){
        int sum=0;
        if(flag==1){ // 1 means add to transaction ,2 will mean display
            

            itemList.add(itemIndex);

        }
        else if(flag ==2)
        {   
            
            System.out.println("!!TRANSACTION HISTORY!!");
            for (int i=0; i < itemList.size();i++ ) {

            System.out.println("ITEM SOLD: "+prodNames[itemList.get(i)]+" ||PROFIT = "+prodPrices[itemList.get(i)]+"php");
            sum+= prodPrices[itemList.get(i)];
          
        }
            displayItems();
            System.out.println("TOTAL PROFIT = "+sum+"php");

        }
    }

}
