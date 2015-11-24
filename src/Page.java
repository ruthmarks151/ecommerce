/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: This is a generic Page, all other pages extend from it
*/
public abstract class Page {
    final UserService us;
    final ItemService is;
    Page(UserService userService, ItemService itemService) {
        is = itemService;
        us = userService;

    }

    public abstract int getPageNo();

    public abstract int render();
}