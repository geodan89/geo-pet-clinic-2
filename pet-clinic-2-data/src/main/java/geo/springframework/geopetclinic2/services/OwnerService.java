package geo.springframework.geopetclinic2.services;

import geo.springframework.geopetclinic2.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
