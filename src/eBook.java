/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: A data class to represent any eBook
*/
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


    //Adds eBook to the end of the parent implementation of getInfo
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
