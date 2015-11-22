import java.util.Scanner;

public class Page3
        extends Page {
    Page3(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int render() {
        System.out.print("Enter your username:");

        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        if (!us.userExists(username)) {
            return 4;// Goto Page 4, the invalid login page
        }
        us.auth(username);
        System.out.println();
        if (us.authenticated()) {
            System.out.println("Hello Mr." + us.getAuthedUserName());
            return 5; // Goto page 5, the main page
        }else {
            // Authentication failed
            System.out.println("No Access");
            return 1; // Goto Page 1, the login page
        }
    }

    public int getPageNo() {
        return 3;
    }
}
