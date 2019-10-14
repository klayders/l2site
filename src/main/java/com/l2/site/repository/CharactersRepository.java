package com.l2.site.repository;

import com.l2.site.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharactersRepository extends JpaRepository<Characters, Integer> {
}
