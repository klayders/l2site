package com.l2.site.model.item;

import com.l2.site.model.characters.Characters;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "item_id")
public class Items {
  @Id
//  @GeneratedValue
  private int item_id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "owner_id")
  private Characters characters;

  private int item_type;
  private long amount;
  @Enumerated(EnumType.STRING)
  @Column(
    columnDefinition = "ENUM('VOID', 'INVENTORY', 'PAPERDOLL', 'WAREHOUSE', 'FREIGHT', 'CLANWH', 'MAIL', 'PET_INVENTORY', 'PET_PAPERDOLL')",
    nullable = false
  )
  private ItemLocation location;
  private int slot;
  private short enchant;
}
