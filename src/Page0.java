/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: A test page that should never really be displayed.
*/
public class Page0
        extends Page {
    Page0(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 0;
    }

    public int render() {
        System.out.println("Page 0 got rendered!");
        return -1;
    }
}
