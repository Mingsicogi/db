package mins.study.db.app.animal;

import mins.study.db.app.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Optional<Animal> findAnimalByName(String name);
}
