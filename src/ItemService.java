import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ItemService {

    private ArrayList<Readable> readables = new ArrayList<>();
    private ArrayList<Audio> audios = new ArrayList<>();
    private UserService us;

    public ItemService(UserService userService) {
        us = userService;
        loadBooks();
        loadEbooks();
        loadCDs();
        loadMP3s();
        System.out.println("");
    }



    private void loadBooks(){
        String line;
        try (
                InputStream fis = new FileInputStream("Books.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {

            while ((line = br.readLine()) != null) {
                try {
                    String[] elements = line.split(",");
                    for (int i = 0; i < elements.length; i++) {
                        elements[i] = elements[i].trim();
                    }
                    int serial = Integer.parseInt(elements[0]);
                    String title = elements[1];
                    String author = elements[2];
                    int price = Integer.parseInt(elements[3]);
                    int quantity = Integer.parseInt(elements[4]);

                    readables.add(new Book(serial,title,author,price,quantity));
                }catch (Exception e){
                    System.out.println("Books.txt is malformed, please modify "+System.getProperty("user.dir")+"Books.txt");
                    System.out.println("Inspect the line:");
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            System.out.println("Books.txt could not be found, please place it in "+System.getProperty("user.dir"));
        }
    }

    private void loadEbooks(){
        String line;
        try (
                InputStream fis = new FileInputStream("Ebooks.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {

            while ((line = br.readLine()) != null) {
                try {
                    String[] elements = line.split(",");
                    for (int i = 0; i < elements.length; i++) {
                        elements[i] = elements[i].trim();
                    }
                    int serial = Integer.parseInt(elements[0]);
                    String title = elements[1];
                    String author = elements[2];
                    int price = Integer.parseInt(elements[3]);
                    int quantity = Integer.parseInt(elements[4]);

                    readables.add(new eBook(serial,title,author,price,quantity));
                }catch (Exception e){
                    System.out.println("Ebooks.txt is malformed, please modify "+System.getProperty("user.dir")+"Ebooks.txt");
                    System.out.println("Inspect the line:");
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            System.out.println("Ebooks.txt could not be found, please place it in "+System.getProperty("user.dir"));
        }
    }

    private void loadMP3s(){
        String line;
        try (
                InputStream fis = new FileInputStream("MP3.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {

            while ((line = br.readLine()) != null) {
                try {
                    String[] elements = line.split(",");
                    for (int i = 0; i < elements.length; i++) {
                        elements[i] = elements[i].trim();
                    }
                    int serial = Integer.parseInt(elements[0]);
                    String title = elements[1];
                    String artist = elements[2];
                    int price = Integer.parseInt(elements[3]);
                    int quantity = Integer.parseInt(elements[4]);

                    audios.add(new MP3(serial,title,artist,price,quantity));
                }catch (Exception e){
                    System.out.println("MP3.txt is malformed, please modify "+System.getProperty("user.dir")+"MP3.txt");
                    System.out.println("Inspect the line:");
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            System.out.println("MP3.txt could not be found, please place it in "+System.getProperty("user.dir"));
        }
    }

    private void loadCDs(){
        String line;
        try (
                InputStream fis = new FileInputStream("CDs.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {

            while ((line = br.readLine()) != null) {
                try {
                    String[] elements = line.split(",");
                    for (int i = 0; i < elements.length; i++) {
                        elements[i] = elements[i].trim();
                    }
                    int serial = Integer.parseInt(elements[0]);
                    String title = elements[1];
                    String artist = elements[2];
                    int price = Integer.parseInt(elements[3]);
                    int quantity = Integer.parseInt(elements[4]);

                    audios.add(new CD(serial,title,artist,price,quantity));
                }catch (Exception e){
                    System.out.println("CDs.txt is malformed, please modify "+System.getProperty("user.dir")+"CDs.txt");
                    System.out.println("Inspect the line:");
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            System.out.println("CDs.txt could not be found, please place it in "+System.getProperty("user.dir"));
        }
    }

    private void saveBooks(){
        BufferedWriter output = null;

        try {
            File file = new File("Books.txt");
            output = new BufferedWriter(new FileWriter(file));

            for (Readable r:getReadables()){
                if (r instanceof  Book){
                    Book b = (Book)r;
                    output.write((b.getSerial())+","+b.getName()+","+b.getAuthor()+","+b.getBasePrice()+","+b.getQuantity()+"\n");
                }
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null )
                try {
                    output.close();
                }catch (IOException e){
                    throw new RuntimeException("Unable to close Books.txt");
                }
        }

    }

    private void saveEbooks(){
        BufferedWriter output = null;

        try {
            File file = new File("Ebooks.txt");
            output = new BufferedWriter(new FileWriter(file));

            for (Readable r:getReadables()){
                if (r instanceof  eBook){
                    eBook b = (eBook)r;
                    output.write((b.getSerial())+","+b.getName()+","+b.getAuthor()+","+b.getBasePrice()+","+b.getQuantity()+"\n");
                }
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null )
                try {
                    output.close();
                }catch (IOException e){
                    throw new RuntimeException("Unable to close Ebooks.txt");
                }
        }

    }

    private void saveCDs(){
        BufferedWriter output = null;

        try {
            File file = new File("CDs.txt");
            output = new BufferedWriter(new FileWriter(file));

            for (Audio a:getAudios()){
                if (a instanceof  CD){
                    CD c = (CD)a;
                    output.write((c.getSerial())+","+c.getName()+","+c.getArtist()+","+c.getBasePrice()+","+c.getQuantity()+"\n");
                }
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null )
                try {
                    output.close();
                }catch (IOException e){
                    throw new RuntimeException("Unable to close CDs.txt");
                }
        }

    }

    private void saveMP3s(){
        BufferedWriter output = null;

        try {
            File file = new File("MP3.txt");
            output = new BufferedWriter(new FileWriter(file));

            for (Audio a:getAudios()){
                if (a instanceof  MP3){
                    MP3 m = (MP3)a;
                    output.write((m.getSerial()) + "," + m.getName() + "," + m.getArtist() + "," + m.getBasePrice() + "," + m.getQuantity()+"\n");
                }
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null )
                try {
                    output.close();
                }catch (IOException e){
                    throw new RuntimeException("Unable to close MP3.txt");
                }
        }

    }

    private void saveAll(){
        saveBooks();
        saveCDs();
        saveEbooks();
        saveMP3s();
    }

    public Item getItem(int serial){
        for (Readable r:readables){
            if (r.getSerial() == serial)
                return r;
        }
        for (Audio a:audios){
            if (a.getSerial() == serial)
                return a;
        }
        return null;

    }

    public boolean isReadable(int serial){
        for (Readable r:readables){
            if (r.getSerial() == serial)
                return true;
        }
        return false;
    }

    public boolean isAudio(int serial){
        for (Audio a:audios){
            if (a.getSerial() == serial)
                return true;
        }
        return false;
    }

    public boolean available(int serial, int amount){
        return getItem(serial).available(amount);
    }

    public String getName(int serial){
        return getItem(serial).getName();
    }

    public String getType(int serial){
        return getItem(serial).getType();
    }

    public String addToCart(int serial, int amount){
        Item item = getItem(serial);

        StringBuilder sb = new StringBuilder();
        sb.append(amount);
        sb.append(" ");
        sb.append(item.getName());
        sb.append(" ");
        sb.append(item.getType());
        if (amount != 1)
            sb.append("s");
        sb.append(" ");
        if (available(serial,amount)){
            if (us.authenticated()) {
                us.addItem(item.buy(amount));
                sb.append("successfully added to your cart");
            }else {
                sb.append("could not be added to your cart");
            }
        }else{
            sb.append("could not be added to your cart");
        }
        saveAll();
        return sb.toString();
    }

    ArrayList<Readable> getReadables(){
        return (ArrayList<Readable>)readables.clone();

    }

    ArrayList<Audio> getAudios(){
        return (ArrayList<Audio>)audios.clone();
    }
}
