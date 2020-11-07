package org.note.function.middleware.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.connection.balancer.RandomLoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisClientConfig {

    @Bean
    public RedissonClient redisClient2() {
        Config config = new Config();
        setConfig(config);
        setClusterServers(config);
        return Redisson.create(config);
    }

    private void setConfig(Config config) {
        config.setCodec(null);
        config.setAddressResolverGroupFactory(null);
        config.setCleanUpKeysAmount(100);
        config.setEventLoopGroup(null);
        config.setExecutor(null);
        // 保持订阅发布顺序 默认true
        // 通过该参数来修改是否按订阅发布消息的接收顺序出来消息，
        // 如果选否将对消息实行并行处理，该参数只适用于订阅发布消息的情况。
        config.setKeepPubSubOrder(false);
        config.setLockWatchdogTimeout(15L);
        config.setMaxCleanUpDelay(11);
        config.setMinCleanUpDelay(11);
        config.setNettyHook(null);
        config.setNettyThreads(11);
        config.setReferenceEnabled(false);
        config.setUseThreadClassLoader(false);
        config.setTransportMode(null);
        config.setUseScriptCache(false);
    }

    private void setClusterServers(Config config) {
        ClusterServersConfig clusterConfig = config.useClusterServers();
        clusterConfig.addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001");
        clusterConfig.setMasterConnectionPoolSize(20);
        clusterConfig.setScanInterval(2000);
        clusterConfig.setIdleConnectionTimeout(10);
        clusterConfig.setConnectTimeout(23);
        clusterConfig.setTimeout(12);
        clusterConfig.setRetryAttempts(3);
        clusterConfig.setReadMode(ReadMode.SLAVE);
        clusterConfig.setLoadBalancer(new RandomLoadBalancer());
    }


}
