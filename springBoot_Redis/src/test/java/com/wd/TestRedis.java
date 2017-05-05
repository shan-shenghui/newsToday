package com.wd;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by aaa on 2017/4/17.
 * list map返回的其实就是个数组 【】
 */
public class TestRedis {
    private Jedis jedis;

    @Before
    public void setJedis() {
        //连接服务器 本地
        jedis = RedisPool.getJedis();
        System.out.print("服务器连接成功！\n");
    }

    @Test
    public void insertStr() {
        jedis.set("name", "sshcx");
        System.out.println("拼接前:" + jedis.get("name"));
        jedis.append("name", "cxcx");
        System.out.println("拼接后:" + jedis.get("name"));
        jedis.del("name");
        System.out.println("删除后:" + jedis.get("name"));
        jedis.mset("name2", "chenhaoxiang", "age", "20", "email", "chxpostbox@outlook.com");
        jedis.incr("age");  //数值型自增一
        System.out.println(jedis.get("name") + " " + jedis.get("name2") + " " + jedis.get("age") + " " + jedis.get("email"));

    }


    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "xcx");
        map.put("age", "100");
        map.put("email", "***@outlook.com");
        jedis.hmset("user", map);
        List<String> list = jedis.hmget("user", "name", "age", "email");
        System.out.println(list);

        //删除map中某个键值
//        jedis.hdel("name");
        System.out.println("age:" + jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println("user的键中存放的值的个数:" + jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println("是否存在key为user的记录:" + jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println("user对象中的所有key:" + jedis.hkeys("user"));//返回user对象中的所有key
        System.out.println("user对象中的所有value:" + jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iterator = jedis.hkeys("user").iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
        jedis.del("user");
        System.out.println("删除后是否存在key为user的记录:" + jedis.exists("user"));//是否存在key为user的记录
    }

    /*
    * jedis list
    *
    * */
    @Test
    public void testList() {
//        jedis.del("javaFramwork");
        jedis.lpush("javaFramework", "spring"); //插入到头
        jedis.lpush("javaFramework", "springMVC");
        jedis.lpush("javaFramework", "mybatis");
        System.out.print(jedis.llen("javaFramework"));
        //jedis.llen获取长度，-1表示取得所有
        System.out.println("javaFramework:" + jedis.lrange("javaFramework", 0, -1));
        jedis.del("javaFramework");
        System.out.println("删除后长度:" + jedis.llen("javaFramework"));
        System.out.println(jedis.lrange("javaFramework", 0, -1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet() {
        jedis.sadd("user", "chenhaoxiang");
        jedis.sadd("user", "hu");
        jedis.sadd("user", "chen");
        jedis.sadd("user", "xiyu");
        jedis.sadd("user", "chx");
        jedis.sadd("user", "are");
        System.out.println("user中的value:" + jedis.smembers("user"));//获取所有加入user的value
        jedis.srem("user", "are");
        System.out.println("user中的value:" + jedis.smembers("user"));//获取所有加入user的value

    }

    /**
     * 排序
     */
    @Test
    public void test() {
        jedis.del("number");//先删除数据，再进行测试
        jedis.rpush("number", "4");//将一个或多个值插入到列表的尾部(最右边)
        jedis.rpush("number", "5");
        jedis.rpush("number", "3");
        jedis.lpush("number", "9");//将一个或多个值插入到列表头部
        jedis.lpush("number", "1");
        jedis.lpush("number", "2");
        System.out.println(jedis.lrange("number", 0, jedis.llen("number")));
        System.out.println(jedis.lrange("number", 0, -1));
        System.out.println("排序:" + jedis.sort("number"));
        System.out.println(jedis.lrange("number", 0, -1));//不改变原来的排序
        jedis.del("number");//测试完删除数据
    }
}
