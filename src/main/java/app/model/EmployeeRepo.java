package app.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    @Query("select e.employeeid from Employee e")
    List<Integer> getEmployeeIds();


//    Odpowiednik SQL'a:
//    SELECT count(*)
//    FROM orders o, orderdetail od
//    WHERE od.orderid = o.orderid AND
//    o.employeeid = 5 AND
//    od.productid = 10;
    @Query("SELECT count(o)" +
            "FROM Preorder o, OrderDetail od " +
            "WHERE od.orderid = o.orderid AND" +
            "      o.employeeid = :employeeid AND od.productid = :productid")
    Integer countOfOrdersByProduct(@Param("employeeid") Integer employeeid,
                                   @Param("productid") Integer productid);
}
