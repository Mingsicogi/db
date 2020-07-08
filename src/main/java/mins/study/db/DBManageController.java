package mins.study.db;

import lombok.RequiredArgsConstructor;
import mins.study.db.app.animal.Animal;
import mins.study.db.app.car.Car;
import mins.study.db.app.animal.AnimalRepository;
import mins.study.db.app.car.CarRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DBManageController {
@Qualifier
//    private final DataSource dataSource;

    private final CarRepository carRepository;
    private final AnimalRepository animalRepository;

    @GetMapping("/get/dbInfo")
    public ResponseEntity<String> getInfo() throws Exception{
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/car/add")
    public ResponseEntity<String> carAdd(String name) {
        carRepository.save(new Car(name));
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/car/get")
    public ResponseEntity<Car> carGet(String name) {
        return ResponseEntity.ok(carRepository.findCarByName(name).orElseThrow());
    }

    @GetMapping("/animal/add")
    public ResponseEntity<String> animalAdd(String name) {
        animalRepository.save(new Animal(name));
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/animal/get")
    public ResponseEntity<Animal> animalGet(String name) {
        return ResponseEntity.ok(animalRepository.findAnimalByName(name).orElseThrow());
    }
}
