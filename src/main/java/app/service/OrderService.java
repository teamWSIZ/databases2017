package app.service;

import app.model.OrderDetail;
import app.model.OrderDetailRepo;
import app.model.Preorder;
import app.model.PreorderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Component
public class OrderService {
    @Autowired
    PreorderRepo orderRepo;
    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Transactional
    void createNewOrder(Integer customerId, Integer employeeId, Integer shipperId,
                        Integer productId, Integer quantity) {
        Preorder order = new Preorder();
        order.setCustomerid(customerId);
        order.setEmployeeid(employeeId);
        order.setOrderdate(new Date());
        order.setShipperid(shipperId);

        OrderDetail detail = new OrderDetail();
        detail.setQuantity(quantity);
        detail.setProductid(productId);

        orderRepo.save(order);
        detail.setOrderid(order.getOrderid());
        orderDetailRepo.save(detail);

    }

}
