/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: This class encapsulates a lot of data handling and methods related to users and shopping carts
*/
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

    public String getCartContents(){
        return cart.getContent();
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

        FileWriter fw = null;
        try
        {
            String filename= "Users.txt";
            fw = new FileWriter(filename,true); //the true will append the new data
            fw.write("\n"+username);//appends the string to the file
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("Could not close Users.txt");
                }
            }
        }
    }

    public String getAuthedUserName() {
        return activeUser.getUsername();
    }

    public String checkout(){
        String line;
        String lastLine = "U0000";
        try (
                InputStream fis = new FileInputStream("ItemsBought.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {
            br.readLine();// Get header out of the way
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }
        }catch (IOException e){
            System.out.println("ItemsBought.txt could not be found, please place it in "+System.getProperty("user.dir"));
        }
        int confNo;
        try {
            confNo = Integer.parseInt(lastLine.substring(1, 5));// Assume 4 digit confirmation code
        }catch (Exception e) {
            confNo = 0;
        }

        confNo++;
        String confCode = "U"+String.format("%04d ", confNo);
        String checkoutString = cart.checkout();

        FileWriter fw = null;
        try
        {
            String filename= "ItemsBought.txt";
            fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(confCode+checkoutString+"\n");//appends the string to the file
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("Could not close ItemsBought.txt");
                }
            }
        }

        return confCode;
    }

    public void deauth() {
        activeUser = null;
        authenticated = false;

    }


}
