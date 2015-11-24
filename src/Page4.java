/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: Page 4 as defined in the specifications document.
*/
public class Page4
        extends Page {
    Page4(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    public int getPageNo() {
        return 4;
    }
    //Notifies user that access was not granted and returns to the log in page
    public int render() {
        System.out.println(" No Access");
        return 1; // goto the login page
    }
}
