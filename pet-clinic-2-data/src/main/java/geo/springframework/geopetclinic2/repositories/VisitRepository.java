package geo.springframework.geopetclinic2.repositories;

import geo.springframework.geopetclinic2.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
