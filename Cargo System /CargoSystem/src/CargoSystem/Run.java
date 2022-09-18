package CargoSystem;

import java.util.Scanner;

public  class Run  {
    public static final int EXIT = 5;
    public static final int SHOW_ADMIN_PANEL = 1;
    public static final int SHOW_BRUNCH_EMPLOYEE_PANEL = 2;
    public static final int SHOW_COURİER_PANEL = 3;
    public static final int SHOW_CUSTOMER_PANEL = 4;

    boolean controlExitFlag=false;
    AdminProvider adminProvider=new AdminProvider();
    BranchProvider branchProvider=new BranchProvider();
    CustomerProvider customerProvider=new CustomerProvider();
    TransportEmployeeProvider transportProvider=new TransportEmployeeProvider();

    public Run() {
        customerProvider.setCargoInf(branchProvider);
        transportProvider.setUpdateStatus(branchProvider);
        adminProvider.setBranchAdd(branchProvider);
    }
    public void runPanel(){
        while (!controlExitFlag){
        System.out.println("Welcome to Cargo Company Automation System \n Please Select the User Panel You Want to Operate");
        System.out.println("1-)Admin");
        System.out.println("2-)Branch Employee");
        System.out.println("3-)Transport Personel");
        System.out.println("4-)Customer");
        System.out.println("5-)OUT OF THE SYSTEM");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            while (true){
                if(choice == EXIT){
                    System.out.println("YOU ARE OUT OF SYSTEM.");
                    controlExitFlag=true;
                    break;
                } else  {

                    switch (choice) {
                            case SHOW_ADMIN_PANEL:
                               adminProvider.adminProviderChoisePanel(choice);

                                break;
                            case SHOW_BRUNCH_EMPLOYEE_PANEL:
                                branchProvider.branchCheck();
                                break;

                            case SHOW_COURİER_PANEL:
                                transportProvider.transportChoisePanel();

                                break;

                            case SHOW_CUSTOMER_PANEL:
                             customerProvider.customerChoisePanel();
                                break;
                        default:
                }    System.out.println("Chooise one of the actions on the screen");
                            break;}
                }
            }
        }
    }
