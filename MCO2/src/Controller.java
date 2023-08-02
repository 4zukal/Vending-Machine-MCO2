public class Controller {
    private RegVendingMachine regVendingMachine;

    private SpecVendingMachine specVendingMachine;
    private Payment payment;


    public Controller(){
        this.regVendingMachine = new RegVendingMachine();
        this.specVendingMachine = new SpecVendingMachine();
        this.payment = new Payment();

    }

    public Controller(RegVendingMachine regVendingMachine){
        this.regVendingMachine = regVendingMachine;
    }

    public String SetRegVendName(String name){
        this.regVendingMachine.setName(name);
        return name;
    }
    public String getRegVendName(){
        return this.regVendingMachine.getName();
    }

    public int getNumOfProds(){
        return this.regVendingMachine.getNumOfProds();
    }

    public int setNumOfProds(int numOfProds){
        return this.regVendingMachine.setNumOfProds(numOfProds);
    }

    public String[] getProdNames(){
        return this.regVendingMachine.getProdNames();
    }


    public String[] setProdNames(String[] prodNames){
        this.regVendingMachine.setProdNames(prodNames);
        return prodNames;
    }

    public double[] getProdPrices(){
        return this.regVendingMachine.getProdPrices();
    }

    public double[] setProdPrices(double[] prodPrices){
        this.regVendingMachine.setProdPrices(prodPrices);
        return prodPrices;
    }

    public int[] getProdQty(){
        return this.regVendingMachine.getProdQty();
    }
    public int[] setProdQty(int[] prodQty){
        this.regVendingMachine.setProdQty(prodQty);
        return prodQty;
    }

    public double[] getProdCalorie(){
        return this.regVendingMachine.getProdCalorie();
    }


    public double[] setProdCalorie(double[] prodCalorie){
        this.regVendingMachine.setProdCalorie(prodCalorie);
        return prodCalorie;
    }

    public void addItemQty(String item, int qty){
        this.regVendingMachine.addItemQty(item, qty);
    }

    public void buyItem(String item, double price){
        this.regVendingMachine.buyItem(item,price);
    }

    public double getItemPrice(String item){
        return this.regVendingMachine.getItemPrice(item);
    }

    public int getItemQty(String item){
        return this.regVendingMachine.getItemQty(item);

    }


    public String getSpecVendName(){
        return this.specVendingMachine.getName();
    }

    public int getSpecNumOfFlavors(){
        return this.specVendingMachine.getNumOfFlavors();
    }

    public String[] getSpecFlavors(){
        return this.specVendingMachine.getMilkTeaFlavor();
    }

    public int[] getMilkTeaFlavorServing(){
        return this.specVendingMachine.getMilkTeaFlavorServing();
    }

    public double[] getMilkTeaFlavorCalories(){
        return this.specVendingMachine.getMilkTeaFlavorCalories();
    }

    public double[] getMilkTeaFlavorPrices(){
        return this.specVendingMachine.getMilkTeaFlavorPrices();
    }

    public int[] getMilkTeaFlavorServings(){
        return this.specVendingMachine.getMilkTeaFlavorServing();
    }

    public int getSugarLevel(){
        return this.specVendingMachine.getSugarLevel();
    }

    public int getNumOfSinkers(){
        return this.specVendingMachine.getNumOfSinkers();
    }

    public String[] getSinkers(){
        return this.specVendingMachine.getSinkers();
    }
    public double[] getSinkersPrices(){
        return this.specVendingMachine.getSinkersPrices();
    }

    public double[] getSinkersCalories(){
        return this.specVendingMachine.getSinkersCalories();
    }

    public int[] getSinkerServing(){
        return this.specVendingMachine.getSinkerServing();
    }

    public int getSize(){
        return this.specVendingMachine.getSize();
    }

    public String setSpecVendName(String name){
        this.specVendingMachine.setName(name);
        return name;
    }

    public int setSpecNumOfFlavors(int numOfFlavors){
        return this.specVendingMachine.setNumOfFlavors(numOfFlavors);
    }

    public String[] setSpecFlavors(String[] milkTeaFlavor){
        this.specVendingMachine.setMilkTeaFlavor(milkTeaFlavor);
        return milkTeaFlavor;
    }



    public double[] setMilkTeaFlavorCalories(double[] milkTeaFlavorCalories){
        this.specVendingMachine.setMilkTeaFlavorCalories(milkTeaFlavorCalories);
        return milkTeaFlavorCalories;
    }

    public double[] setMilkTeaFlavorPrices(double[] milkTeaFlavorPrices){
        this.specVendingMachine.setMilkTeaFlavorPrices(milkTeaFlavorPrices);
        return milkTeaFlavorPrices;
    }

    public int[] setMilkTeaFlavorServing(int[] milkTeaFlavorServing){
        this.specVendingMachine.setMilkTeaFlavorServing(milkTeaFlavorServing);
        return milkTeaFlavorServing;
    }

    public int setSugarLevel(int sugarLevel){
        this.specVendingMachine.setSugarLevel(sugarLevel);
        return sugarLevel;
    }

    public int setNumOfSinkers(int numOfSinkers){
        this.specVendingMachine.setNumOfSinkers(numOfSinkers);
        return numOfSinkers;
    }

    public String[] setSinkers(String[] sinkers){
        this.specVendingMachine.setSinkers(sinkers);
        return sinkers;
    }

    public double[] setSinkersPrices(double[] sinkersPrices){
        this.specVendingMachine.setSinkersPrices(sinkersPrices);
        return sinkersPrices;
    }

    public double[] setSinkersCalories(double[] sinkersCalories){
        this.specVendingMachine.setSinkersCalories(sinkersCalories);
        return sinkersCalories;
    }

    public int[] setSinkersServing(int[] sinkerServing){
        this.specVendingMachine.setSinkerServing(sinkerServing);
        return sinkerServing;
    }

    public char setSize(char size){
        this.specVendingMachine.setSize(size);
        return size;
    }

    public void addMilkServing(String milkTeaFlavor, int serving){
        this.specVendingMachine.addMilkServing(milkTeaFlavor, serving);
    }

    public void addSinkerServing(String sinker, int serving){
        this.specVendingMachine.addSinkerServing(sinker, serving);
    }

    public double computeTotalCalories(double milk, double sinker, int sugarLevel, int size){
        return this.specVendingMachine.computeCalories(milk, sinker, sugarLevel, size);
    }

    public void buyMilkTea(String name){
        this.specVendingMachine.buyMilkTea(name);
    }

    public void buySinker(String name){
        this.specVendingMachine.buySinker(name);
    }

    public double getMilkTeaCalories(String name){
        return this.specVendingMachine.getMilkTeaCalories(name);
    }

    public double getSinkerCalories(String name){
        return this.specVendingMachine.getSinkerCalories(name);
    }

    public double computePrice(String milk, String sinker, int size){
        return this.specVendingMachine.computePrice(milk, sinker, size);
    }

    public double initializeRegMoneyBox(double moneyBox){
        return this.payment.initializeMoneyBox(moneyBox);
    }


    public double initializeSpecMoneyBox(double moneyBox){
        return this.payment.initializeMoneyBox(moneyBox);
    }

    public double getRegMoneyBox(){
        return this.payment.getMoneyBox();
    }

    public double getSpecMoneyBox(){
        return this.payment.getMoneyBox();
    }

    public double setRegMoneyBox(double moneyBox){
        this.payment.setMoneyBox(moneyBox);
        return moneyBox;
    }

    public double setSpecMoneyBox(double moneyBox){
        this.payment.setMoneyBox(moneyBox);
        return moneyBox;
    }

    public double addRegMoneyBox(double moneyBox){
        return this.payment.addMoneyBox(moneyBox);
    }
    public double addSpecMoneyBox(double moneyBox){
        return this.payment.addMoneyBox(moneyBox);
    }

    public double getRegPayment(){
        return this.payment.getPayment();
    }

    public double getSpecPayment(){
        return this.payment.getPayment();
    }

    public double setRegPayment(double payment){
        this.payment.setPayment(payment);
        return payment;
    }

    public double setSpecPayment(double payment){
        this.payment.setPayment(payment);
        return payment;
    }

    public double addRegPayment(double payment){
        return this.payment.addPayment(payment);
    }

    public double addSpecPayment(double payment){
        return this.payment.addPayment(payment);
    }





}
