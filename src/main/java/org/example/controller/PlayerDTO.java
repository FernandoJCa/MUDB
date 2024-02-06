package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
  private Integer id;
  private String name;
  private Integer age;
  private Integer jersey;
  private Integer height;
  private Integer weight;
  private String position;
  private Integer speed;
  private Integer goal;
  private Integer pass;

  public PlayerDTO(
      String name,
      Integer age,
      Integer jersey,
      Integer height,
      Integer weight,
      String position,
      Integer speed,
      Integer goal,
      Integer pass) {
    this.name = name;
    this.age = age;
    this.jersey = jersey;
    this.height = height;
    this.weight = weight;
    this.position = position;
    this.speed = speed;
    this.goal = goal;
    this.pass = pass;
  }
}
