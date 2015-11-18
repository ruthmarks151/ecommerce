import java.io.PrintStream;
import java.util.Scanner;

public class Page2
        extends Page
{
    Page2(UserService userService)
    {
        super(userService);
    }

    public int getPageNo()
    {
        return 2;
    }

    public int render()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose your username");
        String name = sc.next();
        while (this.us.userExists(name))
        {
            System.out.println("That username is taken,");
            System.out.print("Choose your username");
            name = sc.next();
        }
        return 1;
    }
}
