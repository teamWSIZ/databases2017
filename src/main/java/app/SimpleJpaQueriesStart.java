package app;

import app.config.SmallConfig;
import app.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Random;


public class SimpleJpaQueriesStart {
    private static Random r = new Random();
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);
        CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
        EmployeeRepo employeeRepo = ctx.getBean(EmployeeRepo.class);
        ShipperRepo shipperRepo = ctx.getBean(ShipperRepo.class);
        PreorderRepo preorderRepo = ctx.getBean(PreorderRepo.class);

        for(Customer c : customerRepo.findByCountry("France")) {
            System.out.println(c);
        }

        List<Integer> eId = employeeRepo.getEmployeeIds();
        List<Integer> cId = customerRepo.getCustomerIds();
        List<Integer> sId = shipperRepo.getShipperIds();

        System.out.println(eId + " ### " + cId + " ### " + sId);

        for (int i = 0; i < 1000; i++) {
            Preorder created = new Preorder();
            created.setCustomerid(getRandomElement(cId));
            created.setEmployeeid(getRandomElement(eId));
            created.setShipperid(getRandomElement(sId));
            created.setOrderdate(new Date());
            preorderRepo.save(created);
            System.out.println(i);
        }
        ctx.close();
    }

    private static Integer getRandomElement(List<Integer> e) {
        return e.get(r.nextInt(e.size()));
    }

}
