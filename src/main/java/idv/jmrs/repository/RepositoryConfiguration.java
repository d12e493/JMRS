package idv.jmrs.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "idv.jmrs.entity" })
@EnableJpaRepositories(basePackages = { "idv.jmrs.repository" })
@EnableTransactionManagement
public class RepositoryConfiguration {
}
