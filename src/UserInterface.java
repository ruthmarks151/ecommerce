/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: This class handles all of the switching between pages.
*               It implements a bunch of other methods and fields because it has to in the spec
*/
import java.util.ArrayList;

public class UserInterface {

    private ArrayList<Readable> readables;
    private ArrayList<Audio> audios;
    private int pageOverride = -1;
    private int currentPage = 1;
    private UserService us;
    private ItemService is;
    private ArrayList<Page> pages = new ArrayList<>();

    public int getCurrentPage() {
        return currentPage;
    }

    public int changeCurrentPage(int p){
        pageOverride = p;
        return p;
    }

    public void getReadables() {
        readables = is.getReadables();
    }

    public void getAudioProducts() {
        audios = is.getAudios();
    }

    public void showReadables(){
        pages.get(8).render();
    }

    public void showAudioProducts(){
        pages.get(9).render();
    }

    public void clear(){
        //                  12345678901234567890123456789012345678901234567890123456789012345678901234567890
        System.out.println("--------------------------------------------------------------------------------");
    }

    public UserInterface(UserService us, ItemService is) {
        this.is = is;
        this.us = us;

        pages.add(new Page0(us,is));
        pages.add(new Page1(us,is));
        pages.add(new Page2(us,is));
        pages.add(new Page3(us,is));
        pages.add(new Page4(us,is));
        pages.add(new Page5(us,is));
        pages.add(new Page6(us,is));
        pages.add(new Page7(us,is));
        pages.add(new Page8(us,is));
        pages.add(new Page9(us,is));
        pages.add(new Page10(us,is));
        pages.add(new Page11(us,is));



        while ((currentPage > 0) && (currentPage < pages.size())) {
            clear();
            getReadables();
            getAudioProducts();

            Page page = pages.get(currentPage);
            if (page == null) {
                break;
            }
            currentPage = page.render();

            if (pageOverride > 0){
                currentPage = pageOverride;
                pageOverride = -1;
            }
        }
        if (currentPage > 0) {
            System.out.println("Attempted to access page #" + currentPage + "But it's not defined yet");
        }
    }
}
