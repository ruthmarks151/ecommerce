import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart extends User {
    private ArrayList<Item> content = new ArrayList<>();
    private ArrayList<Date> purchaseDates = new ArrayList<>();

    public ShoppingCart(String name) {
        super(name);
    }

    public ShoppingCart(User u){super(u.getUsername());}

    public String checkout(){
        StringBuilder sb = new StringBuilder();
        int total = 0;
        File file = new File("Cart"+getUsername()+".txt");
        file.delete();
        for (Item i:content){
            sb.append(i.getName());
            sb.append(" ");
            total += i.getPrice() * i.getQuantity();
        }
        sb.append(total);
        content = new ArrayList<>();
        purchaseDates = new ArrayList<>();
        return sb.toString();
    }

    private void saveCart(){
        BufferedWriter output = null;

        try {
            File file = new File("Cart"+getUsername()+".txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(getContent());
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

    public String getContent(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.size(); i++){
            Item item = content.get(i);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sb.append(item.getSerial());
            sb.append(',');
            sb.append(item.getName());
            sb.append(',');
            sb.append(sdf.format(purchaseDates.get(i)));
            sb.append(',');
            sb.append(item.getQuantity());
            sb.append('\n');

        }
        return sb.toString();
    }

    public String getCheckoutDetails(){
        StringBuilder sb = new StringBuilder();
        sb.append("Billing Information:\n");
        //         12345678901234567890123456789012345678901234567890
        sb.append("Name                          Quantity  Price\n");
        int enviroTaxTotal = 0;
        int hstTotal = 0;
        int shippingTotal = 0;
        int basePriceTotal = 0;
        for(Item i:content){
            String name = i.fillString(i.getName(),30);
            String quantity = i.fillString(i.getQuantity()+"",10);
            String price = i.fillString(i.getBasePrice() + "", 10);
            sb.append(name+quantity+price+"\n");

            if (i instanceof CD || i instanceof Book){
                enviroTaxTotal += i.getBasePrice() * i.getQuantity() * 0.02;
                shippingTotal += i.getBasePrice() * i.getQuantity() * 0.1;
            }
            hstTotal += i.getBasePrice() * i.getQuantity() * 0.13;
            basePriceTotal  += i.getBasePrice() * i.getQuantity();


        }
        int checkoutTotal = basePriceTotal+hstTotal+shippingTotal+enviroTaxTotal;

        sb.append("\n");
        //         12345678901234567890123456789012345678901234567890
        sb.append("          Environment Tax      2%      " + enviroTaxTotal+ "\n");
        sb.append("          HST                 13%      " + hstTotal + "\n");
        sb.append("\n");
        sb.append("          Shipping            10%      " + shippingTotal+"\n");
        sb.append("                                    ---------\n");
        sb.append("          Total                        " + checkoutTotal + "$\n");

        return sb.toString();
    }

    public void addItem(Item i){
        content.add(i);
        purchaseDates.add(new Date());
        saveCart();
    }

}
