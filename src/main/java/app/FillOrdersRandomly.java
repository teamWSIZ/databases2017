package app;

import app.config.SmallConfig;
import app.model.*;
import ch.qos.logback.core.db.dialect.OracleDialect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FillOrdersRandomly {
    private static Random r = new Random();
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);
        CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
        EmployeeRepo employeeRepo = ctx.getBean(EmployeeRepo.class);
        ShipperRepo shipperRepo = ctx.getBean(ShipperRepo.class);
        PreorderRepo preorderRepo = ctx.getBean(PreorderRepo.class);
        OrderDetailRepo detailRepo = ctx.getBean(OrderDetailRepo.class);
        ProductRepo productRepo = ctx.getBean(ProductRepo.class);


        List<Integer> eId = employeeRepo.getEmployeeIds();
        List<Integer> cId = customerRepo.getCustomerIds();
        List<Integer> sId = shipperRepo.getShipperIds();
        List<Integer> pId = productRepo.getProductIds();

        for (int i = 0; i < 1000; i++) {
            Preorder order = new Preorder();
            order.setCustomerid(getRandomElement(cId));
            order.setEmployeeid(getRandomElement(eId));
            order.setShipperid(getRandomElement(sId));
            order.setOrderdate(randomDate());
            preorderRepo.save(order);

            //utworzyć instancję OrderDetail
            OrderDetail detail = new OrderDetail();
            detail.setOrderid(order.getOrderid());
            detail.setProductid(getRandomElement(pId));
            detail.setQuantity(r.nextInt(100)+1);
            detailRepo.save(detail);

            System.out.println("------------------");
            System.out.println("stworzone zamówienie:" + order + " --> " + detail);
        }

        ctx.close();
    }

    private static Integer getRandomElement(List<Integer> e) {
        return e.get(r.nextInt(e.size()));
    }

    private static Date randomDate() {
        Date a = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(a);
        int days = r.nextInt(3650);
        calendar.add(Calendar.DATE, -days);
        return calendar.getTime();
    }

}
