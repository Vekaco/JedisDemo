package jedis.client;

import redis.clients.jedis.Jedis;

public class JedisExpire {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("localhost");
       // System.out.println(jedis.get("expire"));
        jedis.set("expire","123");
        jedis.expire("expire",20);
        Thread.sleep(5000);
        System.out.println(jedis.ttl("expire"));

    }
}
