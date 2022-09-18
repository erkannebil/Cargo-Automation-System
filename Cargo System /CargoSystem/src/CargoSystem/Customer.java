package CargoSystem;

import java.security.PrivateKey;

public class Customer implements WriteMenu {
    private String customerName;
    private String customerSurname;

    public Customer() {

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    @Override
    public void WriteMenu() {
        System.out.println("1-)Query the  sender and receiver information of my argo.");
        System.out.println("2-) Back to Main Menu");
    }
}
