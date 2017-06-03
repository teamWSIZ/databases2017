package app.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    @Query("select e.employeeid from Employee e")
    List<Integer> getEmployeeIds();
}
