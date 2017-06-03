package app.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

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
    Date birthdate;
    String photo;
    String notes;
}
