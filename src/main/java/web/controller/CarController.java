package web.controller;

import models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private static final List<Car> carStorage = new ArrayList<>();

    static {
        carStorage.add(new Car(777, "Lada", "Crimson"));
        carStorage.add(new Car(54, "Toyota", "Black"));
        carStorage.add(new Car(7, "Aston Martin", "Grey"));
        carStorage.add(new Car(14, "Jeep", "Red"));
        carStorage.add(new Car(88, "BMW", "Blue"));
    }

    @GetMapping(value = "/cars", params = "count")
    public String printCars(ModelMap model, @RequestParam int count) {
        return printNCars(model, count <= 5 ? count : 5);
    }

    @GetMapping(value = "/cars")
    public String printAllCars(ModelMap model) {
        return printNCars(model, 5);
    }

    private String printNCars(ModelMap model, int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(carStorage.get(i));
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
