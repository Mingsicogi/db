package mins.study.db.app.animal;

import lombok.RequiredArgsConstructor;
import mins.study.db.app.common.utils.DBUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalRepository animalRepository;
    private final DBUtil dbUtil;

    @GetMapping("/animal/add")
    public ResponseEntity<String> animalAdd(String name) {
        animalRepository.save(new Animal(1L, name));
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/animal/get")
    public ResponseEntity<Animal> animalGet(String name) {
        return ResponseEntity.ok(animalRepository.findAnimalByName(name).orElseThrow());
    }
}
