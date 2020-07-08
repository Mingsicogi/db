package mins.study.db.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class JPAConfiguration {

    @Slf4j
    @Configuration
    @EnableJpaRepositories(
            basePackages = "mins.study.db.app.car",
            entityManagerFactoryRef = "minsDBEntityManagerFactory",
            transactionManagerRef = "minsDbTransactionManager"
    )
    public static class MinsDBEntityManagerFactory {
        @Bean(value = "minsDBEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean minsDBEntityManagerFactory(@Qualifier("minsDbDataSource") DataSource dataSource) {
            return getLocalContainerEntityManagerFactoryBean(dataSource, "mins.study.db.app.car");
        }
    }

    @Slf4j
    @Configuration
    @EnableJpaRepositories(
            basePackages = "mins.study.db.app.animal",
            entityManagerFactoryRef = "minsDB2EntityManagerFactory",
            transactionManagerRef = "minsDb2TransactionManager"
    )
    public static class MinsDB2EntityManagerFactory {
        @Bean(value = "minsDB2EntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean minsDB2EntityManagerFactory(@Qualifier("minsDb2DataSource") DataSource dataSource) {
            return getLocalContainerEntityManagerFactoryBean(dataSource, "mins.study.db.app.animal");
        }
    }

    protected static LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(
            @Qualifier("minsDbDataSource") DataSource dataSource, String scanPackageName) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan(scanPackageName);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.show-sql", true);
        properties.put("hibernate.use_sql_comment", true);
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(properties);
        return em;
    }
}
