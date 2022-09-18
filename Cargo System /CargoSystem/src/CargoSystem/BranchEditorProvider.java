package CargoSystem;

import java.util.Map;
import java.util.Scanner;

public class BranchEditorProvider {

    public static final int EXIT = 10;
    public static final int ADD_BRANCH_EMPLOYEE = 1;
    public static final int DELETE_BRANCH_EMPLOYEE = 2;
    public static final int GET_BRANCH_EMPLOYEE = 3;
    public static final int LIST_ALL_BRANCH_EMPLOYEES = 4;
    public static final int ADD_TRANSPORT_EMPLOYEE = 5;
    public static final int DELETE_TRANSPORT_EMPLOYEE = 6;
    public static final int GET_TRANSPORT_EMPLOYEE = 7;
    public static final int LIST_ALL_TRANSPORT_EMPLOYEES = 8;

    public static final int DELETE_BRANCH = 9;





    Branch branch;

    BranchProvider branchProvider ;


    Scanner scan = new Scanner(System.in);


    public void branchEditorPanel(BranchProvider bprovider) {
        boolean controlExitFlag = false;
        branchProvider = bprovider;
        while (!controlExitFlag) {

            {
                if(branch == null){
                    System.out.println("WELCOME to the Branch Edit Panel. Please Enter Branch Name:");
                    String branchName = scan.next();

                    branch = branchProvider.getBranch(branchName);
                    if(branch == null){
                        System.out.println("This branch cant be found");
                        controlExitFlag = true;
                        break;
                    }

                }

                System.out.println("1-)Add Branch Employee.");
                System.out.println("2-)Delete Branch Employee.");
                System.out.println("3-)Get Branch Employee.");
                System.out.println("4-)List All Branch Employees.");
                System.out.println("5-)Add Transport Employee.");
                System.out.println("6-)Delete Transport Employee.");
                System.out.println("7-)Get Transport Employee.");
                System.out.println("8-)List All Transport Employees.");
                System.out.println("9-)Delete This Branch.");
                System.out.println("10-) Back to Main Menu");
                int choise = scan.nextInt();
                if (choise == EXIT) {
                    System.out.println("YOU ARE OUT OF MAIN MENU.");
                    controlExitFlag = true;
                    //break;
                } else {
                    switch (choise) {

                        case ADD_BRANCH_EMPLOYEE:
                            addBranchEmployee();
                            break;
                        case DELETE_BRANCH_EMPLOYEE:
                            deleteBranchEmployee();
                            break;
                        case GET_BRANCH_EMPLOYEE:
                            getBranchEmployee();
                            break;
                        case LIST_ALL_BRANCH_EMPLOYEES:
                            listAllBranchEmployees();
                            break;
                        case ADD_TRANSPORT_EMPLOYEE:
                            addTransportEmployee();
                            break;
                        case DELETE_TRANSPORT_EMPLOYEE:
                            deleteTransportEmployee();
                            break;
                        case GET_TRANSPORT_EMPLOYEE:
                            getTransportEmployee();
                            break;
                        case LIST_ALL_TRANSPORT_EMPLOYEES:
                            listAllTransportEmployees();
                            break;
                        case DELETE_BRANCH:
                            deleteThisBranch();
                            controlExitFlag = true;
                            break;
                        default:
                            System.out.println("Please Select One of the Operations on the Screen");
                    }
                }
            }
        }
    }

    public void deleteThisBranch(){

        branchProvider.deleteBranch(branch.getBranchName());
        System.out.println("Branch Successfully Deleted");

    }
    public void addBranchEmployee(){
        System.out.println("Branch Employee Name:");
        String empName = scan.next();
        System.out.println("Branch Employee ID Number");
        int empID = scan.nextInt();
        BranchEmployee branchEmployee = new BranchEmployee(empID,empName);
        branch.addBranchEmployee(empID,branchEmployee);
        System.out.println("Employee Added To Branch");
    }

    public void deleteBranchEmployee(){
        System.out.println("Enter Branch Employee ID");
        branch.deleteBranchEmployee(scan.nextInt());
    }

    public void getBranchEmployee(){
        System.out.println("Enter Branch Employee ID");
        branch.getBranchEmployee(scan.nextInt());
    }

    public void listAllBranchEmployees(){
            for(Map.Entry<Integer,BranchEmployee> employee : branch.getBranchEmployeeList().entrySet()){
                System.out.println("Employee ID: "+ employee.getValue().getEmployeeName() + "\nEmployee ID: "+ employee.getKey());
        }
    }

    public void addTransportEmployee(){
        System.out.println("Transport Employee Name:");
        String empName = scan.next();
        System.out.println("Transport Employee ID Number");
        int empID = scan.nextInt();
        TransportEmployee transportEmployee = new TransportEmployee(empID,empName);
        branch.addTransportEmployee(empID,transportEmployee);
        System.out.println("Employee Added To Branch");
    }

    public void deleteTransportEmployee(){
        System.out.println("Enter Transport Employee ID");
        branch.deleteTransportEmployee(scan.nextInt());
    }

    public void getTransportEmployee(){
        System.out.println("Enter Transport Employee ID");
        branch.getTransportEmployee(scan.nextInt());
    }

    public void listAllTransportEmployees(){
        for(Map.Entry<Integer,TransportEmployee> employee : branch.getTransportEmployeeList().entrySet()){
            System.out.println("Employee ID: "+ employee.getValue().getTransportEmployeeName() + "\nEmployee ID: "+ employee.getKey());
        }
    }
}
