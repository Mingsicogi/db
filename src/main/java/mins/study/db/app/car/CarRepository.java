package mins.study.db.app.car;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {

    Optional<Car> findCarByName(String name);
}
