/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: Page 8 as is defined in the specifications document
*/
import java.util.ArrayList;
import java.util.Scanner;

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

        System.out.println("Readables");
        System.out.println();
        //                  1234512345123451234512345123451234512345123451234512345123451234512345123451234512345
        System.out.println("S.No Name of the Book         Author              Price($)  Quantity in Store   Type");
        ArrayList<Readable> readables = is.getReadables();
        for (Readable r:readables){
            System.out.println(r.getInfo());
        }


        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int serial = -1;
        do {
            System.out.println("Press -1 to return to the previous menu.");
            System.out.print("Choose your option: ");
            String input = sc.next();
            if (input.equals("-1")){
                return 6; // Goto page 6, the category page
            }
            try{
                serial = Integer.parseInt(input);
                if (is.isReadable(serial)){
                    loop = false;
                }else{
                    System.out.println("Please enter the serial number of a readable");
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter an integer serial number");
            }
        } while (loop);

        int quantity = -1;
        loop = true;
        do {
            System.out.print("Enter quantity: ");
            String input = sc.next();
            if (input.equals("-1")){
                return 6; // Goto page 6, the category page
            }
            try{
                quantity = Integer.parseInt(input);
                if (is.available(serial,quantity)){
                    loop = false;
                }else{
                    System.out.println("Please enter an amount you can actually purchase");
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter an integer amount");
            }
        } while (loop);

        String result = is.addToCart(serial,quantity);
        System.out.println(result);
        System.out.println();
        do{
            System.out.print("Press -2 to Continue Shopping or Press 0 to check out:");
            String input = sc.next();
            if (input.equals("0"))
                return 10;
            else if (input.equals("-2"))
                return 6;
        }while (true);
    }
}
