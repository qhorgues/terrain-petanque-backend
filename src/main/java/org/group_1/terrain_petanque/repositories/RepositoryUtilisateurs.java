package org.group_1.terrain_petanque.repositories;

import org.group_1.terrain_petanque.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUtilisateurs
    extends JpaRepository<Utilisateur, Long> {}
