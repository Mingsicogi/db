package mins.study.db.app.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface AnimalRepository extends JpaRepository<Animal, String> {

}
