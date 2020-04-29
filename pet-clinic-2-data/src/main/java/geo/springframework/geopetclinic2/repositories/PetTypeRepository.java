package geo.springframework.geopetclinic2.repositories;

import geo.springframework.geopetclinic2.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
