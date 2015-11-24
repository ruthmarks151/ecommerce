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
        return new CD(sNo,getName(),artistName, getBasePrice(),amount);
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"CD";
    }

    @Override
    public int getBasePrice() {
        return super.getBasePrice();
    }

    @Override
    public int getPrice() {
        int base = getBasePrice();
        int enviro = (int)(base * 0.02);
        int shipping = (int)(base * 0.10);
        int hst = (int)(base * 0.13);

        return base + enviro + shipping + hst;
    }
}
