package org.group_1.terrain_petanque.services;

import jakarta.transaction.Transactional;
import org.group_1.terrain_petanque.entity.Coordonnees;
import org.group_1.terrain_petanque.repositories.RepositoryCoordonnees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceCoordonnees {
    @Autowired
    private RepositoryCoordonnees repositoryCoordonnees;

    public Coordonnees createCoordonnees(Coordonnees coordonnees) {
        return repositoryCoordonnees.save(coordonnees);
    }

    public Coordonnees updateCoordonnees(Coordonnees coordonnees) {
        return repositoryCoordonnees.save(coordonnees);
    }

    public void deleteCoordonnees(Coordonnees coordonnees) {
        repositoryCoordonnees.delete(coordonnees);
    }
    /*
    public Coordonnees selectUniqueCoordonnees(Coordonnees coordonnees) {
        return repositoryCoordonnees.findOne(coordonnees);
    }

    public Coordonnees selectMultipleCoordonnees(Coordonnees coordonnees) {
        return repositoryCoordonnees.findAll();
    }
    */
}
