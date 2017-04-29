package app.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Preorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderid;
    Integer customerid;
    Integer employeeid;
    @Type(type = "date")
    Date orderdate;
    Integer shipperid;
}
