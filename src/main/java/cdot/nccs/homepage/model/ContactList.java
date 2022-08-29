package cdot.nccs.homepage.model;
import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.*;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactList {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String division;
    String designation;
    String name;
    String telephone;
    @Email
    String email;
}
