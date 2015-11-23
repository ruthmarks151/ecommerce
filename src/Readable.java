public class Readable extends Item {
    protected String authorName;

    public Readable(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemPrice, itemQuantity);
        authorName = itemAuthor;
    }

    @Override
    public String getInfo() {

        return fillString(""+sNo,5) +
                fillString(name,25) +
                fillString(authorName, 20) +
                fillString(""+getPrice(),10)+
                fillString(""+quantity,20);

    }

    @Override
    public String getType() {
        return "Readable";
    }

    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        amount -= quantity;
        return new Readable(sNo,getName(),authorName,getPrice(),amount);
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
