public class CD extends Audio {

    public CD(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, artist, itemPrice, itemQuantity);
    }
    //Returns type as "CD"
    @Override
    public String getType() {
        return "CD";
    }
    //Notifies user if they are attempting to buy more of a product that what is available.
    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new CD(sNo,getName(),artistName, getBasePrice(),amount);
    }
    //Adds "CD" to the end of the implementation of getInfo
    @Override
    public String getInfo() {
        return super.getInfo()+"CD";
    }

    //Returns the final price including enviro, shipping and hst.
    @Override
    public int getPrice() {
        int base = getBasePrice();
        int enviro = (int)(base * 0.02);
        int shipping = (int)(base * 0.10);
        int hst = (int)(base * 0.13);

        return base + enviro + shipping + hst;
    }
}
