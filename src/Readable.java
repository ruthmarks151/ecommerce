public class Readable extends Item {
    protected String authorName;

    public Readable(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemPrice, itemQuantity);
        authorName = itemAuthor;
    }

    public String getInfo() {

        return fillString(""+sNo,5) +
                fillString(name,20) +
                fillString(authorName, 20) +
                fillString(""+getPrice(),10)+
                fillString(""+quantity,20);

    }

    @Override
    public int getPrice() {
        return 0;
    }
}
