package pl.bpiekarz.carrental.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarRepo carRepo;

    @GetMapping("/cars")
    List<Car> getAll(){
        Car car = new Car("id1","citroen","xara",1000,"rich",1998);
        carRepo.save(car);
        return  carRepo.findAll();
    }

    @GetMapping("/cars/{id}")
    Car getCar(@PathVariable String id){
        return carRepo.findById(id).orElseThrow(()-> new RuntimeException("no such car"));
    }

    @PostMapping("/cars")
    void addCar(@RequestBody Car car){
        carRepo.save(car);
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable String id){
        carRepo.deleteById(id);
    }

    @PutMapping("/cars/{id}")
    void update(@PathVariable String id,@RequestBody Car car){
        Car tempCar = carRepo.findById(id).orElseThrow(()-> new RuntimeException("no such car"));

        tempCar.setCapacity(car.getCapacity());
        tempCar.setModel(car.getModel());
        tempCar.setYearOfManufacture(car.getYearOfManufacture());
        tempCar.setSegment(car.getSegment());
        tempCar.setName(car.getName());

        carRepo.save(tempCar);

    }
}
