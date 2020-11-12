package com.zl.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    static JedisPoolConfig config;//null
    static JedisPool jedisPool;//null

    static {//一次
        config = new JedisPoolConfig();
        jedisPool = new JedisPool(config, "localhost", 6379);
    }

    public static Jedis getJedis() {
        //JedisPoolConfig config = new JedisPoolConfig();
        //JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        Jedis jedis = jedisPool.getResource();

        //jedis.set("code", "999");
        //jedis.del("code");
        //System.out.println(jedis.get("code"));
        //jedis.close();//而是回到连接池反复使用提高效率性能
        return jedis;
    }

    public static void close(Jedis jedis) {
        //jedis.notnull
        if (jedis != null) {
            jedis.close();//回到连接池
        }
    }
}
