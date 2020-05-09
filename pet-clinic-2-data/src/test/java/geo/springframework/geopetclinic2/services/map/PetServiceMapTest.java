package geo.springframework.geopetclinic2.services.map;

import geo.springframework.geopetclinic2.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class PetServiceMapTest {

    PetServiceMap petServiceMap;
    Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();
        Assertions.assertEquals(1, pets.size());
    }

    @Test
    void deleteByCorrectId() {
        petServiceMap.deleteById(petId);
        Assertions.assertEquals(0, petServiceMap.findAll().size() );
    }

    @Test
    void deleteByWrongId(){
        petServiceMap.deleteById(5L);
        Assertions.assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void deleteByNullId(){
        petServiceMap.delete(null);
        Assertions.assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void deleteExistingPet() {
        petServiceMap.delete(petServiceMap.findById(petId));
        Assertions.assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deletePetWithNullId(){
        Pet pet = Pet.builder().build();
        petServiceMap.delete(pet);
        Assertions.assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void deletePetWithWrongId(){
        Pet pet = Pet.builder().id(3L).build();
        petServiceMap.delete(pet);
        Assertions.assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void savePetThatAlreadyHasAnId() {
        Long id = 6L;
        Pet pet = Pet.builder().id(id).build();
        Pet savedPet = petServiceMap.save(pet);
        Assertions.assertEquals(id, savedPet.getId());
    }

    @Test
    void savePetWithDuplicateId(){
        Long id = 1L;
        Pet pet = Pet.builder().id(id).build();
        Pet savedPet = petServiceMap.save(pet);
        Assertions.assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void savePetThatHasNoId(){
        Pet pet = Pet.builder().build();
        Pet savedPet = petServiceMap.save(pet);
        Assertions.assertNotNull(savedPet);
        Assertions.assertNotNull(savedPet.getId());
        Assertions.assertEquals(2, petServiceMap.findAll().size());
    }

    @Test
    void findByExistingId() {
        Pet pet = petServiceMap.findById(petId);
        Assertions.assertEquals(petId, pet.getId());
    }

    @Test
    void findByNullId(){
        Pet pet = petServiceMap.findById(null);
        Assertions.assertNull(pet);
    }

    @Test
    void findByIdNoExistingId(){
        Pet pet = petServiceMap.findById(7L);
        Assertions.assertNull(pet);
    }
}