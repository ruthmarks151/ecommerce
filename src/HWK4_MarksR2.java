public class HWK4_MarksR2 {
    public static void main(String[] args) {
        UserService us = new UserService();
        ItemService is = new ItemService();
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        new PageSwitcher(us,is);

    }
}

