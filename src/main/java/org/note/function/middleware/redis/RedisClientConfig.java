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
//        setConfig(config);
        setClusterServers(config);
        return Redisson.create(config);
    }

    private void setConfig(Config config) {
//        config.setCodec(null);
//        config.setAddressResolverGroupFactory(null);
        config.setCleanUpKeysAmount(100);
//        config.setEventLoopGroup(null);
//        config.setExecutor(null);
        // 保持订阅发布顺序 默认true
        // 通过该参数来修改是否按订阅发布消息的接收顺序出来消息，
        // 如果选否将对消息实行并行处理，该参数只适用于订阅发布消息的情况。
        config.setKeepPubSubOrder(false);
        config.setLockWatchdogTimeout(1500);
        config.setMaxCleanUpDelay(1000);
        config.setMinCleanUpDelay(1000);
//        config.setNettyHook(null);
        config.setNettyThreads(5);
        config.setReferenceEnabled(false);
        config.setUseThreadClassLoader(false);
//        config.setTransportMode(null);
        config.setUseScriptCache(false);
    }

    private void setClusterServers(Config config) {
        ClusterServersConfig clusterConfig = config.useClusterServers();
        clusterConfig.addNodeAddress("redis://192.168.15.128:7001", "redis://192.168.15.128:7002","redis://192.168.15.128:7003", "redis://192.168.15.128:7004", "redis://192.168.15.128:7005", "redis://192.168.15.128:7006");
        clusterConfig.setScanInterval(2000);
//        clusterConfig.setMasterConnectionPoolSize(64);
//        clusterConfig.setIdleConnectionTimeout(3000);
//        clusterConfig.setConnectTimeout(10000);
//        clusterConfig.setTimeout(3000);
//        clusterConfig.setRetryAttempts(3);
//        clusterConfig.setReadMode(ReadMode.SLAVE);
//        clusterConfig.setLoadBalancer(new RandomLoadBalancer());
    }


}
