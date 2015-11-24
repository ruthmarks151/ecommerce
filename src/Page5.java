/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: Page 5 as is described in the specifications document
*/
import java.util.Scanner;

public class Page5
        extends Page {
    Page5(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 5;
    }
    //From this page the user can view the items by category and the shopping cart and allows the option to sign out
    public int render() {
        assert (this.us.authenticated());

        Scanner sc = new Scanner(System.in);
        String opt;
        do {
            System.out.println("1.View Items By Category");
            System.out.println("2.View Shopping Cart");
            System.out.println("3.Sign Out");
            System.out.println("4.View Previous Orders");
            System.out.println("");
            System.out.print("Choose your option: ");

            opt = sc.next();
        } while (!((opt.equals("1")) ||
                (opt.equals("2")) ||
                (opt.equals("3")) ||
                (opt.equals("4"))));
        switch (opt) {
            case "1":
                return 6;// Goto page 6, the category page
            case "2":
                return 7;// Goto page 7, the shopping cart
            case "3":
                return 1; // Goto pag1 the login page.
            case "4":
                return 11; // Goto page 11 the items bought page.
        }
        throw new RuntimeException("Logic error in page 5");
    }
}
