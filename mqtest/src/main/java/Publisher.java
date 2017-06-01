import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;

/**
 * Created by aaa on 2017/5/9.
 */
public class Publisher {   //发布者
    // 等待10个订阅者
    private static final int SUBSCRIBERS_EXPECTED = 10;
    private final static Logger log = LoggerFactory.getLogger(Publisher.class);

    public static void main(String[] args) throws InterruptedException {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://*:5557");
        try {
            // 发送速度太快，在订阅者尚未与发布者建立联系时开始数据发布
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        publisher.send("send start......".getBytes(), 0);
        for (int i = 0; i < 10; i++) {
            publisher.send(("Hello world " + i).getBytes(), ZMQ.NOBLOCK);
        }
        publisher.send("send end......".getBytes(), 0);

        publisher.close();
        context.term();
    }
}
