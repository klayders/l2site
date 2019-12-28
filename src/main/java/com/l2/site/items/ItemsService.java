package com.l2.site.items;

import com.l2.site.character.CharactersRepository;
import com.l2.site.model.characters.Characters;
import com.l2.site.model.item.Items;
import com.l2.site.model.item.ItemsSnapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemsService {

  private final ItemsRepository itemsRepository;
  private final CharactersRepository charactersRepository;

  public List<ItemsSnapshot> findAll() {
    return itemsRepository.findAll().stream()
      .map(ItemsSnapshot::of)
      .collect(Collectors.toList());
  }

  public ItemsSnapshot getById(int id) {
    return itemsRepository.findById(id)
      .map(ItemsSnapshot::of)
      .orElse(null);
  }


  public Items save(int characterId) {
    Characters characters = charactersRepository.getOne(characterId);
    Items item = new Items();
//    item.setCharacters(characters);
//    return itemsRepository.save(item);
    return item;
  }

  public void deleteById(int id) {
    itemsRepository.deleteById(id);
  }
}
