public class Book extends Readable {

    public Book(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemAuthor, itemPrice, itemQuantity);
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new Book(sNo,getName(),authorName, getBasePrice(),amount);
    }

    @Override
    public int getBasePrice() {
        return super.getBasePrice();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+ "Book ";
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
