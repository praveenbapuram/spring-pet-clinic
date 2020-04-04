package guru.springframework.sfgpetclinic.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private  final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets=new HashSet<>();
        vetRepository.findAll().iterator().forEachRemaining(vets:: add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> vet=vetRepository.findById(aLong);
        if(vet.isPresent()){
            return vet.get();
        }else{
            return null;
        }
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object) ;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
