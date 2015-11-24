import java.util.Scanner;

public class Page7 extends Page {
    Page7(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 7;
    }

    public int render() {

        System.out.println(us.getCartContents());
        return 5;// Goto page 5, the main page
    }
}
