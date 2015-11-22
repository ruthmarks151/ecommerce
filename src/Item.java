public abstract class Item {

    protected int price;
    protected int sNo; //Serial number.
    protected String name;
    protected int quantity;

    public Item(int serial, String itemName,int itemPrice, int itemQuantity) {
        sNo = serial;
        name = itemName;
        price = itemPrice;
        quantity =itemQuantity;
    }

    public abstract String getInfo();

    public abstract int getPrice();

    protected String fillString(String s, int len){
        int delta = len - s.length();
        for (int i = 0; i < delta; i++){
            s += " ";
        }
        return s;
    }
}
