import java.util.ArrayList;
import java.util.Hashtable;

public class ItemService {

    ArrayList<Readable> getReadables(){
        ArrayList<Readable> books = new ArrayList<>();
        Readable book = new eBook(1,"This is a book","Book Writer",100,10);
        books.add(book);

        return books;

    }
}
