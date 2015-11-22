public class ShoppingCart extends User {
    private Readable[] readables;
    private Audio[] audioProducts;
    private int currentPage;

    public ShoppingCart(String name) {
        super(name);
    }

    public int getCurrentPage() {
        return 0;
    }

    public int changeCurrentPage(int newPage) {
        return newPage;
    }

    public Readable[] getReadables() {
        return readables;
    }

    public Audio[] getAudioProductss() {
        return audioProducts;
    }


}
