package guru.springframework.sfgpetclinic.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;


    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitySet=new HashSet<>();
        specialityRepository.findAll().iterator().forEachRemaining(specialitySet::add);
        return specialitySet;
    }

    @Override
    public Speciality findById(Long aLong) {
         Optional<Speciality> speciality=specialityRepository.findById(aLong);
            if(speciality.isPresent()){
                return speciality.get();
            }
         return null;
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
