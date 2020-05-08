package geo.springframework.geopetclinic2.services.map;

import geo.springframework.geopetclinic2.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    String lastName = "John";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet =  ownerServiceMap.findAll();
        Assertions.assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        Assertions.assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {

        Long id2 = 2L;
        Owner owner2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerServiceMap.save((owner2));
        Assertions.assertEquals(id2, savedOwner.getId());

    }

    @Test
    void saveNoId(){
        Owner savedOwner = ownerServiceMap.save((Owner.builder().id(ownerId).build()));
        Assertions.assertNotNull(savedOwner);
        Assertions.assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        Assertions.assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        Assertions.assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner john = ownerServiceMap.findByLastName(lastName);
        Assertions.assertNotNull(john);
        Assertions.assertEquals(ownerId, john.getId());
    }

    @Test
    void findByLastNameNotFound(){
        Owner john = ownerServiceMap.findByLastName("Dan");
        Assertions.assertNull(john);
    }
}