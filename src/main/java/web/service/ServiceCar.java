package web.service;

import web.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceCar {

    public static List<Car> getListCar(List<Car> list, int count) {
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
