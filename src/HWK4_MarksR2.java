public class HWK4_MarksR2 {
    public static void main(String[] args) {
        UserService us = new UserService();
        ItemService is = new ItemService();
        new PageSwitcher(us,is);

    }
}

