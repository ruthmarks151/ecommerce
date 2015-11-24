public class Audio extends Item {
    protected String artistName;

    public Audio(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemPrice, itemQuantity);
        artistName = artist;
    }
    //Returns type as "Audio"
    @Override
    public String getType() {
        return "Audio";
    }
    //Provides additional information about the audio
    @Override
    public String getInfo() {

        return fillString(""+sNo,5) +
                fillString(name,25) +
                fillString(artistName, 20) +
                fillString(""+ getBasePrice(),10)+
                fillString(""+quantity,20);

    }
    //Notifies user if they are attempting to buy more of a product that what is available.
    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new Audio(sNo,getName(),artistName, getBasePrice(),amount);
    }
    //Returns price including taxes.
    @Override
    public int getPrice() {
        int base = getBasePrice();
        int hst = (int)(base * 0.13);

        return base + hst;
    }
}
