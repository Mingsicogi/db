package mins.study.db.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc.properties")
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

    @Bean(value = "minsDb2DataSource")
    public DataSource minsDb2DataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(minsDb2Url);
        hikariDataSource.setUsername(minsDb2Username);
        hikariDataSource.setPassword(minsDb2Password);

        return hikariDataSource;
    }
}
