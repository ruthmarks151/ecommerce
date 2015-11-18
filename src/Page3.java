import java.io.PrintStream;
import java.util.Scanner;

public class Page3
        extends Page
{
    Page3(UserService userService)
    {
        super(userService);
    }

    public int render()
    {
        System.out.print("Enter your username:");

        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        if (!this.us.userExists(username)) {
            return 4;
        }
        this.us.auth(username);
        System.out.println();
        if (this.us.authenticated()) {
            return 5;
        }
        System.out.println("No Access");
        return -1;
    }

    public int getPageNo()
    {
        return 3;
    }
}
