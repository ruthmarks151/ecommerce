import java.util.Scanner;

public class Page7 extends Page {
    Page7(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 6;
    }

    public int render() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sample Shopping Cart");
        return 5;// Goto page 5, the main page
    }
}
