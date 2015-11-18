import java.io.PrintStream;
import java.util.Scanner;

public class Page5
        extends Page
{
    Page5(UserService userService)
    {
        super(userService);
    }

    public int getPageNo()
    {
        return 5;
    }

    public int render()
    {
        assert (this.us.authenticated());

        Scanner sc = new Scanner(System.in);
        String opt;
        do
        {
            System.out.println("1.View Items By Category");
            System.out.println("2.View Shopping Cart");
            System.out.println("3.Sign Out");
            System.out.println("");
            System.out.print("Choose your option: ");

            opt = sc.next();
        } while ((opt.equals("1")) &&
                (opt.equals("2")) &&
                (opt.equals("3")));
        switch (opt)
        {
            case "1":
                return 6;
            case "2":
                return 7;
            case "3":
                return 1;
        }
        throw new RuntimeException("Logic error in page 5");
    }
}
