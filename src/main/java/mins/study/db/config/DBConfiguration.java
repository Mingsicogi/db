package mins.study.db.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class DBConfiguration {

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new HikariDataSource();

        return dataSource;
    }
}
