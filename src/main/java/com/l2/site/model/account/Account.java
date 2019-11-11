package com.l2.site.model.account;

import com.l2.site.model.characters.Characters;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "login")
@Table(name = "accounts")
public class Account {
  @Id
  private String login;
  private String password;
  private Integer lastactive;
  private Byte accessLevel;
  private String lastIP;
  private Integer lastServerId;
  private int ban_expire;
  private String allow_ip;
  private String l2email;
  private String privatekey;

  @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Characters> characters;
}
