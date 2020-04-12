package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaServcie implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaServcie(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet =new HashSet<>();
        visitRepository.findAll().iterator().forEachRemaining(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit findById(Long aLong) {
        Optional<Visit> visit=visitRepository.findById(aLong);
        if(visit.isPresent()){
            return visit.get();
        }
        return null;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
