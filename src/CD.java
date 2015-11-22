public class CD extends Audio {

    public CD(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, artist, itemPrice, itemQuantity);
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"CD";
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
