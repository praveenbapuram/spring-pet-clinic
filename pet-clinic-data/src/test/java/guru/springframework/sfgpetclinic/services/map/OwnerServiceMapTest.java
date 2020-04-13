package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId=10L;
    final String john="John";

    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetTypeMapService(),new PetServiceMap());
        Owner owner=new Owner(ownerId,"String firstName",john,"String address", "String city", "String telephone", null);
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
       Set<Owner> owners=ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void findById() {
        assertEquals(ownerId,ownerServiceMap.findById(ownerId).getId());
    }

    @Test
    void saveExistingID() {
        Long id=2L;
        Owner owner2= new Owner(id,"String firstName",john,"String address", "String city", "String telephone", null);
        Owner saveOwner=ownerServiceMap.save(owner2);
        assertEquals(id,saveOwner.getId());
    }

    @Test
    void saveNoId() {

        Owner owner3= Owner.builder().build();
        Owner saveOwner=ownerServiceMap.save(owner3);
       assertNotNull(saveOwner.getId());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Set<Owner>  owners= ownerServiceMap.findAll();
        Owner owner=ownerServiceMap.findByLastName(john);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner=ownerServiceMap.findByLastName("smith");
        assertNull(owner);
    }
}