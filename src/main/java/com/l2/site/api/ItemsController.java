package com.l2.site.api;

import com.l2.site.items.ItemsService;
import com.l2.site.model.item.Items;
import com.l2.site.model.item.ItemsSnapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.l2.site.utils.SiteUtils.API;

@RestController
@RequiredArgsConstructor
@RequestMapping(ItemsController.ITEMS_MAPPING)
public class ItemsController {

  private static final String VERSION = "/v1";
  static final String ITEMS_MAPPING = API + VERSION + "/items";

  private final ItemsService itemsService;

  @GetMapping
  public List<ItemsSnapshot> findAll() {
    return itemsService.findAll();
  }

  @GetMapping("/{id}")
  public ItemsSnapshot findById(@PathVariable Integer id) {
    return itemsService.getById(id);
  }

  @PostMapping
  public Items create(@RequestParam int characterId) {
    return itemsService.save(characterId);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    itemsService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
