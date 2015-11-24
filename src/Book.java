/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: A data class to represent any book
*/
public class Book extends Readable {

    public Book(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemAuthor, itemPrice, itemQuantity);
    }
    //Returns the type as "Book"
    @Override
    public String getType() {
        return "Book";
    }
    //Notifies user if they are attempting to buy more of a product that what is available.
    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new Book(sNo,getName(),authorName, getBasePrice(),amount);
    }

    //Adds "Book" to the end of the result of the parent implementation of getInfo.
    @Override
    public String getInfo() {
        return super.getInfo()+ "Book ";
    }

    //Returns the price of product including environment tax, shipping and hst.
    @Override
    public int getPrice() {
        int base = getBasePrice();
        int enviro = (int)(base * 0.02);
        int shipping = (int)(base * 0.10);
        int hst = (int)(base * 0.13);

        return base + enviro + shipping + hst;
    }
}
