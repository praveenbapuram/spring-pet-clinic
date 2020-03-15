package guru.springframework.sfgpetclinic.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerService  {
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
