public class MP3 extends Audio {

    public MP3(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, artist, itemPrice, itemQuantity);
    }
    //Returns the type as "MP3"
    @Override
    public String getType() {
        return "MP3";
    }
    //Notifies user if they are attempting to buy more of a product that what is available.
    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        quantity -= amount;
        return new MP3(sNo,getName(),artistName, getBasePrice(),amount);
    }
    //Adds "MP3" to the end of the implementation of getInfo
    @Override
    public String getInfo() {
        return super.getInfo()+"MP3";
    }


}
