public abstract class Item {

    protected int price;
    protected int sNo; //Serial number.
    protected String name;
    protected int quantity;

    public Item(int serial, String itemName,int itemPrice, int itemQuantity) {//declaring the Item constructor.
        sNo = serial;
        name = itemName;
        price = itemPrice;
        quantity =itemQuantity;
    }

    public int getSerial(){
        return sNo;
    }

    public abstract String getType();

    public String getName(){
        return name;
    }

    public abstract Item buy(int amount);

    public boolean available(int amount){
        return amount <= quantity && amount > 0;
    }

    public abstract String getInfo();

    public int getQuantity(){
        return quantity;
    }

    public int getBasePrice(){
        return price;
    }

    public int getPrice(){
        return price;
    }

    protected String fillString(String s, int len){
        int delta = len - s.length();
        for (int i = 0; i < delta; i++){
            s += " ";
        }
        return s;
    }
}
