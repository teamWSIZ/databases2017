package app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerid;
    String customername;
    String contactname;
    String address;
    String city;
    String postalcode;
    String country;
}
