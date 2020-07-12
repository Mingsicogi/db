package mins.study.db.app.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequiredArgsConstructor
public class DBManageController {
//    @Qualifier
//    private final DataSource dataSource;

//    private final CarRepository carRepository;
//    private final AnimalRepository animalRepository;

    private final GenericApplicationContext context;

    @GetMapping("/get/dbInfo")
    public ResponseEntity<String> getInfo() throws Exception{
        DataSource shard_datasource_0 = context.getBean("shard_datasource_0", DataSource.class);

        return ResponseEntity.ok("OK");
    }

//    @GetMapping("/car/add")
//    public ResponseEntity<String> carAdd(String name) {
//        carRepository.save(new Car(name));
//        return ResponseEntity.ok("OK");
//    }
//
//    @GetMapping("/car/get")
//    public ResponseEntity<Car> carGet(String name) {
//        return ResponseEntity.ok(carRepository.findCarByName(name).orElseThrow());
//    }
//
//    @GetMapping("/animal/add")
//    public ResponseEntity<String> animalAdd(String name) {
//        animalRepository.save(new Animal(name));
//        return ResponseEntity.ok("OK");
//    }
//
//    @GetMapping("/animal/get")
//    public ResponseEntity<Animal> animalGet(String name) {
//        return ResponseEntity.ok(animalRepository.findAnimalByName(name).orElseThrow());
//    }
}
