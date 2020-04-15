package geo.springframework.geopetclinic2.services;

import geo.springframework.geopetclinic2.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
