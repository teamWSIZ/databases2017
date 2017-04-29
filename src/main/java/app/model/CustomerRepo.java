package app.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    List<Customer> findByCountry(String country);

    @Query("select c.customerid from Customer c")
    List<Integer> getCustomerIds();
}
