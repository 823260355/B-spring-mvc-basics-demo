package com.thoughtworks.capacity.gtb.demo3;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  // GET /cars
  @GetMapping("")
  public List<Car> getAllCars() {
    return carService.getAllCars();
  }

  // POST /cars
  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public void createCar(@RequestBody Car car) {
    carService.createCar(car);
  }

  // GET /cars/3
  @GetMapping("/{id}")
  public Car getCarByIdRestful(@PathVariable("id") Integer id) {
    return carService.getCarById(id);
  }
}
