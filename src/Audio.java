public class Audio extends Item {
    protected String artistName;

    public Audio(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemPrice, itemQuantity);
        artistName = artist;
    }


    @Override
    public String getInfo() {

        return fillString(""+sNo,5) +
                fillString(name,20) +
                fillString(artistName, 20) +
                fillString(""+getPrice(),10)+
                fillString(""+quantity,20);

    }

    @Override
    public int getPrice() {
        return 0;
    }
}
