package CargoSystem;

import java.util.HashMap;
import java.util.List;

public class Branch implements  WriteMenu {
    @Override
    public void WriteMenu() {

        System.out.println("1-)Add Cargo Information.");
        System.out.println("2-)Update Cargo İnformation.");
        System.out.println("3-)Cargo Information List.");
        System.out.println("4-)Add Customer.");
        System.out.println("5-)Remove Customer.");
        System.out.println("6-)List All Customer");
        System.out.println("7-)Add BranchEmployee Information.");
        System.out.println("8-)Delete BranchEmployee Information.");
        System.out.println("9-)Add TransportEmployee Information.");
        System.out.println("10-)Delete TransportEmployee Information.");
        System.out.println("11-)RETURN TO MAİN MENU PANEL");
    }

    private int brancheId;
    private String branchName;

    private HashMap<Integer,BranchEmployee> branchEmployeeList = new HashMap<Integer,BranchEmployee>();

    private HashMap<Integer,TransportEmployee> transportEmployeeList = new HashMap<Integer,TransportEmployee>();


    public Branch(int brancheId, String branchName) {
        this.brancheId = brancheId;
        this.branchName = branchName;
    }
    public Branch() {

    }


    public void addBranchEmployee(int ID , BranchEmployee Employee){
        branchEmployeeList.put(ID,Employee);
    }

    public void deleteBranchEmployee(int ID ){
        branchEmployeeList.remove(ID);
    }

    public BranchEmployee getBranchEmployee(int ID){
        return branchEmployeeList.get(ID);
    }

    public HashMap<Integer,BranchEmployee> getBranchEmployeeList(){
        return branchEmployeeList;
    }

    public  void addTransportEmployee(int ID , TransportEmployee transportEmployee){
        transportEmployeeList.put(ID,transportEmployee);
    }

    public void deleteTransportEmployee(int ID ){
        transportEmployeeList.remove(ID);
    }

    public TransportEmployee getTransportEmployee(int ID){
        return transportEmployeeList.get(ID);
    }

    public HashMap<Integer,TransportEmployee> getTransportEmployeeList(){
        return transportEmployeeList;
    }
    public int getBrancheId() {
        return brancheId;
    }

    public void setBrancheId(int brancheId) {
        this.brancheId = brancheId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}


