package app.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "userdetail")
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userdetailid;
    Integer userid;
    String pesel;
    String comment;
}
