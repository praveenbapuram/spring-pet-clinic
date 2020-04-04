package guru.springframework.sfgpetclinic.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSet=new HashSet<>();
        petTypeRepository.findAll().iterator().forEachRemaining(petTypeSet:: add);
        return petTypeSet;
    }

    @Override
    public PetType findById(Long aLong) {
        Optional<PetType> petType=petTypeRepository.findById(aLong);
        if(petType.isPresent()){
            return petType.get();
        }
        return null;
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
