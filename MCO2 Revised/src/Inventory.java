public class Inventory {
    ;
    public RegVendingMachine inventory;
    public Inventory(RegVendingMachine inventory){
        this.inventory = inventory;
    }

    public Boolean inventory(Items items){
        for(int i = 0; i < inventory.getProdNames().length; i++){
            if(inventory.getProdNames()[i] == items.getItem()){
                inventory.getProdQty()[i] = inventory.getProdQty()[i] - items.getQty();
                if(inventory.getProdQty()[i] == 0){
                    return false;
                }
            }
        }



        return true;
    }
}
