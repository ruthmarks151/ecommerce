public class Audio extends Item {
    protected String artistName;

    public Audio(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemPrice, itemQuantity);
        artistName = artist;
    }

    @Override
    public String getType() {
        return "Audio";
    }

    @Override
    public String getInfo() {

        return fillString(""+sNo,5) +
                fillString(name,25) +
                fillString(artistName, 20) +
                fillString(""+getPrice(),10)+
                fillString(""+quantity,20);

    }

    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new Audio(sNo,getName(),artistName,getPrice(),amount);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
