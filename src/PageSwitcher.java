import java.io.PrintStream;
import java.util.ArrayList;

public class PageSwitcher
{
    public PageSwitcher(UserService us)
    {
        ArrayList<Page> pages = new ArrayList<>();
        pages.add(new Page0(us));
        pages.add(new Page1(us));
        pages.add(new Page2(us));
        pages.add(new Page3(us));
        pages.add(new Page4(us));
        pages.add(new Page5(us));
        pages.add(new Page6(us));







        int currentPage = 1;
        while ((currentPage > 0) && (currentPage < pages.size()))
        {
            Page page = pages.get(currentPage);
            if (page == null) {
                break;
            }
            currentPage = page.render();
        }
        if (currentPage > 0) {
            System.out.println("Attempted to access page #" + currentPage + "But it's not defined yet");
        }
    }
}
