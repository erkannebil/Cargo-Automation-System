package CargoSystem;

public class
Administrator  implements  WriteMenu{
    private int brancheEmpId;
    private String branchEmpName;
    private int courierEmpId;
    private String courierEmpName;

    


    public Administrator(int brancheEmpId, String branchEmpName) {
        this.brancheEmpId = brancheEmpId;
        this.branchEmpName = branchEmpName;
    }

    public Administrator() {
    }

    public int getCourierEmpId() {
        return courierEmpId;
    }

    public void setCourierEmpId(int courierEmpId) {
        this.courierEmpId = courierEmpId;
    }

    public String getCourierEmpName() {
        return courierEmpName;
    }

    public void setCourierEmpName(String courierEmpName) {
        this.courierEmpName = courierEmpName;
    }
    public int getBrancheEmpId() {
        return brancheEmpId;
    }

    public void setBrancheEmpId(int brancheEmpId) {
        this.brancheEmpId = brancheEmpId;
    }

    public String getBranchEmpName() {
        return branchEmpName;
    }

    public void setBranchEmpName(String branchEmpName) {
        this.branchEmpName = branchEmpName;
    }

    @Override
    public void WriteMenu() {
       System.out.println(" 1-) Add Branch");
        System.out.println("2-)Open Branch Editor Panel");
        System.out.println("3-) List All Branches");
        System.out.println("4-)RETURN TO MAIN MENU PANEL");
    }




}

