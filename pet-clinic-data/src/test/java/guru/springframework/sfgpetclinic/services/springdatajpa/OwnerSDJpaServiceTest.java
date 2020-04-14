package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final Long ownerId=10L;
    final Long ownerId2=2L;
    final String john="John";
    Owner owner;
    Owner owner2;

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        owner=new Owner(ownerId,"String firstName",john,"String address", "String city", "String telephone", null);
        owner2=new Owner(ownerId2,"String firstName2",john,"String address2", "String city2", "String telephone2", null);
        service =new OwnerSDJpaService(ownerRepository,petRepository,petTypeRepository);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);
        assertEquals(john,service.findByLastName("John").getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=new HashSet<>();
        ownerSet.add(owner);
        ownerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        assertEquals(2,service.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        assertEquals(owner.getId(),service.findById(10L));

    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertEquals(null,service.findById(9L));
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        assertNotNull(service.save(new Owner()));
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository).delete(any()); /*used to verify invocation of delete method of ownerRepository*/
    }

    @Test
    void deleteById() {
        service.deleteById(10L);
        verify(ownerRepository).deleteById(anyLong());
    }
}