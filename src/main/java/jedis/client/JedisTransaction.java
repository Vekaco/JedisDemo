package jedis.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTransaction {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        Transaction transaction = jedis.multi();
        transaction.sadd("transaction","m1");
        transaction.sadd("transaction", "m2");
        transaction.exec();
        System.out.println(jedis.smembers("transaction"));
    }
}
