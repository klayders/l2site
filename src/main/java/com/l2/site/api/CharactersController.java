package com.l2.site.api;

import com.l2.site.character.CharactersService;
import com.l2.site.model.characters.Characters;
import com.l2.site.model.characters.CharactersSnapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.l2.site.utils.SiteUtils.API;

@RestController
@RequiredArgsConstructor
@RequestMapping(CharactersController.CHARACTER_MAPPING)
public class CharactersController {

  private static final String VERSION = "/v1";
  static final String CHARACTER_MAPPING = API + VERSION + "/character";

  private final CharactersService charactersService;

  @GetMapping
  public List<CharactersSnapshot> findAll() {
    return charactersService.findAll();
  }

  @GetMapping("/{id}")
  public CharactersSnapshot findById(@PathVariable Integer id) {
    return charactersService.getById(id);
  }

  @PostMapping
  public CharactersSnapshot create(@RequestParam String name) {
    Characters characters = new Characters();
    characters.setChar_name(name);
    return charactersService.save(characters);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    charactersService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
