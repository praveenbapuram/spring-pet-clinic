package guru.springframework.sfgpetclinic.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="visit")
public class Visit extends BaseEntity {

    @Column(name="date")
    private LocalDate localDate;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "description")
    private String description;

}
