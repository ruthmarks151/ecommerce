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