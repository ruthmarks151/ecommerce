import java.util.Scanner;

public class Page5
        extends Page {
    Page5(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 5;
    }

    public int render() {
        assert (this.us.authenticated());

        Scanner sc = new Scanner(System.in);
        String opt;
        do {
            System.out.println("1.View Items By Category");
            System.out.println("2.View Shopping Cart");
            System.out.println("3.Sign Out");
            System.out.println("");
            System.out.print("Choose your option: ");

            opt = sc.next();
        } while ((opt.equals("1")) &&
                (opt.equals("2")) &&
                (opt.equals("3")));
        switch (opt) {
            case "1":
                return 6;// Goto page 6, the category page
            case "2":
                return 7;// Goto page 7, the shopping cart
            case "3":
                return 1; // Goto pag1 the login page.
        }
        throw new RuntimeException("Logic error in page 5");
    }
}
