package mins.study.db.app.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AnimalCustomRepository {
    void refresh(Animal animal);
}
