package guru.springframework.sfgpetclinic.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialitiesService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size()==0){
            loadData();
        }
   }


    private void loadData(){
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogType= petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Dog");
        PetType savedCatType= petTypeService.save(cat);

        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery=new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgeon = specialitiesService.save(surgery);

        Speciality dentistry=new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentist= specialitiesService.save(dentistry);


        Owner owner =new Owner();
        owner.setFirstName("Ow_James");
        owner.setLastName("Selva");
        owner.setAddress("123 Street 1");
        owner.setCity("LosVegas");
        owner.setTelephone("12321321");

        Pet ownerPet=new Pet();
        ownerPet.setPetType(savedDogType);
        ownerPet.setOwner(owner);
        ownerPet.setName("Puppy");
        ownerPet.setBirthDate(LocalDate.now());

        owner.getPetSet().add(ownerPet);
        ownerService.save(owner);

        Owner owner2 =new Owner();
        owner2.setFirstName("James");
        owner2.setLastName("Selva");
        owner2.setAddress("123 Street 2");
        owner2.setCity("Newyork");
        owner2.setTelephone("453423423");

        Pet owner2Cat=new Pet();
        owner2Cat.setPetType(savedCatType);
        owner2Cat.setOwner(owner2);
        owner2Cat.setName("fluffy");
        owner2Cat.setBirthDate(LocalDate.now());
        owner2.getPetSet().add(owner2Cat);

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet =new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vet.getSpecialities().add(savedRadiology);
        vetService.save(vet);

        Vet vet2 =new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgeon);
        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
