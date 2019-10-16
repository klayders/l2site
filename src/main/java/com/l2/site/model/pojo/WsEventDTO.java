package com.l2.site.model.pojo;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.l2.site.model.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Views.Id.class)
public class WsEventDTO {
  private ObjectType objectType;
  private EventType eventType;

  @JsonRawValue
  private String body;
}
