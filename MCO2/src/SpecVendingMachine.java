import java.util.ArrayList;

public class SpecVendingMachine {


    private int numOfFlavors;

    private int numOfSinkers;

    private String[] milkTeaFlavor;
    private double[] milkTeaFlavorPrices;
    private int[] milkTeaFlavorServing;
    private  double[] milkTeaFlavorCalories;
    private String[] sinkers;
    private  double[] sinkersPrices;
    private int[] sinkerServing;
    private double[] sinkersCalories;
    private int sugarLevel;
    private int size;
    private String name;
      private static ArrayList<Integer>  itemList = new ArrayList<>();
      private static ArrayList<Integer>  itemList2 = new ArrayList<>();
    //private Payment payment;

    //create a constructor for the vending machine
    SpecVendingMachine(String name,String[] milkTeaFlavor, double[] milkTeaFlavorPrices,int[] milkTeaFlavorServing,double[] milkTeaFlavorCalories,String[] sinkers, double[] sinkersPrices, int[] sinkerServing, double[] sinkersCalories){
        this.name = name;
        this.milkTeaFlavor = milkTeaFlavor;
        this.milkTeaFlavorPrices = milkTeaFlavorPrices;
        this.milkTeaFlavorServing = milkTeaFlavorServing;
        
        this.milkTeaFlavorCalories = milkTeaFlavorCalories;
        
        
        this.sinkers = sinkers;
        this.sinkersPrices = sinkersPrices;
        this.sinkerServing = sinkerServing;
        
        this.sinkersCalories = sinkersCalories;
       
       // this.sugarLevel = sugarLevel;
        //this.size = size;
        //this.payment = payment;
    }
    SpecVendingMachine(){
        this.name = name;
        this.milkTeaFlavor = milkTeaFlavor;
        this.milkTeaFlavorPrices = milkTeaFlavorPrices;
        this.milkTeaFlavorServing = milkTeaFlavorServing;

        this.milkTeaFlavorCalories = milkTeaFlavorCalories;


        this.sinkers = sinkers;
        this.sinkersPrices = sinkersPrices;
        this.sinkerServing = sinkerServing;

        this.sinkersCalories = sinkersCalories;

        // this.sugarLevel = sugarLevel;
        //this.size = size;
        //this.payment = payment;
    }


    public String getName(){
        return this.name = name;
    }

    public int getNumOfFlavors(){
        return this.numOfFlavors;
    }
    public String[] getMilkTeaFlavor(){
        return this.milkTeaFlavor;
    }
    public int[] getMilkTeaFlavorServing(){
        return this.milkTeaFlavorServing;
    }

    public double[] getMilkTeaFlavorCalories(){
        return this.milkTeaFlavorCalories;
    }

    public double[] getMilkTeaFlavorPrices() {
        return milkTeaFlavorPrices;
    }

    public int[] getMilkTeaFlavorServings() {
        return milkTeaFlavorServing;
    }

    public int getSugarLevel(){
        return this.sugarLevel;
    }

    public int getNumOfSinkers(){
        return this.numOfSinkers;
    }
    public String[] getSinkers(){
        return this.sinkers;
    }

    public double[] getSinkersCalories(){
        return this.sinkersCalories;
    }

    public double[] getSinkersPrices() {
        return sinkersPrices;
    }
    public int[] getSinkerServing(){
        return this.sinkerServing;
    }
    public int getSize(){
        return this.size;
    }
    public String setName(String name){
        return this.name = name;
    }
    public int setNumOfFlavors(int numOfFlavors){
        return this.numOfFlavors = numOfFlavors;
    }
    public void setMilkTeaFlavor(String[] milkTeaFlavor){
        this.milkTeaFlavor = milkTeaFlavor;
    }


    public void setMilkTeaFlavorCalories(double[] milkTeaFlavorCalories){
        this.milkTeaFlavorCalories = milkTeaFlavorCalories;
    }

    public void setMilkTeaFlavorPrices(double[] milkTeaFlavorPrices) {
        this.milkTeaFlavorPrices = milkTeaFlavorPrices;
    }

    public void setMilkTeaFlavorServing(int[] milkTeaFlavorServing)
    {this.milkTeaFlavorServing = milkTeaFlavorServing;
    }

    public void setSugarLevel(int sugarLevel){
        this.sugarLevel = sugarLevel;
    }
    public void setNumOfSinkers(int numOfSinkers){
        this.numOfSinkers = numOfSinkers;
    }
    public void setSinkers(String[] sinkers){
        this.sinkers = sinkers;
    }

    public void setSinkersCalories(double[] sinkersCalories){
        this.sinkersCalories = sinkersCalories;
    }

    public void setSinkersPrices(double[] sinkersPrices) {
        this.sinkersPrices = sinkersPrices;
    }

    public void setSinkerServing(int[] sinkerServing){
        this.sinkerServing = sinkerServing;
    }
    public void setSize(int size){
        this.size = size;
    }

    public void displayMilkTeaFlavors(){
        for(int i = 0; i< milkTeaFlavor.length; i++) {
            System.out.println((i + 1)+"."+" Milk Tea Flavor " + ": " + milkTeaFlavor[i]);
            System.out.println("Price of " + milkTeaFlavor[i] + ": " + milkTeaFlavorPrices[i]);
            System.out.println("Calorie Count of " + milkTeaFlavor[i] + ": " + milkTeaFlavorCalories[i]);
            System.out.println("Quantity of " + milkTeaFlavor[i] + ": " + milkTeaFlavorServing[i]);
            System.out.println();
            System.out.println("=======================================");
            System.out.println();
        }
    }

        public void displaySinkers(){
            for (int i = 0; i<sinkers.length; i++){
                System.out.println("Sinkers " + (i + 1) + ": " + sinkers[i]);
                System.out.println("Price of " + sinkers[i] + ": " + sinkersPrices[i]);
                System.out.println("Calorie Count of " + sinkers[i] + ": " + sinkersCalories[i]);
                System.out.println("Quantity of " + sinkers[i] + ": " + sinkerServing[i]);
                System.out.println();
                System.out.println("=======================================");
                System.out.println();

            }

        }
        public void displaySize(){
            System.out.println("1. Small");
            System.out.println("2. Medium ||price: milktea flavor x 1.5 ");
            System.out.println("3. Large ||price: milktea flavor x 2");
        }
        public void displaySugarLevel(){
            System.out.println("0%");
            System.out.println("25%");
            System.out.println("50%");
            System.out.println("75%");
            System.out.println("100%");
            System.out.println("125%");
            System.out.println("150%");
        }

        public void addMilkteaQTY(String item,int x){
            for (int i = 0; i < milkTeaFlavor.length; i++) {
            if (milkTeaFlavor[i].equals(item)) {
                milkTeaFlavorServing[i] += x;
                i=500;
                if(i==500){
                    System.out.println("item FOUND");
                }
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }
                
            }}
        }
        public void addSinkerQTY(String item,int x){
            for (int i = 0; i < sinkers.length; i++) {
            if (sinkers[i].equals(item)) {
                sinkerServing[i] += x;
                i=500;
                if(i==500){
                    System.out.println("item FOUND");
                }
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }
                
            }}
        }
    public double computeBill(double MTPrice, double SPrice){
            double bill = MTPrice + SPrice;
            return bill;

        }
    public double computeCaloriesBySize(double MTCal, String Size){
        if(Size == "Small"){return MTCal*1;}
        else if (Size == "Medium"){return MTCal*1.5;}
        else if (Size == "Large"){return MTCal*2;}
        else{return 0;}
    }
        //you can use ComputeCalorieBySize to compute the calories of the milk tea
    public double computeCalories(double MCal, double SCal, int x, int size){//MCal is MilkTea Caloriecount, SCal is Sinker Calorie count, x is sugar level, sugcal is calories of sugar
            double SugCal;
            if (x == 2){SugCal = 19;} // 5 grams = 19 calories
            else if (x==3){SugCal = 38;}
            else if (x==4){SugCal = 57;}
            else if (x==5){SugCal = 76;}
            else if (x==6){SugCal = 95;}
            else if (x==7){SugCal = 114;}
            else{SugCal = 0;}
            
        double totalCal = MCal + (SCal) + SugCal;
        if(size==2){totalCal*=1.5;}
        if(size==3){totalCal*=2;}
        return totalCal;
    }

    public double computePrice(String milk, String sinker, int x){ //MTPrice is MilkTea Flavor price, SPrice is Sinker price || Flavor Index is index of flavor price, Sinker index is index of sinker prices

        double MTPrice = getMilkTeaPrice(milk);
        double SPrice = getSinkerPrice(sinker);
        if(x == 1){ MTPrice *= 1;} 
        else if (x == 2){ MTPrice *= 1.5;}
        else if (x == 3){ MTPrice *= 2;}

        double totalPrice = MTPrice + SPrice;
        return totalPrice;
    }
     ///DISPLAY LSIT
        public void displayList(int flag, int itemIndex, int itemIndex2){
        int sum=0;
        if(flag==1){ // 1 means add to transaction ,2 will mean display
            

            itemList.add(itemIndex);
            itemList2.add(itemIndex2);

        }
        else if(flag ==2)
        {   
            
            System.out.println("!!TRANSACTION HISTORY!!");
            for (int i=0; i < itemList.size();i++ ) {

            System.out.println("ITEM SOLD: (milktea flavor)"+milkTeaFlavor[itemList.get(i)]+" + " +"(sinker)"+sinkers[itemList2.get(i)] +" ||PROFIT = (milktea flavor)"+milkTeaFlavorPrices[itemList.get(i)]+"php +"+"(sinker)"+sinkersPrices[itemList2.get(i)]+"php");
            sum+= sinkersPrices[itemList2.get(i)]+ milkTeaFlavorPrices[itemList.get(i)];
          
        }
            displayMilkTeaFlavors();
            displaySinkers();
            System.out.println("TOTAL PROFIT = "+sum+"php");

        }
    }

    public void addMilkServing(String itemName, int qty){
        for (int i = 0; i < milkTeaFlavor.length; i++) {
            if (milkTeaFlavor[i].equals(itemName)) {
                milkTeaFlavorServing[i] += qty;
                i=500;
                if(i==500){
                    System.out.println("item FOUND");
                }
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}

    }

    public void addSinkerServing(String itemName, int qty){
        for (int i = 0; i < sinkers.length; i++) {
            if (sinkers[i].equals(itemName)) {
                sinkerServing[i] += qty;
                i=500;
                if(i==500){
                    System.out.println("item FOUND");
                }
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}

    }

    public void buyMilkTea(String itemName){
        for (int i = 0; i < milkTeaFlavor.length; i++) {
            if (milkTeaFlavor[i].equals(itemName)) {
                milkTeaFlavorServing[i] -= 1;
                i=500;
                if(i==500){
                    System.out.println("item FOUND");
                }
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}

    }

    public void buySinker(String itemName){
        for (int i = 0; i < sinkers.length; i++) {
            if (sinkers[i].equals(itemName)) {
                sinkerServing[i] -= 1;
                i=500;
                if(i==500){
                    System.out.println("item FOUND");
                }
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}

    }

    public double getMilkTeaCalories(String itemName){
        for (int i = 0; i < milkTeaFlavor.length; i++) {
            if (milkTeaFlavor[i].equals(itemName)) {
                return milkTeaFlavorCalories[i];
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}
        return 0;
    }

    public double getSinkerCalories(String itemName){
        for (int i = 0; i < sinkers.length; i++) {
            if (sinkers[i].equals(itemName)) {
                return sinkersCalories[i];
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}
        return 0;
    }

    public double getMilkTeaPrice(String itemName){
        for (int i = 0; i < milkTeaFlavor.length; i++) {
            if (milkTeaFlavor[i].equals(itemName)) {
                return milkTeaFlavorPrices[i];
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}
        return 0;
    }

    public double getSinkerPrice(String itemName){
        for (int i = 0; i < sinkers.length; i++) {
            if (sinkers[i].equals(itemName)) {
                return sinkersPrices[i];
            }else{
                if( i>=milkTeaFlavor.length){
                    System.out.println("==!!NO ITEM FOUND!!==");
                }

            }}
        return 0;
    }

}
