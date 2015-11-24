/*
* Name:​ Ryan Marks, Nishanth Balamohan, Kabir Kenth
* MacID:​ MarksR2, balamon, kenthks
* Student Number:​ 001406077, 001411319, 001429801
* Description: Page 10 as is defined in the specifications document
*/
import java.util.Scanner;

public class Page10 extends Page{
    Page10(UserService userService, ItemService itemService) {
        super(userService, itemService);
    }

    @Override
    public int getPageNo() {
        return 0;
    }

    @Override
    public int render() {
        System.out.println(us.getBilling());
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print("Are you sure you wamt to pay? yes or no. ");
            input = sc.next();
        }while (!(input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("No")));
        if (input.equalsIgnoreCase("Yes")){
            String user = us.getAuthedUserName();
            String confNo = us.checkout();
            System.out.println("Confirmation ID:"+confNo);
            System.out.println("Items shipped to Mr."+user);
            return -1;
        }else{
            return 5;
        }
    }
}
