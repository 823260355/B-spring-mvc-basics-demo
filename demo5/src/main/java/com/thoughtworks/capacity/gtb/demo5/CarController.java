package com.thoughtworks.capacity.gtb.demo5;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@Validated
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  /// GET /cars
  @GetMapping
  public List<Car> getCars(@RequestParam(name = "color", required = false) String color) {
    return carService.getCars(color, null);
  }

  // POST /cars
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createCar(@RequestBody @Valid Car car) {
    carService.createCar(car);
  }

  // GET /cars/3
  @GetMapping("/{id}")
  public Car getCarByIdRestful(@PathVariable("id") @Min(1) Integer id) {
   return carService.getCarById(id);
  }
}
