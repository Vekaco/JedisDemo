package jedis.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.concurrent.CountDownLatch;


public class Listener {
    public static void main(String[] args) throws InterruptedException {
        final Jedis jedis = new Jedis("localhost");
        final CountDownLatch messageDownLatch = new CountDownLatch(4);
        final JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println(message);
                messageDownLatch.countDown();
            }

            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                super.onUnsubscribe(channel, subscribedChannels);
                System.out.println("Unsubscribed");
            }
        };

        new Thread(new Runnable() {
            public void run() {
                jedis.subscribe(jedisPubSub, "channel1");
            }
        }).start();

        messageDownLatch.await();
        jedisPubSub.unsubscribe("channel1");
    }
}
