package org.group_1.terrain_petanque.repositories;

import org.group_1.terrain_petanque.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTerrain extends JpaRepository<Terrain, Long> {}
