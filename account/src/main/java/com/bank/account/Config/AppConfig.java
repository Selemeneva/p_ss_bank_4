package com.bank.account.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories(basePackages = {"com.bank.account.Repository"})
public class AppConfig {

}
