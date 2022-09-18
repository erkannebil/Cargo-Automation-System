package CargoSystem;

public class BranchEmployee {

    private int EmployeeID;
    private String EmployeeName;




    public BranchEmployee(int EmployeeID, String EmployeeName) {
       this.EmployeeID = EmployeeID;
       this.EmployeeName = EmployeeName;
    }


    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmpName) {
        this.EmployeeName = EmpName;
    }

    public Integer getEmployeeID() {
        return EmployeeID;
    }




}
