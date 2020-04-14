package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> ownerSet=new HashSet<>();

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
       Owner  owner=new Owner(1L,"String firstName","john","String address", "String city", "String telephone", null);
       Owner owner2=new Owner(2L,"String firstName2","feder","String address2", "String city2", "String telephone2", null);
       ownerSet.add(owner);
       ownerSet.add(owner2);

       mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwner() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                    .andExpect(view().name("owners/index"))
                        .andExpect(model().attribute("owners",hasSize(2)));
    }

    @Test
    void findOwner() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                    .andExpect(view().name("notImplemented"));

    }
}