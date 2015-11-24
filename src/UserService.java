import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class UserService {
    User activeUser = null;
    ShoppingCart cart = null;
    private boolean authenticated = false;
    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<>();
        String line;
        try (
                InputStream fis = new FileInputStream("Users.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {

            while ((line = br.readLine()) != null) {
                users.add(new User(line));
            }
        }catch (IOException e){
            System.out.println("Users.txt could not be found, please place it in "+System.getProperty("user.dir"));
        }
    }

    public ShoppingCart getCart(){
        return cart;
    }

    public boolean userExists(String username) {
        for(User u:users){
            if (u.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public User getUser(String username) {
        for(User u:users){
            if (u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    public boolean authenticated() {
        return authenticated;
    }

    public void auth(String authUsername) {
        if (userExists(authUsername)) {
            activeUser = getUser(authUsername);
            authenticated = true;
            cart = new ShoppingCart(activeUser);
        } else {
            throw new RuntimeException("Attempt to auth user which does not exist");
        }
    }

    public void addItem(Item i){
        cart.addItem(i);
    }

    public String getBilling(){
        return cart.getCheckoutDetails();
    }

    public void register(String username) {
        users.add(new User(username));
    }

    public String getAuthedUserName() {
        return activeUser.getUsername();
    }

    public void deauth() {
        activeUser = null;
        authenticated = false;

    }
}
