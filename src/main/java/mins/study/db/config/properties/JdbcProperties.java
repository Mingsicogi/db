package mins.study.db.config.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
@ConfigurationProperties(prefix = "mins-db.datasource")
@Getter
@Setter
@Slf4j
public class JdbcProperties {
    private List<String> url;
    private List<String> username;
    private List<String> password;
}
