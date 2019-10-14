package com.l2.site.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Accounts {
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

}
