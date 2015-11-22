import java.util.ArrayList;

public class PageSwitcher {
    public PageSwitcher(UserService us, ItemService is) {
        ArrayList<Page> pages = new ArrayList<>();
        pages.add(new Page0(us,is));
        pages.add(new Page1(us,is));
        pages.add(new Page2(us,is));
        pages.add(new Page3(us,is));
        pages.add(new Page4(us,is));
        pages.add(new Page5(us,is));
        pages.add(new Page6(us,is));
        pages.add(new Page7(us,is));
        pages.add(new Page8(us,is));



        int currentPage = 1;
        while ((currentPage > 0) && (currentPage < pages.size())) {
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
