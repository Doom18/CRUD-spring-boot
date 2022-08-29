package cdot.nccs.homepage.dto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactListDto {
    private Long id;
    String division;
    String designation;
    String name;
    String telephone;
    @Email
    String email;
}

