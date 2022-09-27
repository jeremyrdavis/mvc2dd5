package io.arrogantprogrammer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class);

    @Inject
    CustomerService customerService;

    @GET
    public List<CustomerRecord> allCustomers() {

        return customerService.allCustomer();
    }

    @POST
    @Transactional
    public CustomerRecord addCustomer(CustomerRecord customerRecord) {

        CustomerRecord result = customerService.create(customerRecord);
        return result;
    }
}
