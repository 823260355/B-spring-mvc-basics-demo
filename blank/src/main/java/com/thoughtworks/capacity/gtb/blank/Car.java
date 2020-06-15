package com.thoughtworks.capacity.gtb.blank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

  private Integer id;
  private String type;
  private String color;
}

