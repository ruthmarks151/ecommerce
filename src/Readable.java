public class Readable extends Item {
    protected String authorName;

    public Readable(int serial, String itemName, String itemAuthor, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemPrice, itemQuantity);
        authorName = itemAuthor;
    }

    public String getAuthor() {
        return authorName;
    }

    @Override
    public String getInfo() {

        return fillString(""+sNo,5) +
                fillString(name,25) +
                fillString(authorName, 20) +
                fillString(""+ getBasePrice(),10)+
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
        quantity -= amount;
        return new Readable(sNo,getName(),authorName, getBasePrice(),amount);
    }



    @Override
    public int getPrice() {
        int base = getBasePrice();
        int hst = (int)(base * 0.13);
        return base + hst;
    }
}
