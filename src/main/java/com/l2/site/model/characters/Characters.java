package com.l2.site.model.characters;

import com.l2.site.model.account.Accounts;
import com.l2.site.model.item.Items;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "obj_Id")
public class Characters {
  @Id
  private int obj_Id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_name")
  private Accounts accounts;

  @OneToMany(mappedBy = "characters", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Items> items;

  private String char_name;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte face;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte hairStyle;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte hairColor;
  @Column(columnDefinition = "BIT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private boolean sex;
  private Integer heading;
  private Integer x;
  private Integer y;
  private Integer z;
  private Integer karma;
  private Integer pvpkills;
  private Integer pkkills;
  private Integer clanid;
  private Integer createtime;
  private Integer deletetime;
  private String title;

  private byte accesslevel;

  private boolean online;
  private Integer onlinetime;
  private Integer lastAccess;
  private Integer leaveclan;
  private Integer deleteclan;
  private Integer nochannel;

  private short pledge_type;

  private byte pledge_rank;
  private byte lvl_joined_academy;
  private Integer apprentice;
  private Byte[] key_bindings;
  private Integer pcBangPoints;

  private Short vitality;
  private Integer fame;

  private byte bookmarks;

  private byte rec_have;

  private byte rec_left;

  private short rec_bonus_time;

  private short hunting_bonus_time;

  private short hunting_bonus;

  private byte rec_tick_cnt;
  private Integer last_teleport;


}
