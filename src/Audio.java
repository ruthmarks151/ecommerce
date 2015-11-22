public class Audio extends Item {
    protected String artistName;

    public Audio(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, itemPrice, itemQuantity);
        artistName = artist;
    }

    public String getInfo() {
        return null;
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
