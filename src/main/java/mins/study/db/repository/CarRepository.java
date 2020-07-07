package mins.study.db.repository;

import mins.study.db.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findCarByName(String name);
}
