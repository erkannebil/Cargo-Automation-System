package CargoSystem;
import java.util.*;

public class BranchProvider {

    public static final int EXIT = 11;
    public static final int CARGO_INFORMATION_ADD = 1;
    public static final int CARGO_STATUS_UPDATE = 2;
    public static final int CARGO_ALL_INFORMATION_LIST = 3;
    public static final int CUSTOMER_ADD = 4;
    public static final int CUSTOMER_DELETE = 5;
    public static final int LIST_ALL_CUSTOMERS = 6;


    Scanner scan = new Scanner(System.in);
    Branch showMenu=new Branch();
    Branch addBranch=new Branch();
    HashMap<String,Cargo> cargos = new HashMap<String,Cargo>();



    public void brunchProviderChoisePanel(int choise) {

            boolean controlExitFlag=false;
            while(!controlExitFlag){
            System.out.println("WELCOME to the Branch Personnel Panel. What to do Please choose.");
            showMenu.WriteMenu();
            choise = scan.nextInt();
                if(choise == EXIT){
                    System.out.println("YOU ARE OUT OF MAİN MENU.");
                    controlExitFlag=true;
                    break;
                } else  {
            switch (choise) {

                case CARGO_INFORMATION_ADD:
                    addCargoInfo();
                    System.out.println("Cargo information has been ADDED to the system");
                    break;
                case CARGO_STATUS_UPDATE:
                    updateCargoInf();
                    System.out.println("Cargo Status Information Updated");
                    break;
                case CARGO_ALL_INFORMATION_LIST:
                    System.out.println("*********Cargo Information List**********.");
                    listAllCargoInfo();
                    break;
                case CUSTOMER_ADD:
                    System.out.println("The new customer has been added to the system.");
                    newAddCustomer();

                    break;
                case CUSTOMER_DELETE:
                    System.out.println("The customer record has been deleted from the systemCargo ");
                    System.out.println("Enter the customer name:");
                    String customerSurname = scan.next();
                    removeCustomer(customerSurname);
                    break;
                case LIST_ALL_CUSTOMERS:
                    listAllCustomerInfo();
                    break;

                default:
                    System.out.println("Please Select One of the Operations on the Screen");
            }
                }
            }
        }
    public void branchCheck() {
        System.out.println("Enter the branch Name=");
        String branchCheckFromUser =scan.next();
        System.out.println(brancList.toString());
        if(brancList.containsKey(branchCheckFromUser)){
            System.out.println("Choice the operation");
            showMenu.WriteMenu();
            int choice =scan.nextInt();
            brunchProviderChoisePanel(choice);
        }else System.out.println("Please firstly add branch ");
    }


    private HashMap<String, Branch> brancList;

    public void setBranchList(HashMap<String, Branch> bl) {
        brancList=bl;
    }

    public HashMap<String, Branch> getBrancList() {
        return brancList;
    }

    public void setBrancList(HashMap<String, Branch> brancList) {
        this.brancList = brancList;
    }

    public void branchAdd(){
        System.out.print("Branch name: ");
        String branchName = scan.next();
        System.out.print("Branch number: ");
        int branchID = scan.nextInt();
        Branch newBranch = new Branch(branchID,branchName);

        brancList.put(branchName,newBranch);
        System.out.println("Branch name= "+branchName+" and branch number= "
                + branchID + " added to system.");
        System.out.println("-----------------------------------");

    }


    public void deleteBranch(String Name){
        brancList.remove(Name);
    }
    public Branch getBranch(String Name){
        return brancList.get(Name);
    }

    public void listAllBranches(){

        for(Map.Entry<String,Branch> branch: brancList.entrySet()){
            System.out.println("Branch Name: "+ branch.getKey() + "-- Branch ID:" + branch.getValue().getBrancheId());
        }
    }

    /* Kullanıcıdan kargo bilgilerini doldurmasını isteyen fonksiyon.
     Kod tekrarının engellenmesi için yazıldı. Fonksiyonel bir özelliği yok  */
    public Cargo getCargoInfoFromUser(){
        Cargo newCargo = new Cargo();
        System.out.println("Enter Cargo Id:");
       newCargo.setCargoId( scan.next());
        System.out.print("Enter Customer NAME: ");
        newCargo.setCargoCustomerName(scan.next());
        System.out.print("Enter Cargo Sender Information: ");
        newCargo.setCargoSender(scan.next());
        System.out.print("Enter Cargo Reciever Information: ");
        newCargo.setCargoReciever(scan.next());
        System.out.print("Enter Cargo Status: ");
        newCargo.setCargoStatus(scan.next());
        System.out.print("Enter Cargo target: ");
        newCargo.setCargoTarget(scan.next());
        System.out.println(" \n Cargo ID is added the System");
        return newCargo;
    }

    /* Yeni kargo bilgisi eklenmesi. Eğer bu id kodu ile kargo bilgisi yok ise hashmape yeni bir bilgi eklemesi yapılıyor
    * eğer bu id ile kargo varsa güncelleme için izin istiyor.  */
    public void addCargoInfo(){

        Cargo _cargo = getCargoInfoFromUser();
        if(cargos.containsKey(_cargo.getCargoId())){
            System.out.println("This cargo already exists (Cargo id must be unique). Do you want to" +
                    " update existing cargo information (y/n)");
            String updateAnswer = scan.next();
            switch (updateAnswer){
                case "y":
                case "Y":
                    updateCargoInf(_cargo);
                    break;
                case "n":
                case "N":
                default:
                    break;
            }
        }
        else{
            cargos.put(_cargo.getCargoId(),_cargo);

        }
    }
    // Bütün kargo bilgilerinin listelenmesi için metot.
    public void listAllCargoInfo(){
        for(Map.Entry<String,Cargo> c : cargos.entrySet()){
            System.out.println("Cargo ID="+c.getValue().getCargoId()
                    +",   Cargo customer name="+c.getValue().getCargoCustomerName()+
                    ",   Cargo sender Information= "+c.getValue().getCargoSender()
                    +",    Cargo receiver Information="+c.getValue().getCargoReciever()+
                    ",   Cargo status Information="+c.getValue().getCargoStatus()
                    +",    Cargo target Information="+c.getValue().getCargoTarget());
                    }
    }
    // Id'si verilen kargonun bilgilerinin bulunması için metot.
   public void writeCargoInfById(String id) {

       Cargo c = cargos.get(id);
       System.out.println("Cargo ID=" + c.getCargoId()
               + "\n Your chose Cargo customer name:" + c.getCargoCustomerName() +
               "\n" + " Your chose Cargo sender ınformation: " + c.getCargoSender()
               + "\n Your chose cargo receiver ınformation:" + c.getCargoReciever() +
               "\n Your chose Cargo status information: " + c.getCargoStatus()
               + "\n Your chose  Cargo target ınformation: " + c.getCargoTarget());

   }

        //Halihazırda sistemde bulunan kargo bilgilerinin kargo id'si ile
    // bulunup güncellenmesi için yazılan metotlar.
public  void updateCargoInf(Cargo newcargo){
        cargos.put(newcargo.getCargoId(),newcargo);
        System.out.println("Cargo information updated.");
    System.out.println("Cargo ID="+newcargo.getCargoId()
            +"\n NEW Cargo customer name"+newcargo.getCargoCustomerName()+
            "\n"+"NEW  Cargo sender ınformation= "+newcargo.getCargoSender()
            +"\n NEW Cargo receiver ınformation="+newcargo.getCargoReciever()+
            "\n NEW  Cargo status information"+newcargo.getCargoStatus()
            +"\n NEW  Cargo target ınformation="+newcargo.getCargoTarget());

}
/*
//SADECE STATÜYÜ GÜNCELLEMEK İSTİYORUM.HERŞEYİ GÜNCELLİYOR.
    public  void updateCargoStatusInf(Cargo newcargo){
        cargos.put(newcargo.getCargoId(),newcargo);
        System.out.println("Write new Status Information=");
        String newStatu=scan.next();
        newcargo.setCargoStatus(newStatu);
        System.out.println("Update process has done succesfully");

    }*/
// Güncelleme için yazılan parametresiz overload metotu.
public void updateCargoInf(){
        Cargo newcargo = getCargoInfoFromUser();
        cargos.put(newcargo.getCargoId(),newcargo);
        System.out.println("Cargo information updated.");


}
    HashMap<String,Customer> customer = new HashMap<String,Customer>();
    public Customer getCustomersInfoFromUser(){
        Customer newCustomer = new Customer();
        System.out.println("Enter Customer Name:");
        newCustomer.setCustomerName( scan.next());
        System.out.print("Enter Customer Surname:");
        newCustomer.setCustomerSurname(scan.next());
        System.out.println(" \n Customer is added the System");
        return newCustomer;
    }
    public void newAddCustomer(){
        Customer _customer = getCustomersInfoFromUser();
        customer.put(_customer.getCustomerName(),_customer);
    }
    public void removeCustomer(String customerSurname){
        customer.remove(customerSurname);
        System.out.println("Success the delete operation");
    }


    public void listAllCustomerInfo(){
            for(Map.Entry<String,Customer> c : customer.entrySet()){
                System.out.println("Cargo Name="+c.getValue().getCustomerName()
                        +",   Cargo customer Surname="+c.getValue().getCustomerSurname());

            }
    }
}









