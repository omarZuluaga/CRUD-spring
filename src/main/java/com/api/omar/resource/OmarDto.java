package com.api.omar.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OmarDto {
  private String id;
  private String name;
  private String mail;
  private Long document;
}
