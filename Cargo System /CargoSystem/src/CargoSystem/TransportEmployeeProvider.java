package CargoSystem;

import java.util.Scanner;

public class TransportEmployeeProvider {

    public static final int EXIT = 2;
    BranchProvider updateStatus;

    public void setUpdateStatus(BranchProvider updateStatus) {
        this.updateStatus = updateStatus;
    }

    Scanner scan = new Scanner(System.in);

    // buraya bir adet switch case oluştur burada kurye seçimlerini ,iç işlemlerini gerçekleştir.
    public void transportChoisePanel() {
        boolean controlExitFlag = false;
        while (!controlExitFlag) {

            {
                System.out.println("WELCOME to the Transport Personel Panel. What to do Please choose.");
                System.out.println("1-)Cargo is to sumbit.");
                System.out.println("2-) Back to Main Menu");
                int choise = scan.nextInt();
                if (choise == EXIT) {
                    System.out.println("YOU ARE OUT OF MAIN MENU.");
                    controlExitFlag = true;
                    //break;
                } else {
                    switch (choise) {

                        case 1:
                         updateStatus.updateCargoInf();
                            break;


                        default:
                            System.out.println("Please Select One of the Operations on the Screen");
                    }
                }
            }
        }
    }
}
