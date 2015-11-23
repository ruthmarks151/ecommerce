import java.util.ArrayList;

public class ShoppingCart extends User {
    private int currentPage;
    private ArrayList<Item> content = new ArrayList<>();

    public ShoppingCart(String name) {
        super(name);
    }

    public ShoppingCart(User u){super(u.getUsername());}

    public String getContent(){

    }

    public void addItem(Item i){
        content.add(i);
    }

}
