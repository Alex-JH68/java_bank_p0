package Banking;

import java.util.ArrayList;

public class Bank {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    void newCustomer(Customer customer){
        customers.add(customer);
    }
    Customer getCustomer(int account){
        return customers.get(account);
    }
    ArrayList<Customer> getCustomers(){
        return customers;

    }


}
