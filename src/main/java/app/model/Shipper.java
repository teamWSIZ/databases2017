package app.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "shippers")
@Data
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer shipperid;
    String shippername;
    String phone;
}
