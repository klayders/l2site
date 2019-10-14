package com.l2.site.controller;

import com.l2.site.model.Characters;
import com.l2.site.repository.CharactersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharactersController {

  private final CharactersRepository charactersRepository;

  @GetMapping("/all")
  public List<Characters> findAll() {
    return charactersRepository.findAll();
  }

  @GetMapping("/")
  public Characters findById(@RequestParam Integer id) {
    return charactersRepository.getOne(id);
  }
}
