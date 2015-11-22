public class Page0
        extends Page {
    Page0(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 0;
    }

    public int render() {
        System.out.println("Page 0 got rendered!");
        return -1;
    }
}
