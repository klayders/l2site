package com.l2.site.model.characters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharactersSnapshot {
  private int id;
  private String charName;
  private String title;
  private int pvpKills;
  private int pkKills;

  private boolean sex;
  private boolean online;

  private int onlineTime;
  private int createTime;
  private int lastAccess;


  public static CharactersSnapshot of(Characters characters) {
    return CharactersSnapshot.builder()
      .id(characters.getObj_Id())
      .charName(characters.getChar_name())
      .title(characters.getTitle())
      .pvpKills(characters.getPvpkills())
      .pkKills(characters.getPkkills())
      .online(characters.isOnline())
      .sex(characters.isSex())
      .onlineTime(characters.getOnlinetime())
      .createTime(characters.getCreatetime())
      .lastAccess(characters.getLastAccess())
      .build();

  }

}
