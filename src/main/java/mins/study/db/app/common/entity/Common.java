package mins.study.db.app.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Common {
    @Id
    private Long id;
}
