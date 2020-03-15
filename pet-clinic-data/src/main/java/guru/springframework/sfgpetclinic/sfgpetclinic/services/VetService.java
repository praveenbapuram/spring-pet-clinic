package guru.springframework.sfgpetclinic.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
