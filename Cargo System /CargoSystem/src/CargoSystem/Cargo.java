package CargoSystem;

public class Cargo {

    private String cargoId;
    private String cargoCustomerName;
    private String cargoSender;
    private String cargoReciever;
    private String  cargoStatus;
    private String cargoTarget;


    public Cargo() {
    }
    public Cargo(String cargoSender, String cargoReciever) {
        this.cargoSender = cargoSender;
        this.cargoReciever = cargoReciever;
    }


    public String getCargoCustomerName() {
        return cargoCustomerName;
    }

    public void setCargoCustomerName(String cargoCustomerName) {
        this.cargoCustomerName = cargoCustomerName;
    }

    public String getCargoId() {
        return cargoId;
    }

    public void setCargoId(String cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoSender() {
        return cargoSender;
    }

    public void setCargoSender(String cargoSender) {
        this.cargoSender = cargoSender;
    }

    public String getCargoReciever() {
        return cargoReciever;
    }

    public void setCargoReciever(String cargoReciever) {
        this.cargoReciever = cargoReciever;
    }

    public String getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(String cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    public String getCargoTarget() {
        return cargoTarget;
    }

    public void setCargoTarget(String cargoTarget) {
        this.cargoTarget = cargoTarget;
    }
}
