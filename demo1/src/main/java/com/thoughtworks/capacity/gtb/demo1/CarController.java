package com.thoughtworks.capacity.gtb.demo1;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  // GET /cars
  @RequestMapping(value = "/cars", method = RequestMethod.GET)
  @ResponseBody
  public List<Car> getAllCars() {
    return carService.getAllCars();
  }

  // POST /cars
  @RequestMapping(value = "/cars", method = RequestMethod.POST)
  @ResponseBody
  public void createCar(@RequestBody Car car) {
    carService.createCar(car);
  }
}
