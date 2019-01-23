package pl.bpiekarz.carrental.Car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    String id;
    String name;
    String model;
    Integer capacity;
    String segment;
    Integer yearOfManufacture;
}
