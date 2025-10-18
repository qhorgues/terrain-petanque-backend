package org.group_1.terrain_petanque.repositories;

import org.group_1.terrain_petanque.entity.Coordonnees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCoordonnees extends JpaRepository<Coordonnees, Long> {
}
