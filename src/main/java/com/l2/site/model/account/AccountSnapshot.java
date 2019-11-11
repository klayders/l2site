package com.l2.site.model.account;

import com.l2.site.model.characters.CharactersSnapshot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountSnapshot {
  private String login;
  private Integer lastActive;
  private Byte accessLevel;
  private Integer lastServerId;
  private int banExpire;
  private String l2email;
  private String privateKey;

  private List<CharactersSnapshot> characters;

  public static AccountSnapshot withCharacters(Account accounts) {
    var charactersSnapshots = getCharactersSnapshots(accounts);
    var accountSnapshot = of(accounts);
    accountSnapshot.setCharacters(charactersSnapshots);
    return accountSnapshot;
  }

  public static AccountSnapshot of(Account accounts) {
    return AccountSnapshot.builder()
      .login(accounts.getLogin())
      .lastActive(accounts.getLastactive())
      .accessLevel(accounts.getAccessLevel())
      .lastServerId(accounts.getLastServerId())
      .banExpire(accounts.getBan_expire())
      .l2email(accounts.getL2email())
      .build();
  }

  private static List<CharactersSnapshot> getCharactersSnapshots(Account accounts) {
    if (accounts.getCharacters() != null) {
      return accounts.getCharacters().stream()
        .map(CharactersSnapshot::of)
        .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

}
