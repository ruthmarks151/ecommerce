import java.io.PrintStream;

public class Page4
        extends Page
{
    Page4(UserService userService)
    {
        super(userService);
    }

    public int getPageNo()
    {
        return 4;
    }

    public int render()
    {
        System.out.println(" No Access");
        return 1;
    }
}
