package app.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer employeeid;
    String lastname;
    String firstname;
    @Type(type = "date")
    String birthdate;
    String photo;
    String notes;
}
