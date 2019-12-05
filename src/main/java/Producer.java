import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author hdl
 * @create 2019/12/4-16:56
 */
public class Producer{
        public static void main(String[] args) throws InterruptedException {
            Jedis jedis=RedisUtil.getJedis();
            jedis.select(4);
            int count=0;
            while(count<100){
                Thread.sleep(300);
                jedis.lpush("mylist",String.valueOf(count));
                count++;
            }
            jedis.close();
        }
    }





