package com.thoughtworks.capacity.gtb.demo5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CarService {

  private Map<Integer, Car> carMap = new HashMap<>();

  public CarService() {
    carMap.put(1, new Car(1, "BMV", "white"));
    carMap.put(2, new Car(2, "Benz", "black"));
  }

  public List<Car> getCars(String color, String type) {
    return carMap.values().stream()
            .filter(car -> color == null || car.getColor().equals(color))
            .filter(car -> type == null || car.getType().equals(type))
            .collect(Collectors.toList());
  }

  public void createCar(Car car) {
    carMap.put(car.getId(), car);
  }

  public Car getCarById(Integer id) {
    Car car = carMap.get(id);
    if (car == null) {
      throw new CarNotFoundException("car not found");
    }
    return car;
  }
}
