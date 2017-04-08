package app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "breaks")
@Data
public class Break {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer breakid;
    String breakname;
}
