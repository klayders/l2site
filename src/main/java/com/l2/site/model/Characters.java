package com.l2.site.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Characters {
  @Id
  private int obj_Id;

  private String account_name;
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
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte accesslevel;
  @Column(columnDefinition = "BIT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private boolean online;
  private Integer onlinetime;
  private Integer lastAccess;
  private Integer leaveclan;
  private Integer deleteclan;
  private Integer nochannel;
  @Column(columnDefinition = "SMALLINT")
  @Type(type = "org.hibernate.type.ShortType")
  private short pledge_type;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte pledge_rank;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte lvl_joined_academy;
  private Integer apprentice;
  private Byte[] key_bindings;
  private Integer pcBangPoints;
  @Column(columnDefinition = "SMALLINT")
  @Type(type = "org.hibernate.type.ShortType")
  private Short vitality;
  private Integer fame;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte bookmarks;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte rec_have;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte rec_left;
  @Column(columnDefinition = "SMALLINT")
  @Type(type = "org.hibernate.type.ShortType")
  private short rec_bonus_time;
  @Column(columnDefinition = "SMALLINT")
  @Type(type = "org.hibernate.type.ShortType")
  private short hunting_bonus_time;
  @Column(columnDefinition = "SMALLINT")
  @Type(type = "org.hibernate.type.ShortType")
  private short hunting_bonus;
  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.ByteType")
  private byte rec_tick_cnt;
  private Integer last_teleport;


}
