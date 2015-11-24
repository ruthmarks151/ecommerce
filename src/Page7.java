/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: Page 7 as is described in the specifications document
*/
public class Page7 extends Page {
    Page7(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 7;
    }

    public int render() {

        System.out.println(us.getCartContents());
        return 5;// Goto page 5, the main page
    }
}
