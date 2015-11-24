public class eBook extends Readable {

    public eBook(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemAuthor, itemPrice, itemQuantity);
    }

    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new eBook(sNo,getName(),authorName, getBasePrice(),amount);
    }

    @Override
    public int getBasePrice() {
        return super.getBasePrice();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"eBook";
    }

    @Override
    public int getPrice() {
        int base = getBasePrice();
        int hst = (int)(base * 0.13);

        return base +  hst;
    }
}
