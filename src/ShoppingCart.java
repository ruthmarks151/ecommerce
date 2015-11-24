import java.util.ArrayList;

public class ShoppingCart extends User {
    private ArrayList<Item> content = new ArrayList<>();

    public ShoppingCart(String name) {
        super(name);
    }

    public ShoppingCart(User u){super(u.getUsername());}

    public String getContent(){
        return null;
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
            String price = i.fillString(i.getPrice() + "", 10);
            sb.append(name+quantity+price+"\n");

            if (i instanceof CD || i instanceof Book){
                enviroTaxTotal += i.getPrice() * i.getQuantity() * 0.02;
                shippingTotal += i.getPrice() * i.getQuantity() * 0.1;
            }
            hstTotal += i.getPrice() * i.getQuantity() * 0.13;
            basePriceTotal  += i.getPrice() * i.getQuantity();


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
    }

}
