package guru.springframework.sfgpetclinic.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.map.PetServiceMap;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        petService = new PetServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner =new Owner();
            owner.setId(1L);
            owner.setFirstName("Ow_James");
            owner.setLastName("Selva");
        ownerService.save(owner);

        Owner owner2 =new Owner();
            owner2.setId(1L);
            owner2.setFirstName("James");
            owner2.setLastName("Selva");
        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet =new Vet();
            vet.setId(21L);
            vet.setFirstName("Sam");
            vet.setLastName("Axe");
        vetService.save(vet);

        Vet vet2 =new Vet();
            vet2.setId(22L);
            vet2.setFirstName("Jessie");
            vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Vets loaded");



    }
}
