import java.util.ArrayList;
import java.util.Hashtable;

public class ItemService {


    public boolean isReadable(int serial){
        return true;
    }

    public boolean isAudio(int serial){
        return true;
    }

    public boolean available(int serial, int amount){
        return amount > 0;
    }

    public String getName(int serial){
        return "Item name";
    }

    public String getType(int serial){
        return "Type";
    }

    public String addToCart(int serial, int amount){


        StringBuilder sb = new StringBuilder();
        sb.append(amount);
        sb.append(" ");
        sb.append(getName(serial));
        sb.append(" ");
        sb.append(getType(serial));
        if (amount != 1)
            sb.append("s");
        sb.append(" ");
        if (available(serial,amount)){
            sb.append("successfully added to your cart");
        }else{
            sb.append("could not be added to your cart");
        }
        return sb.toString();
    }

    ArrayList<Readable> getReadables(){
        ArrayList<Readable> books = new ArrayList<>();
        Readable book = new eBook(1,"This is a book","Book Writer",100,10);
        books.add(book);


        return books;

    }

    ArrayList<Audio> getAudios(){
        ArrayList<Audio> audios = new ArrayList<>();
        Audio cd = new MP3(2,"This is music","Singing Person",100,5);
        audios.add(cd);
        return audios;

    }
}
