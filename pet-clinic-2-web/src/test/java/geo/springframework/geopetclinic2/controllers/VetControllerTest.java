package geo.springframework.geopetclinic2.controllers;

import geo.springframework.geopetclinic2.model.Vet;
import geo.springframework.geopetclinic2.services.VetService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    VetService vetService;

    @InjectMocks
    VetController vetController;

    MockMvc mockMvc;

    Set<Vet> vetSet;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(vetController).build();
        vetSet = new HashSet<>();
        vetSet.add(Vet.builder().build());
        vetSet.add(Vet.builder().build());
    }

    @Test
    void listVets() throws Exception {
        when(vetService.findAll()).thenReturn(vetSet);

        mockMvc.perform(get("/vets"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", hasSize(2)));
    }

}