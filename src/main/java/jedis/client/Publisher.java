package jedis.client;

import redis.clients.jedis.Jedis;

public class Publisher {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.publish("channel1","Hello");
        jedis.publish("channel1",",");
        jedis.publish("channel1", "World");
        jedis.publish("channel1", "!");

    }
}
