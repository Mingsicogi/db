package mins.study.db.app.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mins.study.db.app.common.entity.Common;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal extends Common {

    private String name;

    public Animal(Long id, String name) {
        super(id);
        this.name = name;
    }
}
