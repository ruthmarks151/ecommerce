public class Book extends Readable {

    public Book(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemAuthor, itemPrice, itemQuantity);
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
