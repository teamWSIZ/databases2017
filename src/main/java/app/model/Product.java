package app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productid;
    Integer categoryid;
    Double price;
    String productname;
    Integer supplierid;
    String unit;
}
