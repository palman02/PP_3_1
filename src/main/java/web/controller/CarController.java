package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.ServiceCar;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/car")
    public String getListCar(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("mark", 123, 1990));
        cars.add(new Car("mark2", 465, 1995));
        cars.add(new Car("silia", 789, 1996));
        cars.add(new Car("octavia", 159, 2005));
        cars.add(new Car("skoda", 123, 2010));

        model.addAttribute("cars", ServiceCar.getListCar(cars, count));
        return "/car";
    }
}
