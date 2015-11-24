/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: This is the main class that sets up everything needed for the ecommerce store
*/
public class HWK4_MarksR2 {
    public static void main(String[] args) {
        UserService us = new UserService();
        ItemService is = new ItemService(us);
        new UserInterface(us,is);

    }
}

