/**
 * @author hdl
 * @create 2019/12/4-17:16
 */
public class redis_main {
    public static void main(String[] args) {
        Consumer mq1 = new Consumer("mq1");
        Consumer mq2 = new Consumer("mq2");
        Consumer mq3 = new Consumer("mq3");
        mq1.start();
        mq2.start();
        mq3.start();

    }
}
