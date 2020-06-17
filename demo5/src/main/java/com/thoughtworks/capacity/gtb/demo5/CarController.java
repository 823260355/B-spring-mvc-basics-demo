package com.thoughtworks.capacity.gtb.demo5;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@Validated
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
  public void createCar(@RequestBody @Valid Car car) {
    carService.createCar(car);
  }

  // GET /cars/3
  @GetMapping("/{id}")
  public Car getCarByIdRestful(@PathVariable("id") @Min(1) Integer id) {
    Car car = carService.getCarById(id);
    if (car == null) {
//      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not found");
      throw new CarNotFoundException("car not found");
    }
    return car;
  }
}
