package app.controller;


import app.model.Customer;
import app.model.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class MainController {
    @Autowired
    CustomerRepo customerRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String help() {
        return "OK";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Iterable<Customer> getCustomers() {
        return customerRepo.findAll();
    }


}
