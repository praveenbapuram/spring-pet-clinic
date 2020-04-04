package guru.springframework.sfgpetclinic.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String name) {
        return ownerRepository.findByLastName(name);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet =new HashSet<>();
        ownerRepository.findAll().iterator().forEachRemaining(ownerSet :: add);
        return ownerSet;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> result=ownerRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long ownerId) {
            ownerRepository.deleteById(ownerId);
    }
}
