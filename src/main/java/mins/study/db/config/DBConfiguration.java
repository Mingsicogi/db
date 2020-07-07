package mins.study.db.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableJpaRepositories(
        basePackages = "mins.study",
        entityManagerFactoryRef = "minsDBEntityManagerFactory"
)
public class DBConfiguration {

    @Value("${minsDB.datasource.url}")
    private String minsDbUrl;

    @Value("${minsDB.datasource.username}")
    private String minsDbUsername;

    @Value("${minsDB.datasource.password}")
    private String minsDbPassword;

    @Value("${minsDB2.datasource.url}")
    private String minsDb2Url;

    @Value("${minsDB2.datasource.username}")
    private String minsDb2Username;

    @Value("${minsDB2.datasource.password}")
    private String minsDb2Password;

    @Bean(value = "minsDbDataSource")
    public DataSource minsDbDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(minsDbUrl);
        hikariDataSource.setUsername(minsDbUsername);
        hikariDataSource.setPassword(minsDbPassword);

        return hikariDataSource;
    }

//    @Bean(value = "minsDb2DataSource")
//    public DataSource minsDb2DataSource() {
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        hikariDataSource.setJdbcUrl(minsDb2Url);
//        hikariDataSource.setUsername(minsDb2Username);
//        hikariDataSource.setPassword(minsDb2Password);
//
//        return hikariDataSource;
//    }

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${spring.jpa.show-sql}")
    private boolean showSql;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private boolean formatSql;

    @Value("${spring.jpa.properties.hibernate.use_sql_comment}")
    private boolean useSqlComment;

    @Bean(value = "minsDBEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean minsDBEntityManagerFactory(@Qualifier("minsDbDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("mins.study");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", ddlAuto);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.use_sql_comment", useSqlComment);
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(properties);

        return em;
    }
//
//    @Bean(value = "minsDB2EntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean minsDB2EntityManagerFactory(@Qualifier("minsDb2DataSource") DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", ddlAuto);
//        properties.put("hibernate.format_sql", formatSql);
//        properties.put("hibernate.use_sql_comment", useSqlComment);
//        em.setDataSource(dataSource);
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
}
