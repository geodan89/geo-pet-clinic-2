package geo.springframework.geopetclinic2.services;

import geo.springframework.geopetclinic2.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
