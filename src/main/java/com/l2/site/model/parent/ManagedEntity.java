package com.l2.site.model.parent;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@EqualsAndHashCode(of = {"id"})
public abstract class ManagedEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private boolean published;
  private Date creationDate;
  private Date editDate;
  private Long createdBy;

}
