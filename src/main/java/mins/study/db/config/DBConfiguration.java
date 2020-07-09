package mins.study.db.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import mins.study.db.config.properties.JdbcProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@Configuration
public class DBConfiguration {

    @Resource
    JdbcProperties jdbcProperties;

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
