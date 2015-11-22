import java.util.ArrayList;
import java.util.Hashtable;

public class Page8 extends Page{

    Page8(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    @Override
    public int getPageNo() {
        return 8;
    }

    @Override
    public int render() {
        //                  12345123451234512345123451234512345123451234512345123451234512345123451234512345
        System.out.println("S.No Name of the Book    Author              Price($)  Quantity in Store   Type");
        ArrayList<Readable> readables = is.getReadables();
        for (Readable r:readables){
            System.out.println(r.getInfo());
        }

        return 0;
    }
}
