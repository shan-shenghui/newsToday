package com.wd;

import com.wd.until.getPropertieFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Properties;

/**
 * Created by aaa on 2017/4/17.
 */
public final class RedisPool {
    //Redis服务器IP
    public static String ADDR = "";
    //Redis的端口号
    public static Integer PORT = 0;
    //访问密码
//    private static String AUTH = "";

    //可用连接实例的最大数目，默认为8；
    //如果赋值为-1，则表示不限制，如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
    private static Integer MAX_TOTAL = 0;
    //控制一个pool最多有多少个状态为idle(空闲)的jedis实例，默认值是8
    private static Integer MAX_IDLE = 0;

    //等待可用连接的最大时间，单位是毫秒，默认值为-1，表示永不超时。
    //如果超过等待时间，则直接抛出JedisConnectionException
    private static Integer MAX_WAIT_MILLIS = 0;
    private static Integer TIMEOUT = 0;

    //在borrow(用)一个jedis实例时，是否提前进行validate(验证)操作；
    //如果为true，则得到的jedis实例均是可用的
    private static Boolean TEST_ON_BORROW = false;

    private static JedisPool jedisPool = null;

    static {
        try {
            Properties properties = getPropertieFile.getProperties();
            ADDR = properties.getProperty("addr");
            PORT = Integer.parseInt(properties.getProperty("port"));
            MAX_TOTAL = Integer.parseInt(properties.getProperty("MAX_TOTAL"));
            MAX_IDLE = Integer.parseInt(properties.getProperty("MAX_IDLE"));
            MAX_WAIT_MILLIS = Integer.parseInt(properties.getProperty("MAX_WAIT_MILLIS"));
            TIMEOUT = Integer.parseInt(properties.getProperty("TIMEOUT"));
            TEST_ON_BORROW = Boolean.parseBoolean(properties.getProperty("TEST_ON_BORROW"));


            JedisPoolConfig config = new JedisPoolConfig();
         /*注意：
            在高版本的jedis jar包，比如本版本2.9.0，JedisPoolConfig没有setMaxActive和setMaxWait属性了
            这是因为高版本中官方废弃了此方法，用以下两个属性替换。
            maxActive  ==>  maxTotal
            maxWait==>  maxWaitMillis
         */
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT_MILLIS);
            config.setTestOnBorrow(TEST_ON_BORROW);

            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取Jedis实例
     *
     * @return
     */
    public static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis jedis = jedisPool.getResource();
                return jedis;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (!jedisPool.isClosed()) {
                jedisPool.close();
            }
        }

    }
}
