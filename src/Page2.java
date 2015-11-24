/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: Page 2 as is defined in the specifications document
*/
import java.util.Scanner;

public class Page2 extends Page {
    Page2(UserService userService,ItemService itemService) {
        super(userService,itemService);
    }

    public int getPageNo() {
        return 2;
    }
    //Asks user to pick a username, if the name is taken it will notify the user and asks again
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
