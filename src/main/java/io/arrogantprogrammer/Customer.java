package io.arrogantprogrammer;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Customer extends PanacheEntity {

    String email;

    String firstName;

    String lastName;

    CustomerLoyaltyStatus customerLoyaltyStatus;

    protected Customer() {
    }

    protected static Customer createCustomer(String email, String firstName, String lastName) {

        Customer customer = new Customer();
        customer.email = email;
        customer.firstName = firstName;
        customer.lastName = lastName;

        if(customer.getFirstName().equals("Jeremy")){
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.VIP;
        }else if(customer.getFirstName().equals("Robert")){
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.NOT_THIS_GUY_AGAIN;
        }

        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerLoyaltyStatus=" + customerLoyaltyStatus +
                ", id=" + id +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerLoyaltyStatus getCustomerLoyaltyStatus() {
        return customerLoyaltyStatus;
    }
}
