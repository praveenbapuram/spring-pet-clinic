package guru.springframework.sfgpetclinic.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

   Owner  findByLastName(String name);
}
