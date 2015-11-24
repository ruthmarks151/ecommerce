public class eBook extends Readable {

    public eBook(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemAuthor, itemPrice, itemQuantity);
    }
    //Notifies user if they are attempting to buy more of a product that what is available.
    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new eBook(sNo,getName(),authorName, getBasePrice(),amount);
    }
    //Returns the base price of the product
    @Override
    public int getBasePrice() {
        return super.getBasePrice();
    }
    //Adds eBook to the end of the implementation of getInfo
    @Override
    public String getInfo() {
        return super.getInfo()+"eBook";
    }
    //Returns the price including tax
    @Override
    public int getPrice() {
        int base = getBasePrice();
        int hst = (int)(base * 0.13);

        return base +  hst;
    }
}
