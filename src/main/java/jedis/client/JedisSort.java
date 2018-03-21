package jedis.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class JedisSort {
    public static void main(String[] args) {
        Jedis jedis= new Jedis("localhost");
        jedis.rpush("sort-input","23","15","110","7");
        jedis.hset("d-7","field","5");
        jedis.hset("d-15","field","1");
        jedis.hset("d-23","field","9");
        jedis.hset("d-110","field","3");
        SortingParams sortingParams = new SortingParams();
        sortingParams.by("d-*->field");
        sortingParams.get("d-*->field");
        System.out.println(jedis.sort("sort-input",sortingParams));





    }
}
