import java.util.Scanner;

public class Page2 extends Page {
    Page2(UserService userService,ItemService itemService) {
        super(userService,itemService);
    }

    public int getPageNo() {
        return 2;
    }

    public int render() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose your username");
        String name = sc.next();
        while (us.userExists(name)) {
            System.out.println("That username is taken,");
            System.out.print("Choose your username");
            name = sc.next();
        }
        us.register(name);
        // Goto page 1, the signin page
        return 1;
    }
}
