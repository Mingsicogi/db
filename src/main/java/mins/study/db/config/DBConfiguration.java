package mins.study.db.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import mins.study.db.config.properties.JdbcProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

import static mins.study.db.app.common.constant.DbConstantCommon.*;

@Slf4j
@Configuration
public class DBConfiguration {

    @Resource
    private JdbcProperties jdbcProperties;

    private final GenericApplicationContext context;

    @Value("${mins-db.shard.cnt}")
    private int shardCount;

    public DBConfiguration(GenericApplicationContext context) {
        this.context = context;
    }

    @Bean
    @Primary
    public void afterPropertiesSet() {
        for (int i = 0; i < shardCount; i++) {
            // datasource setting
            HikariDataSource hikariDataSource = new HikariDataSource();
            hikariDataSource.setJdbcUrl(jdbcProperties.getUrl().get(i));
            hikariDataSource.setUsername(jdbcProperties.getUsername().get(i));
            hikariDataSource.setPassword(jdbcProperties.getPassword().get(i));
            context.registerBean(commonDatasourceBeanName + i, DataSource.class, () -> hikariDataSource);

            // jpa entity manager setting
            LocalContainerEntityManagerFactoryBean entityManagerFactory =
                    new EnableJpaRepositoryWithEntityManagerFactoryBean().getLocalContainerEntityManagerFactoryBean(hikariDataSource);
            context.registerBean(commonJpaEntityManagerBeanName + i, LocalContainerEntityManagerFactoryBean.class, () -> entityManagerFactory);

            // jpa transaction manager setting
            JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
            jpaTransactionManager.setEntityManagerFactory(context.getBean(commonJpaEntityManagerBeanName + i, EntityManagerFactory.class));
            context.registerBean(commonTransactionManagerBeanName + i, PlatformTransactionManager.class, () -> jpaTransactionManager);
        }
    }

    static final class EnableJpaRepositoryWithEntityManagerFactoryBean {
        protected LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(DataSource dataSource) {
            LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setPackagesToScan("mins.study.db.app");

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
}
