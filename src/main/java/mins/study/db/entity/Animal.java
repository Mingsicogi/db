package mins.study.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Animal(String name) {
        this.name = name;
    }
}
