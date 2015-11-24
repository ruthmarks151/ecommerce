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
        return new Book(sNo,getName(),authorName,getPrice(),amount);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+ "Book ";
    }


}
