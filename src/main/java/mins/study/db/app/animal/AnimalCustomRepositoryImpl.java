package mins.study.db.app.animal;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static mins.study.db.app.common.constant.DbConstantCommon.commonJpaEntityManagerBeanName;

public class AnimalCustomRepositoryImpl implements AnimalCustomRepository {

    private EntityManager entityManager;

    private final GenericApplicationContext context;

    public AnimalCustomRepositoryImpl(String id, GenericApplicationContext context) {
        this.entityManager = context.getBean(commonJpaEntityManagerBeanName + "0", EntityManager.class);
        this.context = context;
    }

    @Override
    @Transactional
    public void refresh(Animal animal) {
        entityManager.refresh(animal);
    }
}
