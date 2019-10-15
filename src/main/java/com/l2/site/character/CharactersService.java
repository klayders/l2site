package com.l2.site.character;

import com.l2.site.model.characters.Characters;
import com.l2.site.model.characters.CharactersSnapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharactersService {

  private final CharactersRepository charactersRepository;

  public List<CharactersSnapshot> findAll() {
    return charactersRepository.findAll()
      .stream()
      .map(CharactersSnapshot::of)
      .collect(toList());
  }

  public CharactersSnapshot getById(Integer id) {
    return charactersRepository.findById(id)
      .map(CharactersSnapshot::of)
      .orElse(null);
  }

  @Transactional
  public CharactersSnapshot save(Characters characters) {
    return CharactersSnapshot.of(charactersRepository.save(characters));
  }

  @Transactional
  public void deleteById(Integer id) {
    charactersRepository.deleteById(id);
  }
}
