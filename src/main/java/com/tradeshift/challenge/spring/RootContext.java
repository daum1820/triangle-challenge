package com.tradeshift.challenge.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(redisNamespace = "tradeshift", maxInactiveIntervalInSeconds = 18000)
public class RootContext {

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

    @Bean(name = "redisConnectionFactory")
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

}
