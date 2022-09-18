package CargoSystem;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerProvider {
    Customer showMenu = new Customer();
    Scanner scan = new Scanner(System.in);
    public static final int EXIT = 2;
    BranchProvider cargoInf;

    public void setCargoInf(BranchProvider cargoInf) {
        this.cargoInf = cargoInf;
    }

    public void customerChoisePanel() {
        boolean controlExitFlag = false;
        while (!controlExitFlag) {

            {
                System.out.println("WELCOME to the Customer Panel. What to do Please choose.");
                showMenu.WriteMenu();
                int choise = scan.nextInt();
                if (choise == EXIT) {
                    System.out.println("YOU ARE OUT OF MAIN MENU.");
                    controlExitFlag = true;
                    //break;
                } else {
                    switch (choise) {

                        case 1:
                            System.out.println("Enter the Cargo ID please.");
                            Scanner scan = new Scanner(System.in);
                            String cargoId = scan.next();
                            cargoInf.writeCargoInfById(cargoId);
                            break;


                        default:
                            System.out.println("Please Select One of the Operations on the Screen");
                    }
                }

            }
        }
    }

}

