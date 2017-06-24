package app.controller;


import app.model.Customer;
import app.model.CustomerRepo;
import app.model.Employee;
import app.model.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String help() {
        return "OK";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Iterable<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Iterable<Employee> getEmployees() {
        return employeeRepo.findAll();
    }


    @RequestMapping(value = "/employees/{eid}", method = RequestMethod.GET)
    public Employee getEmployees(@PathVariable(value = "eid") Integer eid) {
        return employeeRepo.findOne(eid);
    }


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


}
