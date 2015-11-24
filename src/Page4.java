public class Page4
        extends Page {
    Page4(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 4;
    }
    //Notifies user that access was not granted and returns to the log in page
    public int render() {
        System.out.println(" No Access");
        return 1; // goto the login page
    }
}
