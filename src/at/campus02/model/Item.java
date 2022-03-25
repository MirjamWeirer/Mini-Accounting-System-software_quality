package at.campus02.model;

public class Item {

    private int itemNo;
    private int qty;

    //Constructor
    public Item(){}
    public Item(int itemNo, int qty) {
        this.itemNo = itemNo;
        this.qty = qty;
    }

    //Getters
    public int getItemNo() {
        return itemNo;
    }
    public int getQty() {
        return qty;
    }

    //Setters
    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    //To String
    @Override
    public String toString() {
        return "at.campus02.model.Item{" +
                "itemNo='" + itemNo + '\'' +
                ", qty=" + qty +
                '}';
    }

}
