package com.baidu.sso.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;

/**
 * @Author: FDM
 * @Date: 2021/4/17 11:42
 * @Version 1.0
 */
@Configuration
@PropertySource(value = "classpath:redis.properties")
public class RedisSpringConfig {

    @Value("${redis.maxTotal}")
    private Integer redisMaxTotal;

    @Value("${redis.node.host}")
    private String redisNodeHost;

    @Value("${redis.node.port}")
    private Integer redisNodePort;

    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisMaxTotal);
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool getJedisPool() { // 省略第一个参数则是采用Protocol.DETABASE
        return new JedisPool(jedisPoolConfig(), redisNodeHost, redisNodePort);
    }

    @Bean
    public ShardedJedisPool shardedJedisPool() {
        ArrayList<JedisShardInfo> jedisShardInfos = new ArrayList<>();
        jedisShardInfos.add(new JedisShardInfo(redisNodeHost, redisNodePort));
        return new ShardedJedisPool(jedisPoolConfig(), jedisShardInfos);
    }
}
