package io.arrogantprogrammer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Inject
    CustomerRepository customerRepository;

    @Inject
    NotificationService notificationService;

    public List<CustomerRecord> allCustomer() {

        return customerRepository.listAll().stream().map(customer -> {
            return new CustomerRecord(customer.id, customer.email, customer.firstName, customer.lastName);
        }).collect(Collectors.toList());
    }

    public CustomerRecord create(CustomerRecord customerRecord) {

        Customer customer = Customer.createCustomer(customerRecord.email(), customerRecord.firstName(), customerRecord.lastName());
        customerRepository.persist(customer);

        notificationService.customerCreated();
        return new CustomerRecord(customer.id, customer.email, customer.firstName, customer.lastName);
    }
}
