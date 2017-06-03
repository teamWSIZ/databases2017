package app.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderdetail")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderdetailid;
    Integer orderid;
    Integer productid;
    Integer quantity;
}
