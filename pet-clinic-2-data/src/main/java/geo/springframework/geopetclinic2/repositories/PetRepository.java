package geo.springframework.geopetclinic2.repositories;

import geo.springframework.geopetclinic2.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
