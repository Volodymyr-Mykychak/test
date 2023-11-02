package mate.academy.webintro.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @ToString.Exclude
    @Column(name = "social_security_number", unique = true)
    private String socialSecurityNumber;
}
