package mins.study.db.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
public class TransactionConfiguration {

    @Bean(value = "minsDbTransactionManager")
    public PlatformTransactionManager minsDbTransactionManager(
            @Qualifier("minsDBEntityManagerFactory") EntityManagerFactory minsDBEntityManagerFactory)
    {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(minsDBEntityManagerFactory);

        return jpaTransactionManager;
    }

    @Bean(value = "minsDb2TransactionManager")
    public PlatformTransactionManager minsDb2TransactionManager(
            @Qualifier("minsDB2EntityManagerFactory") EntityManagerFactory minsDB2EntityManagerFactory)
    {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(minsDB2EntityManagerFactory);

        return jpaTransactionManager;
    }
}
