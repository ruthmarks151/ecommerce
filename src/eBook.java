public class eBook extends Readable {

    public eBook(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemAuthor, itemPrice, itemQuantity);
    }

    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        amount -= quantity;
        return new eBook(sNo,getName(),authorName,getPrice(),amount);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"eBook";
    }
}
