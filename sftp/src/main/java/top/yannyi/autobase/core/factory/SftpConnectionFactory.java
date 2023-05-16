package top.yannyi.autobase.core.factory;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import top.yannyi.autobase.core.properties.SftpProperties;

/**
 * SFTP连接工厂，用于创建、包装和销毁SFTP连接对象
 */

@Slf4j
public class SftpConnectionFactory extends BasePooledObjectFactory<ChannelSftp> {

    // SFTP连接池配置
    private final SftpProperties config;


    /**
     * 构造函数，初始化SFTP连接池配置
     *
     * @param config SFTP连接池配置
     */
    public SftpConnectionFactory(final SftpProperties config) {
        this.config = config;
    }

    /**
     * 创建SFTP连接对象
     *
     * @return SFTP连接对象
     * @throws Exception 创建连接对象时可能抛出异常
     */
    @Override
    public ChannelSftp create() throws Exception {
        JSch jsch = new JSch();
        if (config.getPrivateKey() != null && !config.getPrivateKey().isEmpty()) {
            jsch.addIdentity(config.getPrivateKey(), config.getPassphrase());
        }
        Session session = jsch.getSession(config.getUsername(), config.getIp(), config.getPort());
        session.setPassword(config.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(config.getConnectTimeout());
        ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
        channel.connect(config.getReadTimeout());
        log.info("created connection {}", channel);
        return channel;
    }

    /**
     * 包装SFTP连接对象
     *
     * @param channel SFTP连接对象
     * @return 将SFTP连接对象封装成对象池对象
     */

    @Override
    public PooledObject<ChannelSftp> wrap(ChannelSftp channel) {
        return new DefaultPooledObject<>(channel);
    }


    /**
     * 验证对象是否可用，若不可用，则销毁对象
     *
     * @param pooledObject SFTP连接对象
     * @return 连接对象是否可用
     */
    @Override
    public boolean validateObject(PooledObject<ChannelSftp> pooledObject) {
        log.debug("validateObject : {}", pooledObject);
        return pooledObject.getObject().isConnected();
    }


    /**
     * 销毁SFTP连接对象
     *
     * @param pooledObject SFTP连接对象
     * @throws Exception 销毁连接对象时可能抛出异常
     */
    @Override
    public void destroyObject(PooledObject<ChannelSftp> pooledObject) throws Exception {
        if (pooledObject.getObject().isConnected()) {
            log.debug("Destroying connection {}", pooledObject);
            pooledObject.getObject().disconnect();
        }
    }
}
