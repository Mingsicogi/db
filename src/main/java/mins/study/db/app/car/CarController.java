package mins.study.db.app.car;

import lombok.RequiredArgsConstructor;
import mins.study.db.app.common.utils.DBUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;
    private final DBUtil dbUtil;

    @GetMapping("/car/add")
    public ResponseEntity<String> carAdd(String name) {
        carRepository.save(new Car(1L, name));
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/car/get")
    public ResponseEntity<Car> carGet(String name) {
        return ResponseEntity.ok(carRepository.findCarByName(name).orElseThrow());
    }
}
