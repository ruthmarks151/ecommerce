public abstract class Page
{
    final UserService us;

    Page(UserService userService)
    {
        this.us = userService;
    }

    public abstract int getPageNo();

    public abstract int render();
}