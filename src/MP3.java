public class MP3 extends Audio {

    public MP3(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, artist, itemPrice, itemQuantity);
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"MP3";
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
