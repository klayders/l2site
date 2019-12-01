package com.l2.site.model.news;

import com.l2.site.model.parent.ManagedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class News extends ManagedEntity {

  private String title;
  private String description;

}
