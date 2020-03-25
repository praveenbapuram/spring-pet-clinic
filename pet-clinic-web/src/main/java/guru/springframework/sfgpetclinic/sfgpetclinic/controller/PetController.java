package guru.springframework.sfgpetclinic.sfgpetclinic.controller;

import guru.springframework.sfgpetclinic.sfgpetclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {

    @RequestMapping({"pets","pets/index","pets/index.html"})
   public String listPets(){
       return "pets/index";
   }



}
