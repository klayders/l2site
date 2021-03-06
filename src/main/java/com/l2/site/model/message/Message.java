package com.l2.site.model.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.l2.site.model.Views;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@EqualsAndHashCode
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonView(Views.Id.class)
  private Long id;

  @JsonView(Views.IdName.class)
  private String text;

  @Column(updatable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonView(Views.FullMessage.class)
  private LocalDateTime creationDate;

  @JsonView(Views.FullMessage.class)
  private String link;
  @JsonView(Views.FullMessage.class)
  private String linkTitile;
  @JsonView(Views.FullMessage.class)
  private String linkDescription;
  @JsonView(Views.FullMessage.class)
  private String linkCover;

}
