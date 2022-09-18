package CargoSystem;

public class TransportEmployee  implements   WriteMenu {

// tesl,im edildiğinde kurye sistem üzerinde status bilgisainin güncellemesini gerçeleştiricek.


    private int transportEmployeeID;
    private String transportEmployeeName;
    @Override
    public void WriteMenu() {
            System.out.println("1-)Cargo is to sumbit.");
            System.out.println("2-) Back to Main Menu");
        }

    public TransportEmployee(int transportEmployeeID, String transportEmployeeName){
        this.transportEmployeeID = transportEmployeeID;
        this.transportEmployeeName = transportEmployeeName;
    }

    public String getTransportEmployeeName() {
        return transportEmployeeName;
    }

    public void setTransportEmployeeName(String TransportEmpName) {
        this.transportEmployeeName = TransportEmpName;
    }

    public Integer getTransportEmployeeID() {
        return transportEmployeeID;
    }
    }

