package CargoSystem;
import java.util.*;

public class AdminProvider {
    public static final int EXIT = 4;



    public static final int ADD_BRANCH = 1;

    public static final int BRANCH_EDITOR = 2;
    public static final int LIST_ALL_BRANCHES = 3;
    Administrator showMenu=new Administrator();

    private Map<String, Branch> brancEmployeeList;
    Scanner scan = new Scanner(System.in);

    BranchProvider branchAdd;
    BranchProvider courierAdd;


    public void setCourierAdd(BranchProvider courierAdd) {
        this.courierAdd = courierAdd;
    }

    public void setBranchAdd(BranchProvider branchAdd) {
        this.branchAdd = branchAdd;
        brancEmployeeList=new HashMap<String, Branch>();
        branchAdd.setBranchList((HashMap<String, Branch>) brancEmployeeList);
    }

    public AdminProvider() {


    }

    public void adminProviderChoisePanel(int choise){
        boolean controlExitFlag=false;
        while(!controlExitFlag){
            System.out.println("\n" +
                    "WELCOME TO Admin Panel. Please Select Your Action.");
            showMenu.WriteMenu();
            int  choice = scan.nextInt();
            if(choice == EXIT){
                System.out.println("YOU ARE OUT OF MAIN MENU.");
                controlExitFlag=true;
                break;
            } else  {
                switch (choice) {

                    case ADD_BRANCH:
                        branchAdd.branchAdd();
                        break;
                    case BRANCH_EDITOR:
                        BranchEditorProvider branchEditorProvider = new BranchEditorProvider();
                        branchEditorProvider.branchEditorPanel(branchAdd);
                        break;
                    case LIST_ALL_BRANCHES:
                        branchAdd.listAllBranches();
                    default:
                        System.out.println("\n" +
                                "Please Select One of the Operations on the Screen");}
            }
        }
    }
    //NOT: bu kodu büşra anlattı ama  anlamadım anlatmasını rica edicem zafer yada doğan hocadan.
    public void brancEmpList(){
        System.out.println("Branch Employee List: ");
        Set set =brancStaffList.keySet();
        Iterator ıterator=set.iterator();

        while(ıterator.hasNext()){
            Administrator value= brancStaffList.get(ıterator.next());
        }
    }
    public void courierEmpList(){
        System.out.println("Branch Employee List: ");
        Set set =courierStaffList.keySet();
        Iterator ıterator=set.iterator();

        while(ıterator.hasNext()){
            Administrator value= courierStaffList.get(ıterator.next());
        }
    }


    private Map<String, Administrator> brancStaffList=new HashMap<String,Administrator>();;

    public void branchStaffAdd(){
        System.out.print("Branch Personel name: ");
        String branchPersonelName = scan.next();
        System.out.print("Branch Personel number: ");
        int branchPersonelNumber  =scan.nextInt();
        Administrator branchEmp = new Administrator(branchPersonelNumber,branchPersonelName);
        brancStaffList.put(String.valueOf(branchEmp.getBrancheEmpId()),branchEmp);
        System.out.println("Branch Personel name= "+branchEmp.getBranchEmpName()+" and branch Personel number= "
                + branchEmp.getBrancheEmpId() + "  user added to system.");
    }
    public void branchRemove(){

        if (!brancStaffList.isEmpty()){
            System.out.println("Please select branch employee give the Id: ");
            int selectedBranchStaffId = scan.nextInt();
            Administrator removeBranchEmp = brancStaffList.remove(String.valueOf(selectedBranchStaffId));
            if (removeBranchEmp == null) {
                System.out.println("Branch Employee does not exist try another");
            } else {
                System.out.println(" Branch Employee removed successfully");
            }

        }else {
            System.out.println("Please add branch employee");
        }
    }
    private HashMap<String, Administrator> courierStaffList=new HashMap<String,Administrator>();;

    //Listeye ekleme yapmıyor eklemeye yapamadığı içinde yazdırmıyor.!!!!!!!
    public void courierStaffAdd(){
        System.out.print("Courier Employee name: ");
        String courierEmpName = scan.next();
        System.out.print("Courier Employee number: ");
        int  courierEmpNumber  =scan.nextInt();
        //Administrator courierEmployee = new Administrator(courierEmpNumber, courierEmpName);
        Administrator courierEmployee = new Administrator();
        courierEmployee.setCourierEmpId(courierEmpNumber);
        courierEmployee.setCourierEmpName(courierEmpName);
        courierStaffList.put(String.valueOf(courierEmployee.getCourierEmpId()),courierEmployee);
        System.out.println("Courier Employee name= "+courierEmployee.getCourierEmpName()+" and Courier" +
                " Employee number= "
                + courierEmployee.getCourierEmpId() + "  user added to system.");
    }

    public void courierRemove(){
        if (!courierStaffList.isEmpty()){
            System.out.println("Please select branch employee give the Id: ");
            int selectedCourierEmpId = scan.nextInt();
            Administrator removeCourierEmp = courierStaffList.remove(String.valueOf(selectedCourierEmpId));
            if (removeCourierEmp == null) {
                System.out.println("Courier Employee does not exist try another");
            } else {
                System.out.println(" Courier Employee removed successfully");
            }
        }
    }
    public void listBrancEmpInfo(){
        for(Map.Entry<String,Administrator> c : brancStaffList.entrySet()){
            System.out.println("Branch Personel Id="+c.getValue().getBrancheEmpId()+
                    ",  Branc Personel Name:"+c.getValue().getBranchEmpName());
        }
    }

    public void listTransportEmpInfo(){
        for(Map.Entry<String,Administrator> c : courierStaffList.entrySet()){
            System.out.println("Transport Employee Id="+c.getValue().getCourierEmpId()+
                    " ,  Transport Employee Name:"+c.getValue().getCourierEmpName());
        }
    }
}



