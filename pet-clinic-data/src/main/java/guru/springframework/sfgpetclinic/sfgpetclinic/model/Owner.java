package guru.springframework.sfgpetclinic.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> petSet=new HashSet<>();

    @Builder  /*Generate the builder for Owner.*/
    public Owner(Long id,String firstName,String lastName,String address, String city, String telephone, Set<Pet> petSet) {
        super(id,firstName,lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.petSet = petSet;
    }
}
