package top.yannyi.autobase.core.factory;

import com.jcraft.jsch.ChannelSftp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import top.yannyi.autobase.core.properties.SftpProperties;

/**
 * @Author: LeahAna
 * @Date: 2023/4/4 14:10
 * @Desc: sftp连接池
 */

@Slf4j
public class SftpConnectionPool {

    private final GenericObjectPool<ChannelSftp> pool;

    public SftpConnectionPool(SftpProperties sftpProperties) {
        SftpConnectionFactory factory = new SftpConnectionFactory(sftpProperties);
        GenericObjectPoolConfig<ChannelSftp> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(sftpProperties.getMaxTotal());
        config.setMaxIdle(sftpProperties.getMaxIdle());
        config.setMinIdle(sftpProperties.getMinIdle());
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        pool = new GenericObjectPool<>(factory, config);
        pool.setSwallowedExceptionListener(e -> log.error("Exception in SftpConnectionPool", e));
        log.info("SftpConnectionPool init success ");
    }

    public ChannelSftp borrowConnection() throws Exception {
        return pool.borrowObject();
    }

    public void returnConnection(ChannelSftp connection) {
        pool.returnObject(connection);
    }

    public GenericObjectPool<ChannelSftp> getPool() {
        return pool;
    }

    public void shutdown() {
        pool.clear();
        pool.close();
    }

}
