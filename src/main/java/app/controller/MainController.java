package app.controller;


import app.model.Customer;
import app.model.CustomerRepo;
import app.model.Employee;
import app.model.EmployeeRepo;
import app.service.AlphaService;
import app.service.EntityValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Na bazach (repozytoria) mamy CRUD, czyli
 * Create
 * Read
 * Update
 * Delete
 *
 * Odpowiadać temu mają metody HTTP:
 * C) RequestMethod.POST
 * R) RequestMethod.GET
 * U) RequestMethod.PUT
 * D) RequestMethod.DELETE
 *
 * ...
 */


@Slf4j
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    AlphaService alphaService; //referencje do instancji tej klasy przekaże automatycznie spring
    @Autowired
    EntityValidator entityValidator;

    @RequestMapping(value = "/status")
    public String getStatus() {
        return "DB service running OK";
    }

    // Customers

    //Wszyscy klienci
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Iterable<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @RequestMapping(value = "/customers/{customerid}", method = RequestMethod.GET)
    public Customer getSingleCustomer(
            @PathVariable(value = "customerid") Integer customerid
    ) {
        return customerRepo.findOne(customerid);
    }

    //Create customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer) {
        log.info("Attempt to create a new customer: [{}]", customer);
        if (!entityValidator.isCustomerValid(customer)) {
            throw new RuntimeException("Customer data not valid");
        }
        return customerRepo.save(customer);
    }

    //Update customer
    @RequestMapping(value = "/customers/{customerid}", method = RequestMethod.PUT)
    @ResponseBody
    public Customer updateCustomer(
            @PathVariable(value = "customerid") Integer customerid,
            @RequestBody Customer customer) {
        log.info("Attempt to update customer: [{}], with customerid: [{}]", customer, customerid);
        if (!customerid.equals(customer.getCustomerid())) {
            throw new RuntimeException("Customerid's don't match");
        }
        if (customerRepo.findOne(customerid)==null) {
            throw new RuntimeException("No customer with given customerid in the DB");
        }
        if (!entityValidator.isCustomerValid(customer)) {
            throw new RuntimeException("Customer data not valid");
        }
        return customerRepo.save(customer);
    }


    // Employees

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Iterable<Employee> getEmployees() {
        return employeeRepo.findAll();
    }


    @RequestMapping(value = "/employees/{eid}", method = RequestMethod.GET)
    public Employee getEmployees(@PathVariable(value = "eid") Integer eid) {
        return employeeRepo.findOne(eid);
    }




}
