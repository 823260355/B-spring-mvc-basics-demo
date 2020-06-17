package com.thoughtworks.capacity.gtb.blank;

public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }
}
