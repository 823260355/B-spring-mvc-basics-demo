package com.thoughtworks.capacity.gtb.demo3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
    return carMap.get(id);
  }
}
