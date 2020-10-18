package com.thoughtworks.capacity.gtb.demo3;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  // GET /cars
  @GetMapping
  public List<Car> getAllCars(@RequestParam(name = "color", required = false) String color) {
    return carService.getCars(color, null);
  }

  // POST /cars
  @PostMapping
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
