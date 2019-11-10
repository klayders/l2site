package com.l2.site.character;

import com.l2.site.model.characters.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharactersRepository extends JpaRepository<Characters, Integer> {
  @Query("SELECT COUNT(c) FROM Characters c WHERE c.online=true")
  Long countOnlineCharacters();

//  @Query("SELECT c FROM Characters c order by c.pvpkills")
//  List<Characters> topPvP();
}
