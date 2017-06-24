package app.service;

import app.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class EntityValidator {

    public boolean isCustomerValid(Customer c) {
        if (isEmptyString(c.getContactname())) return false;
        if (isEmptyString(c.getAddress())) return false;
        return true;
    }

    private boolean isEmptyString(String s) {
        return (s == null || s.trim().length() == 0);
    }
}
