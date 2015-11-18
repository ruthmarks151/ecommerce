public class Page0
        extends Page {
    Page0(UserService userService)
    {
        super(userService);
    }

    public int getPageNo()
    {
        return 0;
    }

    public int render()
    {
        System.out.println("Page 0 got rendered!");
        return -1;
    }
}
