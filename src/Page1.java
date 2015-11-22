import java.util.Scanner;

public class Page1
        extends Page {
    Page1(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int render() {
        this.us.deauth();
        Scanner sc = new Scanner(System.in);
        String opt;
        do {
            System.out.println("1.Sign in");
            System.out.println("2.Sign up");
            System.out.print("Choose your option:");

            opt = sc.next();
        } while ((!opt.equals("1")) && (!opt.equals("2")));
        switch (opt) {
            case "1":
                // Go to Page 3, the login page
                return 3;
            case "2":
                // Go to Page 2 Signup Page
                return 2;
        }
        throw new RuntimeException("Logic error in page 1");
    }

    public int getPageNo() {
        return 1;
    }
}
