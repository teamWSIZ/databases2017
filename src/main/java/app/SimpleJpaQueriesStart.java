package app;

import app.config.SmallConfig;
import app.model.*;
import app.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Prosta aplikacja startująca kontekst z dostępem do repozytorów bazodanowych.
 */

public class SimpleJpaQueriesStart {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);
        CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
        EmployeeRepo employeeRepo = ctx.getBean(EmployeeRepo.class);
        ShipperRepo shipperRepo = ctx.getBean(ShipperRepo.class);
        PreorderRepo preorderRepo = ctx.getBean(PreorderRepo.class);
        OrderService orderService = ctx.getBean(OrderService.class);

//        for(Customer c : customerRepo.findByCountry("France")) {
//            System.out.println(c);
//        }
//
//        System.out.println("------------------------------");
//        for (Customer c : customerRepo.findByCustomernameContaining("ies")) {
//            System.out.println(c);
//        }
//
//        System.out.println("-------------------------------");
//        List<Integer> employeeIds = new ArrayList<>();
//        for(Employee e : employeeRepo.findAll()) {
//            employeeIds.add(e.getEmployeeid());
//        }
//        System.out.println(employeeIds);

//        System.out.println(employeeRepo.countOfOrdersByProduct(5, 10));

        orderService.createNewOrder(1, 1, 1, 1, 1);

        ctx.close();
    }


}
