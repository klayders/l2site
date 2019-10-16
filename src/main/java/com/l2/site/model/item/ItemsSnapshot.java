package com.l2.site.model.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemsSnapshot {
  private int id;
  private int type;
  private long amount;
  private ItemLocation location;
  private int slot;
  private short enchant;

  public static ItemsSnapshot of(Items items) {
    return ItemsSnapshot.builder()
      .id(items.getItem_id())
      .type(items.getItem_type())
      .amount(items.getAmount())
      .location(items.getLocation())
      .slot(items.getSlot())
      .enchant(items.getEnchant())
      .build();
  }
}
