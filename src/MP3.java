public class MP3 extends Audio {

    public MP3(int serial, String itemName, String artist, int itemPrice, int itemQuantity) {
        super(serial, itemName, artist, itemPrice, itemQuantity);
    }

    @Override
    public String getType() {
        return "MP3";
    }

    @Override
    public Item buy(int amount) {
        if (amount > quantity)
            throw new RuntimeException("Attempt to buy more "+name+" than are available");
        amount -= quantity;
        return new MP3(sNo,getName(),artistName,getPrice(),amount);
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
