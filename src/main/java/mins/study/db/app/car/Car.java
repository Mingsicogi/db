package mins.study.db.app.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mins.study.db.app.common.entity.Common;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car extends Common {

    private String name;

    public Car(Long id, String name) {
        super(id);
        this.name = name;
    }
}
