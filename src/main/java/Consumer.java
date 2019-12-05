import redis.clients.jedis.Jedis;

import java.util.List;




/**
 * @author hdl
 * @create 2019/12/4-16:04
 */
public class Consumer extends Thread{
    String name;

    public Consumer(String name) {
        this.name = name;
    }

    @Override
    public void run(){


        while(true) {

            Jedis jedis = RedisUtil.getJedis();
            jedis.select(4);
            //阻塞式brpop，List中无数据时阻塞
            //参数0表示一直阻塞下去，直到List出现数据
            List<String> list = jedis.blpop(0, "mylist");
            for(String s : list) {
                System.out.println(name+"   "+s);
            }
            jedis.close();

        }



    }
}
