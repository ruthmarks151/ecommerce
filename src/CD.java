public class CD extends Audio {

    public CD(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, artist, itemPrice, itemQuantity);
    }

    @Override
    public String getType() {
        return "CD";
    }

    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new CD(sNo,getName(),artistName,getPrice(),amount);
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"CD";
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
