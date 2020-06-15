package com.thoughtworks.capacity.gtb.demo2;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

  // GET /car?id=3
  @RequestMapping(value = "/car", method = RequestMethod.GET)
  @ResponseBody
  public Car getCarById(@RequestParam("id") Integer id) {
    return carService.getCarById(id);
  }

  // GET /cars/3
  @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Car getCarByIdRestful(@PathVariable("id") Integer id) {
    return carService.getCarById(id);
  }
}
