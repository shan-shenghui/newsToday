import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;

/**
 * Created by aaa on 2017/5/9.
 */
public class Subscriber {   //订阅者
    private final static Logger log = LoggerFactory.getLogger(Subscriber.class);

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5557");
        subscriber.subscribe("".getBytes());
        int total = 0;
        while (true) {
            byte[] stringValue = subscriber.recv(0);
            String string = new String(stringValue);
            if (string.equals("send end......")) {
                break;
            }
            total++;
            log.info("fds" + total);
            System.out.println("Received " + total + " updates. :" + string);
        }

        subscriber.close();
        context.term();
    }
}
